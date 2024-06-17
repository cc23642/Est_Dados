import org.w3c.dom.Notation;




//Criar a classe clonador

public class ListaEncadeadaSimplesDesordenada<X> {
    private class No{
        private X info;
        private No prox;

        public No (X i, No p){
            this.info = i;
            this.prox = p;
        }

        public No(X i){
            this.info=i;
            this.prox=null;
        }

        public X getInfo(){
            return this.info;
        }

        public No getProx(){
            return this.prox;
        }
        public void setInfo(X i){
            this.info = i;
        }
        public void setProx(No p){
            this.prox = p;
        }

        //metodos obrigatórios da classe No

        @Override
        public String toString(){
            return ""+this.info.toString();
        }

        @Override
        public boolean equals(Object obj){
            if(obj==this) return true;//se for da classe No
            if(obj==null) return false;//se guardar valor nulo
            if(obj.getClass()!=this.getClass()) return false;//se as classes dos objetos não forem as mesmas
            if(!(No)obj.info().equals(this.info())) return false;//se o a informação do objeto for diferente da informação da classe No
            return true;
        }

        @Override
        public int hashCode(){
            int ret=1;
            ret=2*ret+this.getInfo().hashCode();
            if(ret<0) ret=-ret;
            return ret;
        }
        //a classe Clonador não existe
        public No (No modelo)throws Exception{
            if(modelo==null)throw new Exception("modelo nulo");
            if(modelo.getInfo() instanceof Cloneable){
                this.info = new Clonador<X>().clone(modelo.info);
            }
            else this.info = modelo.info;
        }
        public Object clone(){
            No ret=null;
            try{
                ret=new No(this);
            }
            catch(Exception erro){}//so da erro se rceber parametro nulo, e this numquinha é nulo
        }
    }

    private No primeiro =null;



    public void guadeNoInicio(X i)throws Exception{
        if (i==null)throw new Exception("informação ausente");
        this.primeiro = new No (i, this.primeiro);
    }


    private No ultimo = null;
    public void guardaNoFinal(X i) throws Exception{
        if(i==null)throw new Exception("informação ausente");
        No atual = this.primeiro;
        while(atual.getProx()!=null){
            atual=atual.getProx();
        }
        this.ultimo = new No (i);
        atual.setProx(new No(i));
    }



    public boolean tem (X i){
        No atual=this.primeiro;
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
        ret=(String)this.primeiro.getInfo();
        No atual = this.primeiro.getProx();
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
        No atualDoThis = this.primeiro;
        No atualdoObj = ((ListaEncadeadaSimplesDesordenada<X>)obj).primeiro;

        while(atualDoThis != null && atualdoObj != null)return false;
        return true;
    }



    public int hashCode(){
        int ret=1;

        No atual=this.primeiro;
        while(atual!=null){
            ret=ret*2+atual.getInfo().hashCode();
            atual=atual.getProx();
        }

        if(ret<0) ret=-ret;
        return ret;
    }



    public ListaEncadeadaSimplesDesordenada(ListaEncadeadaSimplesDesordenada<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("modelo nulo");
        if(modelo.primeiro==null){
            this.primeiro=null;
            return;
        }
        this.primeiro=new No(modelo.primeiro.getInfo());
        No atualDoThis = this.primeiro;
        No atualdoModelo = modelo.primeiro.getProx();

        while (atualdoModelo!=null){
            atualDoThis.setProx(new No (atualdoModelo.getInfo()));
            atualDoThis = atualDoThis.getProx();
            atualdoModelo = atualdoModelo.getProx();
        }
    }




    public ListaEncadeadaSimplesDesordenada() {
        //TODO Auto-generated constructor stub
    }



    public Object clone(){
        ListaEncadeadaSimplesDesordenada<X> ret=null;

        try{
            ret= new ListaEncadeadaSimplesDesordenada<X>(this);
        }catch (Exception erro){}
        return ret;
    }



    //6) public void remova (int posicao) thows Exception
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
        No atual = this.primeiro;
        while(atual.getProx()!=null){
            atual=atual.getProx();
        }
        
        X infoUltimo = new Clonador<X>().clone(this.atual.getInfo());
        return infoUltimo;
    }



    //3) public X get (int posicao) thows Exception
    public X get (int posicao) throws Exception{
        No atual = this.primeiro;
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

        No atual = this.primeiro;
        int index = 0;
        while(index<posicao){
            atual = atual.getProx();
        }//após isso estaremos uma posição antes da posição dada.
        atual.setProx(atual.getProx().prox);//o elemento anterior pula um elemento e pega o ponteiro do seguinte
    }



    /*
     * Digamos que a lista tenha n nós incluir na posição 0 é incluir no inicio. Incluir na posição
     * 1, é incluir entre o 1° e o2° nó, e assim por diante.
     * INCLUIR NA POSIÇÃO N é incluir no último/final, inserir em posições maiores que n ou menores que 0
     * levam a excesão.
    */
    public void guardeEm (int posicao, X i)throws Exception{
        if(posicao<0 || posicao> this.tamanho()){
            throw new Exception("valor fora de escopo");
        }
        No atual = this.primeiro;
        if(posicao==0)this.guadeNoInicio(i);
        int index = 0;
        while (index<posicao) {
            atual = atual.getProx();
        }
        No guardePosicao = new No(i, atual.getProx());
        atual.setProx(guardePosicao);
    }



    private int tamanho(){
        if(this.primeiro==null){return 0;}
        int count =0;
        No atual = this.primeiro;
        while (atual.getProx()!=null) {
            count ++;
        }return count;
    }

    public void inverter()
    {
        No atual = this.primeiro;
        int posi = tamanho();
        int index = 0;
        while(index < tamanho() && posi!=0){
            while(atual !=null){atual=atual.getProx();}//ultimo elemento
            No ultimoElem = atual;
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

