public class Nodo<X extends Comparable<X>> implements Cloneable {
    private X info;
    private Nodo<X> esq;
    private Nodo<X> dir;


    public Nodo(X value){
        this.info = value;
        this.dir = null;
        this.esq = null;
    }

    public Nodo(X value, Nodo<X> esq, Nodo<X> dir){
        this.info = value;
        this.esq = esq;
        this.dir = dir;
    }

    public X getInfo()
    {
        return this.info;
    }

    public Nodo<X> getEsquerdo()
    {   
        return this.esq;
    }

    public Nodo<X> getDireito()
    {   
        return this.dir;
    }

    public void setInfo(X inf)
    {
        if(inf instanceof Cloneable){
            this.info = inf;
        }else { this.info = inf; }
    }

    public void setEsquerdo(Nodo<X> inf)
    {
        if(inf instanceof Cloneable){
            this.esq = inf.clone();
        }else { this.esq = inf; }
    }
    public void setDireito(Nodo<X> inf)
    {
        if(inf instanceof Cloneable){
            this.dir = inf.clone();
        }else { this.dir = inf; }
    }


    @SuppressWarnings("unchecked")
    @Override
    public Nodo<X> clone() {
        Nodo<X> clonedNode;
        try {
            clonedNode = (Nodo<X>) super.clone();
            if (this.esq != null) {
                clonedNode.esq = this.esq.clone();
            }
            if (this.dir != null) {
                clonedNode.dir = this.dir.clone();
            }
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
        return clonedNode;
    }



    // public MinhaClasse shallowCopy() throws CloneNotSupportedException {
    //     MinhaClasse clone = (MinhaClasse) super.clone(); // Cópia superficial

    //     // Se objetoInterno for clonável, faça uma cópia profunda
    //     if (objetoInterno != null && objetoInterno instanceof Cloneable) {
    //         clone.objetoInterno = (OutraClasse) objetoInterno.clone();
    //     }

    //     return clone;
    // }

    @Override
    public String toString() {
        return "Nó: "+this.info.toString();
    }

    public boolean equals(Nodo<X> obj)throws Exception {
        if(obj==null)throw new Exception("error in value, this value is NULL");
        if(obj.getClass()!=this.getClass()){   return false;    }
        if(obj.getInfo().compareTo(this.getInfo())!=0){ return false;    }
        return true;
    }

    @Override
    public int hashCode() {
        int ret = 2;
        ret += this.dir.hashCode()*17;
        ret += this.esq.hashCode()*17;
        ret += this.info.hashCode()*17;
        return ret;
    }

}
