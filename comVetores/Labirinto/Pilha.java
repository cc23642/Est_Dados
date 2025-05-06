//System.gc() chama o lixeiro do java!!!!!!!!!!!!!!!!!


//class classe x.getClass
//class<?>[]tipo params = null
//Method metodo = classe.getMethid(`clone`,tipo params)
//parms = null
//ret = (X)metodo.invoke(x,parms)

public class Pilha <X> implements Cloneable{
    private Object[] vetor;

    //tamanho inicial serve para que o vetor nunca seje menor que o tamanho qual ele vfoi instanciado
    // private final int tamanhoInicial;

    private int topo;

    public int getTopo(){
        return this.topo;
    }

    public Pilha(){
        this.vetor = new Object[10];
        this.topo = 0;
        //this.tamanhoInicial = 10
    }

    //throws Exception

    public Pilha(int tamanho){
        //validar se o tamanho for menor que 1, por que não podemos ter uma lista vazia ou tamanho 0 para baixo
        //if(tamanho>0){
        //  this.tamanhoInicial = tamanho
        //}else{throw new Exception()}
        this.vetor = new Object[tamanho];
        this.topo = 0;
    }

    public Pilha(Pilha<X> modelo){
        //this.vetor = modelo.vetor;
        //eu tava certo e fiz errado tem que cirar outro vetor novo com new
        this.vetor = new Object[getTopo()];
        for(Object obj:modelo.vetor){
            //xxxxxxxxxxxx
        }
        this.topo = modelo.topo;
    }

    public void incluaUmItem(X item) throws Exception{
        //tamanho inicial
        if(item!=null){
            if(this.topo==this.vetor.length){
                redimencioneSe(); 
            }
            X itemclonado = cloneItem(item);
            this.vetor[this.topo] = item;
            this.topo++;
        }else throw new Exception("não e possivel inserir um valor nulo");
    }

    public X recupereUmItem() throws Exception{
        try{
            X itemclone = cloneItem((X)vetor[this.topo-1]);
            return itemclone;
            
        }catch(ClassCastException e){
            throw new Exception(e);
        } 
    }

    public void removaUmItem(){
        //tamanho inicial
        if(this.topo<this.vetor.length*0.25) redimencioneSe();
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
        //não ultrapassar o limite negativamente do valor inicial (não pode ser menor que o valor inicial)
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
            return (X) item.getClass().getMethod("clone",null).invoke(item,null);

        } catch (Exception e) {
            throw new Exception("Erro ao clonar o item", e);
        }
    }
    
    public String toString(){
        String ret = "[";
        for(Object item : this.vetor){
            ret+="***, ";
        }
        return ret+=this.vetor[topo]+"]";
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