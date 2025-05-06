package Labirinto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Script {
    private Integer linhas;
    private int colunas;
    char[][] labirinto;

    public Script(){}

    public void lerArquivo(String caminhoDoDiretorio)throws Exception{
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoDoDiretorio));
            String linha;

            this.linhas = Integer.parseInt(br.readLine());//primeira linha do arquivo diz a quantidade de linhas do labirinto
            this.colunas = Integer.parseInt(br.readLine());//segunda linha do arquivo diz a quantidade de colunas do labirinto
            this.labirinto = new char[this.linhas][this.colunas];

            int indxLinha = 0;
            String linhaAtual = null;
            while ((linhaAtual = br.readLine())!=null) {
                
                if(indxLinha >= this.linhas) {
                    throw new Exception("Erro ao ler o arquivo: o número de linhas informado na primeira linha do arquivo não corresponde com o número de linhas do labirinto.");
                }
                if(linhaAtual.length() != this.colunas) {
                    throw new Exception("Erro ao ler o arquivo: a segunda linha não possui o número correto de colunas.");
                }else{
                    for(int indxColuna=0;indxColuna<this.colunas;indxColuna++){

                        if( linhaAtual.charAt(indxColuna)=='E' ||
                            linhaAtual.charAt(indxColuna)=='#' ||
                            linhaAtual.charAt(indxColuna)=='S' ||
                            linhaAtual.charAt(indxColuna)==' '
                        ){
                            this.labirinto[indxLinha][indxColuna] = linhaAtual.charAt(indxColuna);
                        }else{
                            throw new Exception("Erro ao ler o arquivo: caracteres inválidos. O arquivo só pode conter os caracteres: E, #, S e espaço.");
                        }
                    }

                    indxLinha++;
                }

                
                System.out.println(linhaAtual);
            }
            if(indxLinha < this.linhas) {
                throw new Exception("Erro ao ler o arquivo: o número de linhas informado na primeira linha do arquivo não corresponde com o número de linhas do labirinto.");
            }
            br.close();

            
        } catch (IOException e) {
            throw new Exception("Erro ao ler as linhas do arquivo:" + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                sb.append(this.labirinto[i][j]); // Adiciona o caractere na posição [i][j]
            }
            sb.append("\n"); // Adiciona uma nova linha após cada linha da matriz
        }
        return sb.toString();
    }
}
