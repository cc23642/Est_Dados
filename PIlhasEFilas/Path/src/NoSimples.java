public class NoSimples<X>{
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

        //metodos obrigatórios da classe NoSimples

    @Override
    public String toString(){
        return ""+this.info.toString();
    }

    public boolean equals(NoSimples<X> obj){
        if(obj==this) return true;//se for da classe NoSimples
        if(obj==null) return false;//se guardar valor nulo
        if(obj.getClass()!=this.getClass()) return false;//se as classes dos objetos não forem as mesmas
        if(!(obj.info == this.info)) return false;//se o a informação do objeto for diferente da informação da classe NoSimples
        return true;
    }

    @Override
    public int hashCode(){
        int ret=1;
        ret=2*ret+this.getInfo().hashCode();
        if(ret<0) ret=-ret;
        return ret;
    }
        //a classe Clonador não existe
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
        catch(Exception erro){}//so da erro se rceber parametro nulo, e this numquinha é nulo
        return ret;
    }
}

