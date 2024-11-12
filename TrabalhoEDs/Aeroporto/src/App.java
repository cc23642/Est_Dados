import java.util.Scanner;


public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Este é o projeto de Estrutura de dados onde foi desenvolvido o projeto de cadastro para aeoroportos");
        System.out.println("desenvolvido pelos alunos :");
        System.out.println(">   Murilo dos Santos : 23642");
        System.out.println(">   Felipe Catista : 23314");
        System.out.println(">   Paulo Hyago : 22XXX");

        ListaEncadeadaDesordenada<Aeroporto> redeDeAeroportos = new ListaEncadeadaDesordenada<Aeroporto>();

        ListaEncadeadaDesordenada<String> cidades = new ListaEncadeadaDesordenada<String>();

        cidades.inserir("Brasilia");
        cidades.inserir("Belo Horizonte");
        cidades.inserir("Rio");
        cidades.inserir("São Paulo");
        cidades.inserir("Salvador");

        ListaEncadeadaDesordenada<String> codigos = new ListaEncadeadaDesordenada<String>();

        codigos.inserir("BSB");
        codigos.inserir("CNF");
        codigos.inserir("GIG");
        codigos.inserir("GRU");
        codigos.inserir("SSA");

        for(int index = 0 ; index < codigos.tamanho(); index++ ){

            redeDeAeroportos.inserir(new Aeroporto(cidades.get(index),codigos.get(index), index));
        }

        Scanner scanner = new Scanner(System.in);

        int index = 0;
        while(true){

            System.out.println("digite um código de voo para o aeroporto"+ redeDeAeroportos.get(index)+", i:"+ index);
            int codVoo = Integer.parseInt(scanner.nextLine());
            System.out.println("digite o index do aeroporto de destino");
            int idxAeroporto = Integer.parseInt(scanner.nextLine());

            redeDeAeroportos.get(index).novoVoo(idxAeroporto,codVoo);

            System.out.println("adicionar mais um voo? [s|n]");
            System.out.println("ou continuar par o próximo aeroporto? [c]");
            String resposta = scanner.nextLine();
            if(resposta.compareTo("n")==0){ System.out.println("saindo!");break; }
            else if(resposta.compareTo("s")==0){
                continue;
            }
            else if(resposta.compareTo("c")==0){ index++;}
        }

        System.out.println(redeDeAeroportos.toString());
        

        

    }
}
