public class NoSimples<X> {
    private X info;
    private NoSimples<X> prox;

    public NoSimples (X i, NoSimples<X> p){
        this.info = i;
        this.prox = p;
    }

    public NoSimples(X i){
        this.info=i;
        this.prox=null;
    }

    public NoSimples()
    {
        this.info = null;
        this.prox = null;
    }

    public X getInfo(){
        return this.info;
    }

    public NoSimples<X> getProx(){
        return this.prox;
    }
    public void setInfo(X i){
        this.info = i;
    }
    public void setProx(NoSimples<X> p){
        this.prox = p;
    }

        

    @Override
    public String toString(){
        return ""+this.info.toString();
    }

    public boolean equals(NoSimples<X> obj){
        if(obj==this) return true;
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        if(!(obj.info == this.info)) return false;
        return true;
    }

    @Override
    public int hashCode(){
        int ret=1;
        ret=2*ret+this.getInfo().hashCode();
        if(ret<0) ret=-ret;
        return ret;
    }
        
    public NoSimples (NoSimples<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("modelo nulo");
        if(modelo.getInfo() instanceof Cloneable){
        this.info = modelo.info;
    }
    else this.info = modelo.info;
    }
    public Object clone(){
        NoSimples<X> ret=null;
        try{
            ret= new NoSimples<X>(this);
        }
        catch(Exception erro){}
        return ret;
    }
}
