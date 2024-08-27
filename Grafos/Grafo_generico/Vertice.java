import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Vertice<X extends Comparable<X>> implements Cloneable {

    private X info;
    private Arestas<X> arestas; //lista de arestas conectadas a este vertice

    public Vertice(X infX)throws Exception{
        if(infX==null)throw new Exception("não faz sentido ter um vértice nulo.");
        this.info = infX;
    }

    public Vertice(X infX, Arestas<X> ar)throws Exception{
        if(infX==null)throw new Exception("não faz sentido ter um vértice nulo.");
        this.info = infX;
        this.arestas = ar;
        
    }

    public Vertice(Vertice v)throws Exception{
        if(v==null)throw new Exception("não faz sentido ter um vértice nulo.");
        if(v instanceof Cloneable){
            this.info = (X) v.meuCloneDeX(v.getInfo());
            this.arestas = (Arestas<X>)v.getArestas();
        }
    }

    public X getInfo(){return this.info;}
    public void setInfo(X infoX){
        if(infoX instanceof Cloneable){
            this.info = meuCloneDeX(infoX);
        }else {this.info=infoX;}
    }

    public Arestas<X> getArestas(){
        return this.arestas;
    }

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

    @Override
    public String toString(){
        return "info :"+this.info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() == this.getClass()){
            final Vertice objetc = (Vertice) obj;
            if(objetc.getInfo().compareTo(this.getInfo())==0){
                if(objetc.getArestas().equals(this.getArestas())){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hash = 2;
        hash = 17*hash+(this.info == null? 0 : this.info.hashCode());
        return hash;
    }
}
