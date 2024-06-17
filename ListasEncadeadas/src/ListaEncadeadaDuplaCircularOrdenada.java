public class ListaEncadeadaDuplaCircularOrdenada<X> implements Comparable<X> {
    private NoDuplo<X> primeiro = null;
    private X info;
    private NoDuplo<X> ultimo = null;

    public ListaEncadeadaDuplaCircularOrdenada(){
        this.primeiro = null;
        this.info = null;
    }

    public boolean tem (X i){
        NoDuplo<X> atual=this.primeiro;
        while(atual!=null){
            if(atual.getInfo().equals(i))return true;
            atual = atual.getProx();
        }
        return false;
    }

    
    @Override
    public String toString(){
        String ret="[";
        if (this.primeiro==null) return "[]";//se o valor for nulo retorna lista vazia
        ret += this.primeiro.getInfo().toString();
        NoDuplo<X> atual = this.primeiro.getProx();
        while (atual!=null) {
            ret+=", "+atual.getInfo();
            atual=atual.getProx();
        }
        return ret+"]";
    }



    public boolean equals (Object obj){
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj.getClass()!=this.getClass()) return false;
        NoDuplo<X> atualDoThis = this.primeiro;

        @SuppressWarnings("unchecked") // por nosso código ser genérico
        NoDuplo<X> atualdoObj = ((ListaEncadeadaDuplaCircularOrdenada<X>)obj).primeiro;

        while(atualDoThis != null && atualdoObj != null)return false;
        return true;
    }



    public int hashCode(){
        int ret=1;

        NoDuplo<X> atual=this.primeiro;
        while(atual!=null){
            ret=ret*2+atual.getInfo().hashCode();
            atual=atual.getProx();
        }

        if(ret<0) ret=-ret;
        return ret;
    }



    public ListaEncadeadaDuplaCircularOrdenada(ListaEncadeadaDuplaCircularOrdenada<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("modelo nulo");
        if(modelo.primeiro==null){
            this.primeiro=null;
            return;
        }
        this.primeiro=new NoDuplo<X>(modelo.primeiro.getInfo());
        NoDuplo<X> atualDoThis = this.primeiro;
        NoDuplo<X> atualdoModelo = modelo.primeiro.getProx();

        while (atualdoModelo!=null){
            atualDoThis.setProx(new NoDuplo<X> (atualdoModelo.getInfo()));
            atualDoThis = atualDoThis.getProx();
            atualdoModelo = atualdoModelo.getProx();
        }
    }


    public Object clone(){
        ListaEncadeadaDuplaCircularOrdenada<X> ret=null;

        try{
            ret= new ListaEncadeadaDuplaCircularOrdenada<X>(this);
        }catch (Exception erro){}
        return ret;
    }


    public void removaPrimeiro() throws Exception
    {

        if(this.primeiro==null)throw new Exception("Nó inválido");
        this.primeiro = this.primeiro.getProx();//atributo primeiro como "o segund item da lista", ou seja o primeiro passaa ser o próximo número
        this.primeiro.setAnt(ultimo);
    }

    public void removaUltimo() throws Exception
    {
        if(this.primeiro==null)throw new Exception("lista vazia");
        if(this.primeiro.getProx() == this.primeiro.getAnt()){
            this.primeiro.setAnt(this.primeiro);
            this.primeiro.setProx(this.primeiro);
        }
        NoDuplo<X> atual = this.primeiro;
        while(atual.getProx()!=this.primeiro){
            atual = atual.getProx();
        }
        atual.setProx(primeiro);
        this.primeiro.setAnt(atual);
    }
    public X getPrimeiro() throws Exception{
         if(this.primeiro==null) throw new Exception("ponteiro nulo");
         X infoPrimeiro = new Clonador<X>().clone(this.primeiro.getInfo());
         return infoPrimeiro;
    }

    public X getUltimo()throws Exception{
        if(this.primeiro==null)throw new Exception("ponteiro nulo");
        X infoUltimo = new Clonador<X>().clone(this.primeiro.getAnt().getInfo());
        return infoUltimo;
    }


    @SuppressWarnings("unused")
    public X get (int posicao) throws Exception{
        NoDuplo<X> atual = this.primeiro;
        int cout = 0;
        while(atual.getProx()!=this.primeiro && cout<posicao){
            cout++;
            atual = atual.getProx();
        }
        if(atual==null) throw new Exception("ponteiro nulo");
        else{
            X infoAtual = new Clonador<X>().clone(atual.getInfo());
            return infoAtual;
        }
    }

    public void remova(int posicao)throws Exception{
        if(posicao<0||posicao>this.tamanho())throw new Exception("Posição inválida");
        if(posicao == 0)removaPrimeiro();

        NoDuplo<X> atual = this.primeiro;
        int index = 0;
        while(index<posicao){
            atual = atual.getProx();
        }
        atual.setProx(atual.getProx().getProx());//o elemento anterior pula um elemento e pega o ponteiro do seguinte
        atual.getProx().setAnt(atual);
    }

    private int tamanho(){
        if(this.primeiro==null && this.ultimo==null){return 0;}
        int count =0;
        NoDuplo<X> atual = this.primeiro;
        while (atual.getProx()!=this.primeiro) {
            count ++;
            atual = atual.getProx();
        }return count;
    }
    
    public void inverter() {
        if (this.primeiro == null || this.primeiro.getProx() == null) {
            return;
        }
        
        NoDuplo<X> atual = this.primeiro;
        NoDuplo<X> anterior = null;
        NoDuplo<X> proximo = null;
    
        while (atual != null) {
            proximo = atual.getProx();
            atual.setProx(anterior);
            anterior = atual;
            atual = proximo;
        }
        this.primeiro = anterior;
    }


    @SuppressWarnings("unchecked")
    public void inserir(X info)throws Exception{
        NoDuplo<X> atual = this.primeiro;
        if(info == null)throw new Exception("informação ausente");
        for(int i=0; i<tamanho();i++){
            if(((Comparable<X>)info).compareTo(atual.getInfo()) > 0 && ((Comparable<X>)info).compareTo(atual.getProx().getInfo()) < 0){
                NoDuplo<X> inserir = new NoDuplo<X>(info, atual.getProx(), atual);
                atual.setProx(inserir);
            }
            if(atual.getProx()==this.primeiro)
                if(((Comparable<X>)info).compareTo(atual.getInfo()) > 0){
                    NoDuplo<X> inserir = new NoDuplo<X>(info, atual.getProx(), atual);
                    atual.setProx(inserir);
                }
            atual = atual.getProx();
        }
    }

    @Override // estava dando erro e pediu para sobrescrever o metodo compareTo
    public int compareTo(X comparadoX) {
        try{
            if((int)this.info > (int)comparadoX){return 1;}
            if((int)this.info < (int)comparadoX){return -1;}
            if(this.equals(comparadoX)){return 0;}
        }catch(ClassCastException error1){
            try{
                String valor = ""+this.info;
                String compareVal = ""+comparadoX;
                if(valor.compareTo(compareVal) >  0) return  1;
                if(valor.compareTo(compareVal) <  0) return -1;
                if(valor.compareTo(compareVal) == 0) return  0;
            }catch (ClassCastException error2){
                throw new UnsupportedOperationException("ERRO na reemprelemtação");
            }
        }
        return 0;
    }

}
