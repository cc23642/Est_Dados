public class Aeroporto implements Comparable<Aeroporto>{

    private String cidade;
    private String codigo;
    private int index;

    public int getIndex() {
        return index;
    }

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

        public Voo(int indice, int codigo){
            this.indiceAeroporto = indice;
            this.numeroVoo = codigo;
            
        }

        public String toString(){
            return "(numero: "+numeroVoo+", destino: "+indiceAeroporto+")";
        }

        @Override
        public int compareTo(Voo outroVoo) {
            if(outroVoo != null){
                if(outroVoo.getIndiceAeroporto() == this.indiceAeroporto){
                    if(outroVoo.getNumeroVoo()<this.numeroVoo){
                        return -1;
                    }
                    if(outroVoo.getNumeroVoo()==this.numeroVoo){
                        return 0;
                    }
                    if(outroVoo.getNumeroVoo()>this.numeroVoo){
                        return 1;
                    }
                }
                    
            }else{
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 2;
            
        }
    }
    
    private ListaEncadeadaDesordenada<Voo> voos = new ListaEncadeadaDesordenada<Voo>();

    public ListaEncadeadaDesordenada<Voo> getVoos() { return voos; }
    public void setVoos(ListaEncadeadaDesordenada<Voo> voos) { this.voos = voos; }

    public Aeroporto(String novaCidade, String novoCodigo, int index) throws Exception{
        if(novaCidade.isEmpty() || novaCidade == null) throw new Exception("Ausência de Cidade");
        if(novoCodigo.isEmpty() || novoCodigo == null) throw new Exception("Ausência de Código");

        this.cidade = novaCidade;
        this.codigo = novoCodigo;
        this.index = index;
    }

    public void novoVoo(int novoNumeroVoo, int indiceDestino)throws Exception{
        if(novoNumeroVoo == 0) throw new Exception("Ausência de numero do Voo");
        if(indiceDestino == 0) throw new Exception("Ausência de Destino");

        this.voos.inserir(new Voo(novoNumeroVoo, indiceDestino));

        

    }
    @Override
    public int compareTo(Aeroporto outroAeroporto) {
        if(outroAeroporto != null){
            if(outroAeroporto.getVoos().tamanho() > this.voos.tamanho()) return 1;
            if(outroAeroporto.getVoos().tamanho() == this.voos.tamanho()) return 0;
            if(outroAeroporto.getVoos().tamanho() < this.voos.tamanho()) return -1;
        }
        return 2;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public String toString(){
        return "\n"+index+": Aeroporto: "+codigo+", "+ cidade +"\n   > "+voos.toString();
    }
}
