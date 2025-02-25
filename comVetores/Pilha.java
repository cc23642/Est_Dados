public class Pilha <X> {
    private Object[] vetor;
    private int topo;

    public int getTopo(){return this.topo;}
    public void setTopo(int novoTopo){this.topo = novoTopo;}

    public Pilha(){
        this.vetor = new Object[10];
        this.topo = 0;
    }

    public Pilha(int tamanho){
        this.vetor = new Object[tamanho];
        this.topo = 0;
    }

    public void incluaUmItem(X item) throws Exception{
        if(item!=null){
            if(isCheia()) redimencioneSe();
            this.vetor[this.topo] = item;
            this.topo++;
        }else throw new Exception("não e possivel inserir um valor nulo");
    }

    public X recupereUmItem() throws Exception{

        try{

            return((X)vetor[this.topo]);

        }catch(Exception e){
            throw new Exception();
        } 
    }

    public void removaUmItem(){
        if(isVazia()) redimencioneSe();
        this.vetor[this.topo] = null;
        this.topo--;
    }

    public boolean isCheia(){
        if(this.topo==this.vetor.length){
            return true;
        }else{return false;}
    }

    public boolean isVazia(){
        if(this.topo<this.vetor.length*0.25){
            return true;
        }else{return false;}
    }

    public void redimencioneSe(){
        // meu tenebroso medo
        /**
         * se estiver cheia{ novo vetor com tamanho dobrado
         * transferir os dados do vetor original para o novo vetor
         * fazer o vetor original ser o novo vetor }
         * 
         * se nao, se estiver vazia{ novo vetor com o tamanho dividido por 2
         * transferir os dados do vetor original para o novo vetor com tamanho reduzido
         * fazer o vetor original guardar o novo vetor }
         * 
         * se nao, ir embora
         */
    }
    
}