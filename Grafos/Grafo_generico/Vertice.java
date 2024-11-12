import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Vertice<X extends Comparable<X>> implements Cloneable {

    private X info;
    private ListaEncadeadaDuplaOrdenada<Aresta<X>> arestas;

    public Vertice(X info){
        this.info = info;
        this.arestas = new ListaEncadeadaDuplaOrdenada<Aresta<X>>();
    }

    public Vertice(X info,ListaEncadeadaDuplaOrdenada<Aresta<X>> l_arestas) throws Exception{
        this.info = info;
        if(l_arestas!=null){
            NoDuplo<Aresta<X>> a_atual = l_arestas.getPrimeiroNo();
            while (a_atual.getProx()!=null) {
                this.arestas.inserir(a_atual.getInfo());
                a_atual = a_atual.getProx();
            }
        }
        else this.arestas =null;
    }
    
    public ListaEncadeadaDuplaOrdenada<Aresta<X>> getArestas(){
        return this.arestas;
    }

    public X getInfo(){return this.info;}
    public void setInfo(X infoX){
        if(infoX instanceof Cloneable){
            this.info = meuCloneDeX(infoX);
        }else {this.info=infoX;}
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
            if(objetc.getInfo().compareTo(this.getInfo())==0) return true;
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
