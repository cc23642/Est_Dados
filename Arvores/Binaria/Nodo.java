public class Nodo<X> implements Cloneable, Comparable<X> {
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
        var ret;
        if(this.info instanceof Cloneable){
            ret = (X)clone(this.info);
        }else { ret = this.info; }
        return ret;
    }

    public X getEsquerdo()
    {   
        var ret;
        if(this.esq instanceof Cloneable){
            ret = (X)super.clone(this.esq);
        }else { ret = this.esq; }
        return ret;
    }

    public X getDireito()
    {   
        var ret;
        if(this.dir instanceof Cloneable){
            ret = (X)super.clone(this.dir);
        }else { ret = this.dir; }
        return ret;
    }

    public void setInfo(X inf)
    {
        if(inf instanceof Cloneable){
            this.info = (X)super.clone(inf);
        }else { this.info = inf; }
    }

    public void setEsquerdo(Nodo<X> inf)
    {
        if(inf instanceof Cloneable){
            this.esq = (X)super.clone(inf);
        }else { this.esq = inf; }
    }
    public void setDireito(Nodo<X> inf)
    {
        if(inf instanceof Cloneable){
            this.dir = (X)super.clone(inf);
        }else { this.dir = inf; }
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
        return "Nó: "+this.info.getInfo();
    }

    @Override
    public boolean equals(Nodo<X> obj)throws Exception {
        if(obj==null)throw new Exception("error in value, this value is NULL");
        if(obj.getClass()!=this.getClass()){   return false;    }
        if(obj.getInfo().compareTo(this.getInfo())!=0){ return false;    }
        return true;
    }

    @Override
    public int hashCode() {
        //TODO
        return super.hashCode();
    }

}
