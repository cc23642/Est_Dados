import java.lang.ref.Cleaner.Cleanable;

public class Filaparada<X> {
    private Object[] elementos;
    private int inicio;
    private int termino;
    private int tamanhoInicial;
    private int quantidade;
    private Clonador<X> clonador;

    public int getQuantidade(){
        return this.quantidade;
    }
    public int getInicio() {
        return inicio;
    }
    public int getTermino() {
        return termino;
    }

    public Filaparada(){
        this.clonador = new Clonador<X>();
        this.elementos = new Object[10];
        this.tamanhoInicial = 10;
        this.inicio = 0;
        this.termino = 0;
        this.quantidade = 0;
    }

    public Filaparada(int quantidadeInicial) throws Exception{
        if(quantidadeInicial < 1){
            throw new Exception("Como voce pretende intanciar um vetor menor que 1? vai guardar o que nele meu filho!");
        }

        this.clonador = new Clonador<X>();
        this.elementos = new Object[quantidadeInicial];
        this.tamanhoInicial = quantidadeInicial;
        this.inicio = 0;
        this.termino = 0;
        this.quantidade = 0;
    }

    public Filaparada(Filaparada<X> modelo){
        this.elementos = new Object[modelo.getQuantidade()];
        int i = 0;
        for(Object obj:modelo.elementos){
            try{
                this.elementos[i] = (X)obj;
                i++;
            }catch(ClassCastException err){}
        }
        this.inicio = modelo.getInicio();
        this.termino = modelo.getTermino();
        this.quantidade = modelo.getQuantidade();
        this.clonador = new Clonador<X>();
        this.tamanhoInicial = modelo.getQuantidade();
    }

    public void adicionar(X item) throws Exception{

        if(item!=null){ throw new Exception("ta tentando inserir nada?");} 

        if(this.quantidade<this.elementos.length){
            if(this.elementos[termino]!=null){
                
                if(item instanceof Cleanable){
                    X cloneItem;
                    cloneItem = (X) this.clonador.clone(item);
                    this.elementos[termino] = cloneItem;
    
                }else{
                    this.elementos[termino] = item;
                }
    
                this.termino++;
                this.quantidade++;
            }else{/*redimensione se */}

        }else if(this.quantidade==this.elementos.length){
            if(this.elementos[0]==null){
                this.termino = 0;

                if(item instanceof Cleanable){
                    X cloneItem;
                    cloneItem = (X) this.clonador.clone(item);
                    this.elementos[termino] = cloneItem;
    
                }else{
                    this.elementos[termino] = item;
                }
    
                this.termino++;
                this.quantidade++;
            }
        }
        else{/*redimencione se */}
    }

    public X recupere(){
        if(this.elementos[inicio] instanceof Cloneable){
            try {
                return (X) this.clonador.clone( (X) this.elementos[inicio]);
            } catch (CloneNotSupportedException e) {}

        }else{
            return (X) this.elementos[inicio];

        }
        return null;
    }

    public void removaUmItem()throws Exception{
        if(this.elementos[inicio]==null){
            throw new Exception("Lista vazia, não ha nada a excluir");
        }else{
            this.elementos[inicio] = null;
            this.inicio++;
            this.quantidade--;
        }
    }

    public void redimensione(double fator){
        Object[] auxiliar = new Object[(int)Math.ceil(this.elementos.length*fator)];
        for(int i=0; i< this.quantidade;i++){
            auxiliar[i] = this.elementos[inicio];
        }
    }
}
