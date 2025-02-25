public class Pilha <X> implements Cloneable{
    private Object[] vetor;
    private int topo;


    Clonador<X> clonador = new Clonador<X>();

    public Pilha(){
        this.vetor = new Object[10];
        this.topo = 0;
    }

    public Pilha(int tamanho){
        this.vetor = new Object[tamanho];
        this.topo = 0;
    }

    public Pilha(Pilha<X> modelo){
        this.vetor = modelo.vetor;
        this.topo = modelo.topo;
    }

    public void incluaUmItem(X item) throws Exception{
        if(item!=null){
            if(isCheia()){
                redimencioneSe(); 
            }
            try {
                X itemclonado = clonador.clone(item);
                this.vetor[this.topo] = itemclonado;
            } catch (Exception e) {
                this.vetor[this.topo] = item;
            }
            this.topo++;
        }else throw new Exception("não e possivel inserir um valor nulo");
    }

    public X recupereUmItem() throws Exception{
        try{
            X itemclone = clonador.clone((X)vetor[this.topo-1]);
            return itemclone;
            
        }catch(ClassCastException e){
            throw new Exception(e);
        } 
    }

    public void removaUmItem(){
        if(isVazia()) redimencioneSe();
        this.vetor[this.topo-1] = null;
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
        if(isCheia()){
            Object[] auxiliar = new Object[this.vetor.length*2];
            for(int i=0; i<topo; i++){
                auxiliar[i] = this.vetor[i];
            }
            this.vetor = auxiliar;
        }
        if(isVazia()){
            Object[] auxiliar = new Object[(int)Math.ceil(this.vetor.length*0.5)];
            for(int i=0; i<topo; i++){
                auxiliar[i] = this.vetor[i];
            }
            this.vetor = auxiliar;
        }
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
    private X cloneItem(X item) throws Exception {
        try {
            return (X) item.getClass().getMethod("clone").invoke(item);

        } catch (Exception e) {
            throw new Exception("Erro ao clonar o item", e);
        }
    }
    
    public String toString(){
        String ret = "[";
        for(Object item : this.vetor){
            ret+=item.toString()+", ";
        }
        return ret+="]";
    }
    @Override
    public boolean equals(Object obj) {
        try{
            Pilha outro = (Pilha)obj;
            if(outro.vetor.equals(this.vetor)){
                if(outro.topo == this.topo){
                    return true;
                }
            }
        }catch(ClassCastException e){}
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int ret = 0;
        ret += this.topo*hash;
        ret += this.vetor.hashCode()*hash;
        return ret;
    }
    
}