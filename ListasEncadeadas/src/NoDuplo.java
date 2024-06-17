public class NoDuplo<X>{
    private X info;
    private NoDuplo<X> prox;
    private NoDuplo<X> ant;

    public NoDuplo (X i, NoDuplo<X> p, NoDuplo<X> a){
        this.info = i;
        this.prox = p;
        this.ant  = a;
    }

    public NoDuplo(X i){
        this.info=i;
        this.prox=null;
        this.prox=null;

    }

    public NoDuplo(){
        this.info=null;
        this.prox=null;
        this.ant =null;
    }

    public X getInfo(){
        return this.info;
    }

    public NoDuplo<X> getProx(){return this.prox;}
    public NoDuplo<X> getAnt (){return this.ant;}

    public void setInfo(X i){this.info = i;}
    
    public void setProx(NoDuplo<X> p){this.prox = p;}
    public void setAnt (NoDuplo<X> a){this.ant  = a;}

        //metodos obrigatórios da classe NoDuplo

    @Override
    public String toString(){
        return ""+this.info.toString();
    }

    public boolean equals(NoDuplo<X> obj){
        if(obj==this) return true;//se for da classe NoDuplo
        if(obj==null) return false;//se guardar valor nulo
        if(obj.getClass()!=this.getClass()) return false;//se as classes dos objetos não forem as mesmas
        if(!(obj.info == this.info)) return false;//se o a informação do objeto for diferente da informação da classe NoDuplo
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
    public NoDuplo (NoDuplo<X> modelo)throws Exception{
        if(modelo==null)throw new Exception("modelo nulo");
        if(modelo.getInfo() instanceof Cloneable){
        this.info = new Clonador<X>().clone(modelo.info);
    }
    else this.info = modelo.info;
    }
    public Object clone(){
        NoDuplo<X> ret=null;
        try{
            ret= new NoDuplo<X>(this);
        }
        catch(Exception erro){}//so da erro se rceber parametro nulo, e this numquinha é nulo
        return ret;
    }
}

