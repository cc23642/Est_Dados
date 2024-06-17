public class ArvoreBinariaDeBusca<X extends Comparable<X>>  {
    private Nodo<X> raiz;

    public ArvoreBinariaDeBusca(){
        this.raiz=null;
    }

    public ArvoreBinariaDeBusca(X value){
        this.raiz = new Nodo<X>();
    }

    public void inclui(X item)throws Exception{
        if(item==null)throw new Exception("item nulo");
        Nodo<X> atual = this.raiz;
        while (true) {
            if(item.compareTo(atual.getInfo())==-1 &&
                atual.getEsquerdo()!=null){
                atual=atual.getEsquerdo();
            }
            if(item.compareTo(atual.getInfo())==1 &&
                atual.getDireito()!=null){
                atual=atual.getDireito();
            }
            if(item.compareTo(atual.getInfo())==0)throw new Exception("este item ja existe na árvore");
            else{break;}
        }
        if(item.compareTo(atual.getInfo())==-1){
            atual.setEsquerdo(new Nodo<X>(item));
        }
        if(item.compareTo(atual.getInfo())==1){
            atual.setDireito(new Nodo<X>(item));
        }
    }

    public String toString() {
        return toString(this.raiz, "", true);
    }
    
    private String toString(Nodo<X> node, String prefix, boolean isTail) {
        StringBuilder sb = new StringBuilder();
    
        if (node != null) {
            sb.append(prefix)
              .append(isTail ? "└── " : "├── ")
              .append(node.getInfo().toString())
              .append("\n");
    
            String pointer = isTail ? "    " : "│   ";
    
            if (node.getEsquerdo() != null || node.getDireito() != null) {
                if (node.getEsquerdo() != null) {
                    sb.append(toString(node.getEsquerdo(), prefix + pointer, node.getDireito() == null));
                }
                if (node.getDireito() != null) {
                    sb.append(toString(node.getDireito(), prefix + pointer, true));
                }
            }
        }
    
        return sb.toString();
    }
    
}
