public class HashMap<K,V>{
    private class Elemento{// implementado
        private K chave;
        private V valor;

        public Elemento(K c, V v)throws Exception{
            if(c == null){throw new Exception("invalid null value");}
            if(v == null){throw new Exception("invalid null value");}
            this.chave = c;
            this.valor = v;
        }

        public String toString(){
            return "'"+this.chave+"' : '"+this.valor+"'";
        }

        public boolean equals(Elemento obj)throws Exception{
            if(obj == null)throw new Exception("invalid null value");

            if(this.getClass() == obj.getClass()){
                if(this.chave == obj.getChave()){
                    if(this.valor == obj.getValor()){
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int hashCode(){
            int ret = 2;
            ret+= 17 * chave.hashCode();
            ret+= 17 * valor.hashCode();
            return ret;
        }

        public V getValor() {
            return this.valor;
        }
        
        public void setValor(V newValor)throws Exception{
            //esperando que o valor passado foi validado antes de chamar o método
            if(newValor==null)throw new Exception("invalid null value");
            else{
                this.valor = newValor;
            }
        }

        private void setChave(K newValor)throws Exception{
            if(newValor==null)throw new Exception("invalid null value");
            else{
                this.chave = newValor;
            }
        }

        public K getChave() {
            return this.chave;
        }
    }

    private ListaEncadeadaSimplesDesordenada<Elemento>[] vetor;
    private int qtdElementos = 0;
    private int qtdOcupacao = 0;
    private int tamanho = 0;
    private float taxDispMin = 0;
    private float taxDispMax = 0;

    public HashMap(int tamanhoInicial, float taxMax, float taxMin){
        this.taxDispMax = taxMax;
        this.taxDispMin = taxMin;
        this.vetor = new ListaEncadeadaSimplesDesordenada[tamanhoInicial];
    }

    //getters
    public ListaEncadeadaSimplesDesordenada<Elemento>[] getVetor(){ return this.vetor; }
    public int getQtdElementos(){ return this.qtdElementos; }
    public int getQtdOcupacao(){ return this.qtdOcupacao; }
    public int getTamanho(){ return this.tamanho; }
    public float getDespMax(){ return this.taxDispMax; }
    public float getDespMin(){ return this.taxDispMin; }

    //setters
    public void setQtdElementos(int value) throws Exception{this.qtdElementos = value;}
    public void setQtdOcupacao(int value) throws Exception{this.qtdOcupacao = value;}
    public void setTamanho(int value) throws Exception{this.tamanho = value;}
    public void setDespMax(float newMax) throws Exception{this.taxDispMax = newMax;}
    public void setDespMin(float newMin) throws Exception{this.taxDispMin = newMin;}

    @Override
    public int hashCode() {
        int ret = 2;
        ret+= 17 * qtdElementos;
        ret+= 17 * qtdOcupacao;
        ret+= 17 * tamanho;
        ret+= 17 * taxDispMax;
        ret+= 17 * taxDispMin;
        ret+= 17 * vetor.hashCode();

        return ret;

    }

    public boolean equals(HashMap hashObj){
        if(this.qtdElementos ==  hashObj.getQtdElementos()){
            if(this.qtdOcupacao == hashObj.getQtdOcupacao()){
                if(this.tamanho == hashObj.getTamanho()){
                    if(this.taxDispMax == hashObj.getDespMax()){
                        if(this.taxDispMin == hashObj.getDespMin()){
                            if(vetor.equals(hashObj.getVetor())){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString(){
        String ret = "[";
        for(int i=0; i<tamanho;i++){
            ret += vetor[i].toString()+ ", ";
        }
        return ret+"]";
    }

    //implementando
    public void inserirUmItem(K chave, V valor){
        int posicao = 0;
        Elemento newElemento =  Elemento(chave, valor);
        int hChave = chave.hashCode();
        posicao =  hChave%tamanho;
        vetor[hash()]
    }

    public int hash(Elemento e)throws Exception{
        int ret = 2;
        if(e==null){throw new Exception("objeto nulo");}

        return ret;
    }

    
}