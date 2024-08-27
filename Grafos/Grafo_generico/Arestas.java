public class Arestas<X extends Comparable<X>> implements Cloneable 
{
    private X info;
    private Vertice verticeA;
    private Vertice verticeB;
    
    public Arestas(Vertice a,Vertice b,X info)
    {
        this.verticeA = a;
        this.verticeB = b;
        this.info = info;
    }

    public Arestas(Vertice a,Vertice b)
    {
        this.verticeA = a;
        this.verticeB = b;
    }

    public X getInfo()
    {
        return this.info;
    }

    public ListaEncadeadaSimplesDesordenada<Vertice> getVertices()throws Exception{
        ListaEncadeadaSimplesDesordenada<Vertice> lis = new ListaEncadeadaSimplesDesordenada<Vertice>();
        try {
            lis.guadeNoInicio(verticeA);
            lis.guardaNoFinal(verticeB);
        } catch (Exception e) {
            throw new Exception("não deu");
        }
        return lis;
    }

    public Vertice getVerticeA(){
        return this.verticeA;
    }
    public Vertice getVerticeB(){
        return this.verticeB;
    }

    public void setArestaA(Vertice info){this.verticeA = info;}
    public void setArestaB(Vertice info){this.verticeB = info;}

    public void setInfo(X inf)
    {
        this.info=inf;
    }

    @Override
    public String toString()
    {
        try {
            return ("Informação da Aresta:"+getInfo()+ "\n Vertices vinculados"+ getVertices().toString());
        } catch (Exception e) {
            return ("Informação da Aresta: "+getInfo()+ "\n Vertices vinculados: "+ this.verticeA.toString()+", "+this.verticeB.toString());
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == this) return true;

        if(obj == null || obj.getClass() != this.getClass()) return false;

        Arestas<X> are = (Arestas<X>)obj;

        if(this.info != are.info) return false;

        if(((Arestas<X>) obj).getVerticeA().equals(this.verticeA)){
            if(((Arestas<X>) obj).getVerticeB().equals(this.verticeB)){
                return true;        
            }
        }else{return false;}

        return false;
    }

    @Override
    public int hashCode()
    {
        int ret = 1;

        ret = 13*ret +this.info.hashCode();

        if(ret<0)
            ret=-ret;

        return ret;
    }

    public Arestas (Arestas<X> modelo) throws Exception
    {
        if(modelo == null) throw new Exception("Modelo Ausente");

        this.info = modelo.info;
    }

    public Object clone()
    {
        Arestas<X> ret= null;

        try{
            ret = new Arestas<X>(this);
        }
        catch(Exception erro)
        {}

        return ret;
    }
}