public class ListaEncadeadaCircularDesordenada<X> extends NoSimples<X>{
    private NoSimples<X> primeiro = null;

    public ListaEncadeadaCircularDesordenada(){
        this.primeiro=null;
    }

    public void guadeNoInicio(X i)throws Exception{
        if (i==null)throw new Exception("informação ausente");
        this.primeiro = new NoSimples<X> (i, this.primeiro);
    }


    private NoSimples<X> ultimo = null;
    public void guardaNoFinal(X i) throws Exception{
        if(i==null)throw new Exception("informação ausente");
        if(this.primeiro==null){this.primeiro = new NoSimples<X>(i);}
        NoSimples<X> atual = this.primeiro;
        while(atual.getProx()!=this.primeiro){
            atual=atual.getProx();
        }
        this.ultimo = new NoSimples<X> (i,this.primeiro);
        atual.setProx(ultimo);
    }



    public boolean tem (X i){
        NoSimples<X> atual=this.primeiro;
        while(atual.getProx()!=this.primeiro){
            if(atual.getInfo().equals(i))return true;
            atual = atual.getProx();
        }
        return false;
    }



    @Override
    public String toString(){
        String ret="[";
        if (this.primeiro==null) return "[]";
        ret += this.primeiro.getInfo().toString();
        NoSimples<X> atual = this.primeiro.getProx();
        while (atual.getProx()!=this.primeiro) {
            ret+=", "+atual.getInfo();
            atual=atual.getProx();
        }
        return ret+"]";
    }



    public boolean equals (ListaEncadeadaCircularDesordenada<X> obj){
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj.getClass()!=this.getClass()) return false;
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoObj = (obj).primeiro;

        while(atualDoThis != null && atualdoObj != null)return false;
        return true;
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



    public ListaEncadeadaCircularDesordenada(ListaEncadeadaCircularDesordenada<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("modelo nulo");
        if(modelo.primeiro==null){
            this.primeiro=null;
            return;
        }
        this.primeiro=new NoSimples<X>(modelo.primeiro.getInfo());
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoModelo = modelo.primeiro.getProx();

        while (atualdoModelo!=null){
            atualDoThis.setProx(new NoSimples<X> (atualdoModelo.getInfo()));
            atualDoThis = atualDoThis.getProx();
            atualdoModelo = atualdoModelo.getProx();
        }
    }


    public Object clone(){
        ListaEncadeadaCircularDesordenada<X> ret=null;

        try{
            ret= new ListaEncadeadaCircularDesordenada<X>(this);
        }catch (Exception erro){}
        return ret;
    }

    public void removaPrimeiro() throws Exception
    {
        if(this.primeiro==null)throw new Exception("Nó inválido");
        this.primeiro = this.primeiro.getProx();
    }


    public void removaUltimo() throws Exception
    {
        if(this.primeiro==null)throw new Exception("lista vazia");
        if(this.primeiro.getProx()==primeiro){primeiro.getProx().setProx(primeiro);}
        
        NoSimples<X> atual = this.primeiro;
        while(atual.getProx()!=primeiro){
            atual = atual.getProx();
        }
        atual.setProx(primeiro);
    }

    public X getPrimeiro() throws Exception{
         if(this.primeiro==null) throw new Exception("ponteiro nulo");
         return this.primeiro.getInfo();
    }

    public X getUltimo()throws Exception{
        if(this.primeiro==null)throw new Exception("ponteiro nulo");
        NoSimples<X> atual = this.primeiro;
        while(atual.getProx()!=this.primeiro){
            atual = atual.getProx();
        }
        return atual.getInfo();
    }



    @SuppressWarnings("unused")// não precisamos da menságem de uso
    public X get (int posicao) throws Exception{
        NoSimples<X> atual = this.primeiro;
        int cout = 0;
        //tamanho da lista
        while(atual.getProx()!=null && cout<posicao){
            cout++;
            atual = atual.getProx();
        }
        //vai até a posição
        if(atual==null) throw new Exception("ponteiro nulo");
        else{
            X infoAtual = new Clonador<X>().clone(atual.getInfo());
            return infoAtual;
        }
    }



    //4) public void removaPrimeiro () thows Exception
    public void remova(int posicao)throws Exception{
        if(posicao<0||posicao>this.tamanho())throw new Exception("Posição inválida");
        if(posicao == 0)removaPrimeiro();

        NoSimples<X> atual = this.primeiro;
        int index = 0;
        while(index<posicao){
            atual = atual.getProx();
        }
        atual.setProx(atual.getProx().getProx());
    }

    public void guardeEm (int posicao, X i)throws Exception{
        if(posicao<0 || posicao> this.tamanho()){
            throw new Exception("valor fora de escopo");
        }
        NoSimples<X> atual = this.primeiro;
        if(posicao==0)this.guadeNoInicio(i);
        int index = 0;
        while (index<posicao) {
            atual = atual.getProx();
        }
        NoSimples<X> guardePosicao = new NoSimples<X>(i, atual.getProx());
        atual.setProx(guardePosicao);
    }



    private int tamanho(){
        if(this.primeiro==null){return 0;}
        int count =0;
        NoSimples<X> atual = this.primeiro;
        while (atual.getProx()!=null) {
            count ++;
        }return count;
    }

    @SuppressWarnings("null")//ultimo elemento só vai ser nulo quando toda a lista for invertida e o ultimo ponteiro estiver vazio
    public void inverter()
    {
        NoSimples<X> atual = this.primeiro;
        int posi = tamanho();
        int index = 0;
        while(index < tamanho() && posi!=0){
            while(atual !=null){atual=atual.getProx();}//ultimo elemento
            NoSimples<X> ultimoElem = atual;
            atual=this.primeiro;
            int aux =0;
            //anterior
            while (atual!=null && aux<posi) {
                aux++;
                atual=atual.getProx();
            }ultimoElem.setProx(atual);
            posi--;
        }
       
    }

}

