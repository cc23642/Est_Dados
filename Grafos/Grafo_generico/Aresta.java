import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Aresta<X extends Comparable<X>> implements Cloneable {
    private X info;
    private Vertice esq;
    private Vertice dir;

    public Aresta(X inf, Vertice e, Vertice d){
        this.info = inf;
        this.esq = e;
        this.dir = d;
    }

    public Aresta(Vertice e, Vertice d){
        this.esq = e;
        this.dir = d;
    }

    public X getInfo(){ return meuCloneDeX(this.info); }
    public void setInfo(X inf)throws Exception{ this.info= meuCloneDeX(inf); }

    public Vertice getEsq(){ return this.esq; }
    public Vertice getDir(){ return this.dir; }

    public void setEsq(Vertice e){ this.esq=e; }
    public void setDir(Vertice d){ this.dir=d; }

    private X meuCloneDeX (X x)
    {
        X ret=null;

        try
        {
            Class<?> classe         = x.getClass();
            Class<?>[] tipoDosParms = null;
            Method metodo           = classe.getMethod("clone",tipoDosParms);
            Object[] parms          = null;
            ret                     = (X)metodo.invoke(x,parms);
        }
        catch(NoSuchMethodException erro)
        {}
        catch(IllegalAccessException erro)
        {}
        catch(InvocationTargetException erro)
        {}

        return ret;
    }

    p
}
