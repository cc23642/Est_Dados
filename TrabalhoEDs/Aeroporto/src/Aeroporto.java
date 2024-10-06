import java.io.*;

public class Aeroporto{

    private String cidade;
    private String codigo;

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    private class Voo implements Comparable<Voo>{
        private int indiceAeroporto;
        public int getIndiceAeroporto() {
            return indiceAeroporto;
        }

        public void setIndiceAeroporto(int indiceAeroporto) {
            this.indiceAeroporto = indiceAeroporto;
        }

        private int numeroVoo;

        public int getNumeroVoo() {
            return numeroVoo;
        }

        public void setNumeroVoo(int numeroVoo) {
            this.numeroVoo = numeroVoo;
        }

        public Voo(){
            this.indiceAeroporto = 0;
            this.numeroVoo = 0;
        }

        @Override
        public int compareTo(Voo outroVoo) {
            // Defina como deseja comparar dois objetos Voo
            // Exemplo: Comparando pelo código do voo (String)
            return this.numeroVoo.compareTo(outroVoo.getNumeroVoo());
        }
    }
    
    private ListaEncadeadaOrdenada<Voo> voos = new ListaEncadeadaOrdenada<Voo>();

    public ListaEncadeadaOrdenada<Voo> getVoos() { return voos; }
    public void setVoos(ListaEncadeadaOrdenada<Voo> voos) { this.voos = voos; }

    public Aeroporto(String novaCidade, String novoCodigo) throws Exception{
        if(novaCidade.isEmpty() || novaCidade == null) throw new Exception("Ausência de Cidade");
        if(novoCodigo.isEmpty() || novoCodigo == null) throw new Exception("Ausência de Código");
    }

    public void novoVoo(int novoNumeroVoo, Aeroporto destino)throws Exception{
        if(novoNumeroVoo == 0) throw new Exception("Ausência de numero do Voo");
        if(destino == null) throw new Exception("Ausência de Destino");

        

    }
}
