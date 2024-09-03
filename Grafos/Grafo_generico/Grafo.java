public class Grafo<X extends Comparable<X>> implements Cloneable{
    private ListaEncadeadaDuplaOrdenada<Vertice<X>> vertices;
    private ListaEncadeadaDuplaOrdenada<Aresta<X>> arestas;

    public Grafo(){
        this.vertices = null;
        this.arestas = null;
    }

    public Grafo(Grafo g_modelo) throws Exception{
        if(g_modelo==null)throw new Exception("modelo nulo");
        if(g_modelo.tipoDosVertices()!=this.tipoDosVertices())throw new Exception("os Grafos guardam tipos diferentes de informações");
        this.vertices = new ListaEncadeadaDuplaOrdenada<Vertice<X>>(g_modelo.getVertices());
        this.arestas = new ListaEncadeadaDuplaOrdenada<Aresta<X>>(g_modelo.getArestas());
    }

    public void adicionarVertice(X v_info)throws Exception{
        if(v_info==null)throw new Exception("info nula");
        if(temEsseVertice(v_info))throw new Exception("já existe no grafo");
        vertices.inserir(new Vertice<X>(v_info));
    }

    public void adicionarAresta(Vertice<X> lado_a, Vertice<X> lado_b) throws Exception{
        if(lado_a == null || lado_b == null)throw new Exception("aresta sem destino");
        this.arestas.inserir(new Aresta<X>(lado_a, lado_b));
    }

    public ListaEncadeadaDuplaOrdenada<Vertice<X>> getVertices(){
        return this.vertices;
    }
    public ListaEncadeadaDuplaOrdenada<Aresta<X>> getArestas(){
        return this.arestas;
    }

    public Class tipoDosVertices(){
        return this.getVertices().getClass();
    }

    public boolean temEsseVertice(X info) throws Exception{
        if(info==null)return false;
        ListaEncadeadaDuplaOrdenada<Vertice<X>> vertices_ = getVertices();
        NoDuplo<Vertice<X>> v_atual = vertices_.getPrimeiroNo();
        while (v_atual.getProx()!=null) {
            if(v_atual.getInfo()==info)return true;
            else v_atual = v_atual.getProx();
        }
        return false;
    }

    public void removaEsseVertice(X info)throws Exception{
        if(info == null)throw new Exception("'info' Nula");
        if(this.getVertices()==null)throw new Exception("Não existem vertices nesse grafo a serem removidos");
        NoDuplo<Vertice<X>> v_atual = this.getVertices().getPrimeiroNo();
        while (v_atual.getProx()!=null) {
            if(v_atual.getProx().getInfo()==info){
                if(v_atual.getProx().getProx()!=null){
                    v_atual.setProx(v_atual.getProx().getProx());
                    v_atual.getProx().getProx().setAnt(v_atual);
                    break;
                }
                if(v_atual.getProx().getProx()==null){
                    v_atual.setProx(null);
                    break;
                }
            }
            v_atual =v_atual.getProx();
        } 
    }
    
}