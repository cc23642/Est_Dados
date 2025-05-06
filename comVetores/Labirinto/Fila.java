public class Fila<X> implements Cloneable {
    private Object[] vetor;
    private int fim;

    public Fila(){
        this.vetor = new Object[10];
        this.fim = 0;
    }

    public Fila(int tamanho){
        this.vetor = new Object[tamanho];
        this.fim = 0;
    }

    public Fila(Fila<X> modelo){
        this.vetor = modelo.vetor;
        this.fim = modelo.fim;
    }

    public void incluaUmItem(X item) throws Exception{
        if(item!=null){
            if(isCheia()){
                redimencioneSe(); 
            }
            //X itemclonado = cloneItem(item);
            this.vetor[this.fim] = item;
            this.fim++;
        }else throw new Exception("não e possivel inserir um valor nulo");
    }

    public X recupereUmItem() throws Exception{
        try{
            X itemclone = cloneItem((X)vetor[0]);
            return itemclone;
            
        }catch(ClassCastException e){
            throw new Exception(e);
        } 
    }

    public void removaUmItem(){
        if(isVazia()) {redimencioneSe();}
        for(int i =0;i<fim;i++){
            vetor[i] = vetor[i+1];
        }vetor[fim-1] = null;
        this.fim--;
    }

    public boolean isCheia(){
        if(this.fim==this.vetor.length){
            return true;
        }else{return false;}
    }

    public boolean isVazia(){
        if(this.fim<this.vetor.length*0.25){
            return true;
        }else{return false;}
    }

    public void redimencioneSe(){
        if(isCheia()){
            Object[] auxiliar = new Object[this.vetor.length*2];
            for(int i=0; i<fim; i++){
                auxiliar[i] = this.vetor[i];
            }
            this.vetor = auxiliar;
        }
        if(isVazia()){
            Object[] auxiliar = new Object[(int)Math.ceil(this.vetor.length*0.5)];
            for(int i=0; i<fim; i++){
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
            if(item==null){ret+="nul, ";}
            else{
                ret+=item.toString()+", ";
            }
        }
        return ret+="]";
    }
    @Override
    public boolean equals(Object obj) {
        try{
            Fila outro = (Fila)obj;
            if(outro.vetor.equals(this.vetor)){
                if(outro.fim == this.fim){
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
        ret += this.fim*hash;
        ret += this.vetor.hashCode()*hash;
        return ret;
    }
    
}
