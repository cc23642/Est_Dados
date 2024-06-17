public class ListaEncadeadaSimplesDesordenada<X> extends NoSimples<X> {

    private NoSimples<X> primeiro =null;

    public void guadeNoInicio(X i)throws Exception{
        if (i==null)throw new Exception("informação ausente");
        this.primeiro = new NoSimples<X> (i, this.primeiro);
    }

    @SuppressWarnings("unused")// não precisamos da menságem de uso
    private NoSimples<X> ultimo = null;
    public void guardaNoFinal(X i) throws Exception{
        if(i==null)throw new Exception("informação ausente");
        if(this.primeiro==null){this.primeiro = new NoSimples<X>(i);}
        NoSimples<X> atual = this.primeiro;
        while(atual.getProx()!=null){
            atual=atual.getProx();
        }
        this.ultimo = new NoSimples<X> (i);
        atual.setProx(new NoSimples<X>(i));
    }



    public boolean tem (X i){
        NoSimples<X> atual=this.primeiro;
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
        NoSimples<X> atual = this.primeiro.getProx();
        while (atual!=null) {
            ret+=", "+atual.getInfo();
            atual=atual.getProx();
        }
        return ret+"]";
    }



    public boolean equals (ListaEncadeadaSimplesDesordenada<X> obj){
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






    //prof nos decidimos fazer todas as classes herdarem de No o que seria mais fácil do que reescreve-lo em todos os arquivos
    //e até aqui tudo bem, porém tem este erro onde o construtor implícito de No está indefinido eu defini ele como
    //nulo mas não sei se é o correto por não termos como mudar a inormação de um nó diretamente por ser um atributo privado.
    //se puder se lembrar dessa dúvida em aula por favor explique para mim (Murilo).

    /*
    na classe NoSimples:

    public NoSimples()
    {
        this.info = null;
        this.prox = null;
    }
    */

    // ListaEncadeadaSimplesDesordenada(ListaEncadeadaSimplesDesordenada<X> modelo)throws Exception
    // ERROR:   Implicit super constructor NoSimples<X>() is undefined. Must explicitly invoke another constructor
    public ListaEncadeadaSimplesDesordenada(ListaEncadeadaSimplesDesordenada<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("modelo nulo");
        if(modelo.primeiro==null){
            this.primeiro=null;
            return;
        }
        this.primeiro = new NoSimples<X>(modelo.primeiro.getInfo());
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoModelo = modelo.primeiro.getProx();

        while (atualdoModelo!=null){
            atualDoThis.setProx(new NoSimples<X> (atualdoModelo.getInfo()));
            atualDoThis = atualDoThis.getProx();
            atualdoModelo = atualdoModelo.getProx();
        }
    }
    //outro connstrutor
    public ListaEncadeadaSimplesDesordenada(){
        this.primeiro=null;
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
        
        NoSimples<X> atual = this.primeiro;
        while(atual.getProx().getProx()!=null){
            atual = atual.getProx();
        }
        atual.setProx(null);
    }



    //1) public X getPrimeiro () thows Exception

    public X getPrimeiro() throws Exception{
         if(this.primeiro==null) throw new Exception("ponteiro nulo");
         X infoPrimeiro = this.primeiro.getInfo();
         return infoPrimeiro;
    }



    //2) public X getUltimo () thows Exception
    public X getUltimo()throws Exception{
        if(this.primeiro==null)throw new Exception("ponteiro nulo");
        NoSimples<X> atual = this.primeiro;
        while(atual.getProx()!=null){
            atual=atual.getProx();
        }
        
        X infoUltimo = atual.getInfo();
        return infoUltimo;
    }



    //3) public X get (int posicao) thows Exception
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
            index++;
            atual = atual.getProx();
        }//após isso estaremos uma posição antes da posição dada.
        atual.setProx(atual.getProx().getProx());//o elemento anterior pula um elemento e pega o ponteiro do seguinte
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
            atual = atual.getProx();
        }return count;
    }

    
    public void inverter() {
        if (this.primeiro == null || this.primeiro.getProx() == null) {
            return;
        }
        
        NoSimples<X> atual = this.primeiro;
        NoSimples<X> anterior = null;
        NoSimples<X> proximo = null;
    
        while (atual != null) {
            proximo = atual.getProx();
            atual.setProx(anterior);
            anterior = atual;
            atual = proximo;
        }
        this.primeiro = anterior;
    }
    

}

