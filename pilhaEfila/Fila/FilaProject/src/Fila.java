public class Fila<X> {
    NoSimples<X> primeiro;

    private int capacidade;

    private FilaResgate<X> filaResgate;

    public int getCapacidade(){
        return this.capacidade;
    }
    public void setCapacidade(int novaC){
        this.capacidade = novaC;
    }

    public Fila(){
        this.primeiro = null;
        this.capacidade = 0 ;
        this.filaResgate = new FilaResgate<X>(this.capacidade);
    }

    public Fila(int c){
        this.primeiro = null;
        this.capacidade = c;
        this.filaResgate = new FilaResgate<X>(this.capacidade);

    }

    public Fila(Fila<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("Modelo nulo");
        this.capacidade = modelo.getCapacidade();
        this.filaResgate = new FilaResgate<X>(this.capacidade);
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

    public void remova() throws Exception
    {
        if(this.primeiro==null)throw new Exception("Nó inválido");
        NoSimples<X> atual = this.primeiro;
        while (atual.getProx().getProx()!=null) {
            atual=atual.getProx();
        }
        filaResgate.guarde(atual.getProx().getInfo());
        atual.setProx(null);;
    }

    public void recupere() throws Exception
    {
        if(this.filaResgate.getUltimo()!=null){
            guarde(this.filaResgate.getUltimo());
            this.filaResgate.remova();
        }
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

    public X getPrimeiro() throws Exception{
        if(this.primeiro==null) throw new Exception("ponteiro nulo");
        X infoPrimeiro = this.primeiro.getInfo();
        return infoPrimeiro;
    }

    public X getUltimo() throws Exception{
        if(this.primeiro==null) throw new Exception("ponteiro nulo");
        NoSimples<X> atual = this.primeiro;
        while (atual.getProx()!=null) {
            atual=atual.getProx();
        }
        X infoUltimo = atual.getInfo();
        return infoUltimo;
    }

    public boolean chekcapacidade(Fila<X> pilha){
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

    public boolean equals (Fila<X> obj){
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj.getClass()!=this.getClass()) return false;
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoObj = (obj).primeiro;

        while(atualDoThis != null && atualdoObj != null)return false;
        return true;
    }
}
