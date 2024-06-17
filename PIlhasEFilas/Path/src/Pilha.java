public class Pilha<X> {

    private NoSimples<X> primeiro;

    private int capacidade;

    PilhaResgate<X> pilhaResgate = new PilhaResgate<X>();

    public int getCapacidade(){
        return this.capacidade;
    }
    public void setCapacidade(int novaC){
        this.capacidade = novaC;
    }

    public Pilha(){
        this.primeiro = null;
        this.capacidade = 0 ;
    }

    public Pilha(int c){
        this.primeiro = null;
        this.capacidade = c;
    }

    public Pilha(Pilha<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("Modelo nulo");
        if(modelo.primeiro==null){
            this.primeiro = null;
        }
        this.primeiro =  new NoSimples<X>((X)modelo.primeiro.getInfo());
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoModelo = modelo.primeiro.getProx();

        while (atualdoModelo!=null){
            atualDoThis.setProx(new NoSimples<X> (atualdoModelo.getInfo()));
            atualDoThis = atualDoThis.getProx();
            atualdoModelo = atualdoModelo.getProx();
        }
    }

    public void guarde(X i)throws Exception{
        if(this.tamanho()<capacidade){
            if (i==null)throw new Exception("informação ausente");

            this.primeiro = new NoSimples<X> (i, this.primeiro);
        }
        
    }

    public boolean tem (X i){
        NoSimples<X> atual=this.primeiro;
        while(atual!=null){
            if(atual.getInfo().equals(i))return true;
            atual = atual.getProx();
        }
        return false;
    }

    public void remova() throws Exception
    {
        if(this.primeiro==null)throw new Exception("Nó inválido");
        this.primeiro = this.primeiro.getProx();
    }

    public void recupere() throws Exception{
        try{
            NoSimples<X> recuperado = pilhaResgate.recupere();
            if(recuperado!=null){this.guarde((X)recuperado.getInfo());}
        }catch (Exception e){throw new Exception(e);}
        
    }

    public X getPrimeiro() throws Exception{
        if(this.primeiro==null) throw new Exception("ponteiro nulo");
        X infoPrimeiro = this.primeiro.getInfo();
        return infoPrimeiro;
    }

    private int tamanho(){
        if(this.primeiro==null){return 0;}
        int count =0;
        NoSimples<X> atual = this.primeiro;
        while (atual.getProx()!=null) {
            count ++;
            atual = atual.getProx();
        }return count;
    }

    public boolean chekcapacidade(Pilha<X> pilha){
        if(pilha.tamanho()== this.capacidade) return true;
        if(pilha.tamanho()<  this.capacidade)return false;
        return false;

    }

    @Override
    public String toString(){
        String ret="[";
        if (this.primeiro==null) return "[]";
        ret += this.primeiro.getInfo().toString();
        return ret+"]";
    }

    public int hashCode(){
        int ret=1;

        NoSimples<X> atual=this.primeiro;
        while(atual!=null){
            ret=ret*2+atual.getInfo().hashCode();
            atual=atual.getProx();
        }

        if(ret<0) ret=-ret;
        return ret;
    }

    public boolean equals (Pilha<X> obj){
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj.getClass()!=this.getClass()) return false;
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoObj = (obj).primeiro;

        while(atualDoThis != null && atualdoObj != null)return false;
        return true;
    }
}
