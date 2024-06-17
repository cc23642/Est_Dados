public class ListaEncadeadaSimplesOrdenada<X>{
    private NoSimples<X> primeiro =null;

    public boolean tem (X i){
        NoSimples<X> atual=this.primeiro;
        while(atual!=null){
            if(atual.info.equals(i))return true;
            atual = atual.getProx();
        }
        return false;
    }

    @Override
    public String toString(){
        String ret="[";
        if (this.primeiro==null) return "[]";//se o valor for nulo retorna lista vazia
        ret += this.primeiro.getInfo().toString();
        NoSimples<X> atual = this.primeiro.getProx();
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
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoObj = ((ListaEncadeadaSimplesOrdenada<X>)obj).primeiro;

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

    public ListaEncadeadaSimplesOrdenada(ListaEncadeadaSimplesOrdenada<X> modelo)throws Exception{
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
        ListaEncadeadaSimplesDesordenada<X> ret=null;

        try{
            ret= new ListaEncadeadaSimplesDesordenada<X>(this);
        }catch (Exception erro){}
        return ret;
    }

    public void removaPrimeiro() throws Exception
    {
        if(this.primeiro==null)throw new Exception("Nó inválido");
        this.primeiro = this.primeiro.getProx();//atributo primeiro como "o segund item da lista", ou seja o primeiro passaa ser o próximo número
    }



    //5) public void removaUltimo () thows Exception
    public void removaUltimo() throws Exception
    {
        if(this.primeiro==null)throw new Exception("lista vazia");
        if(this.primeiro.getProx()==null){primeiro.getProx().setProx(null);}
        
        No atual = this.primeiro;
        while(atual.getProx()!=null){
            atual = atual.getProx();
        }
        atual.setProx(null);
    }



    //1) public X getPrimeiro () thows Exception

    public X getPrimeiro() throws Exception{
         if(this.primeiro==null) throw new Exception("ponteiro nulo");
         X infoPrimeiro = new Clonador<X>().clone(this.primeiro.getInfo());
         return infoPrimeiro;
    }



    //2) public X getUltimo () thows Exception
    public X getUltimo()throws Exception{
        if(this.primeiro==null)throw new Exception("ponteiro nulo");
        NoSimples<X> atual = this.primeiro;
        while(atual.getProx()!=null){
            atual=atual.getProx();
        }
        
        X infoUltimo = new Clonador<X>().clone(this.atual.getInfo());
        return infoUltimo;
    }



    //3) public X get (int posicao) thows Exception
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
    public void remova(int posicao)throws Exception{
        if(posicao<0||posicao>this.tamanho())throw new Exception("Posição inválida");
        if(posicao == 0)removaPrimeiro();

        NoSimples<X> atual = this.primeiro;
        int index = 0;
        while(index<posicao){
            atual = atual.getProx();
        }
        atual.setProx(atual.getProx().prox);
    }

    private int tamanho(){
        if(this.primeiro==null){return 0;}
        int count =0;
        NoSimples<X> atual = this.primeiro;
        while (atual.getProx()!=null) {
            count ++;
        }return count;
    }

    public void inverter()
    {
        NoSimples<X> atual = this.primeiro;
        int posi = tamanho();
        int index = 0;
        while(index < tamanho() && posi!=0){
            while(atual !=null){atual=atual.getProx();}
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
    public void inserir(X info)throws Exception{
        NoSimples<X> atual = this.primeiro;
        if(info == null)throw new Exception("informação ausente");
        for(int i=0; i<tamanho();i++){
            if(info>atual.getInfo() && info<atual.getProx().getInfo()){
                NoSimples<X> inserir = new No(info,atual.getProx());
                atual.setProx(inserir);
            }
            atual = atual.getProx();
        }
    }

}
