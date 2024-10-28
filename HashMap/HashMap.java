/*
Trata-se de uma técnica conhecida em português pelo de espalhamento que possui a pretensiosa pretensão de recuperar de tempo instantâneo de
        informações armazenadas em estruturas implementadas com essa técnica. Várias estruturas de dados podem ser implementados por essa técnica,
        e na aula de hoje focaremos em uma chamada de hashmap.
        Hashmaps se baseiam em duas informações: chave e valor. hashmaps guardam valores associados a chaves e a chave é usada para recuperar
        um valor armazenado, assim como para remover um valor armazenado.Podemos conceber a implementação de um hashmap como uma classe genérica com dois parâmetros, digamos k e v, respectivamente os tipos das chaves e os tipos dos valores.
        Para armazenamento poderíamos usar um vetor em cujas posições seriam armazenadas em listas ligadas em simples e desordenada.
        Poderíamos conceder para essa classe um método chamado guardeUmItem( ), com dois parâmetros, um do tipo k e outro do tipo v. O método
        chamaria hashcode da chave que calcularia o resto da divisão de inteiro, e do tamanho do vetor.  Na posição indicada pelo resultado do
        resto armazenaríamos, na lista ali contida, o valor, juntamente com a chave. A lista em uma posição qualquer do vetor, somente seria
        instanciada quando, de fato, desejarmos naquela posição algo armazenado.
        Também poderíamos conceber para essa classe um método chamado recupereUmItem( ) que recebe como parâmetro algo do tipo k, aplica a esse
        algo o hashcode, calcula o resto da divisão inteira do hashcode pelo tamanho do vetor, localiza na lista continda na posição indicada pelo resultado do resto a chave procurada achando com ela e retornando o valor associado.
        Podemos ainda conceber para essa classe um método removaUmItem( ) que tenha feito todas as operações para o método recupere um item, em vez
        de retornar o valor associado a chave remove da lista o valor e a chave.
        Recuperação e remoção de chaves inexistentes também. Deveria existir um atributo que informasse quantos valores se encontram armazenados.
        Deveria haver também um atributo que informasse a taxa de desperdício aceitável ( Esse atributo deveria ser inicializado pelo construtor ).
        Também deveria haver um atributo que indicasse a taxa máxima de desperdício aceitável ( Esse atributo também deveria ser inicializado pelo
        construtor ). Dos métodos guardeUmItem( ) e removerUmItem() deve se responsabilizar por manter o tamanho do vetor em conformidade com as
        taxas de desperdício a cimas descritas.

        Deverá ainda haver um atributo que expresse a capacidade inicial com a qual foi dimensionado o vetor. Essa capacidade deve ser fornecida
        ao construtor, que realizará o redimensionamento inicial. Em casos de redimensionamento do vetor para um tamanho menor ( naturalmente ),
        devemos cuidar para nunca baixar para aquém da capacidade inicial o tamanho do vetor.
        Obviamente clonagens deverão ser feitas ao ser armazenar e ao recuperar um valor. Ainda mais naturalmente é se supor a implementação de
        todos os métodos obrigatórios.
        Pode ser uma boa ideia ter um segundo construtor que não espere que o usuário forneça as taxa máximas e mínimas, inicializando-as com
        valores padrão, sugestão mínimo = 0.70 e máximo = 0.90.

        Ao realizar o redimensionamento, tanto pra menos tanto pra mais, tudo que estava no vetor e que deve ser mantido nele deve ter a posição de
        armazenamento recalculada.



        classe hash recebe K e V como parametro de tipo e tem dentro de si uma classe interna que representa seus elementos
        um vetor de listas desordenadas simples que guardam valores do tipo do elemento.
        *atributo lenght que é privado e que diz o tamanho total do vetor (- qtdElements)
        *atributo quantidade de posições ocupadas no vetor (- qtdPos)
        *atributo capacidade inicial do vetor
        *atributo taxas de desperdício máximo e minimo
        nessa classe temos os métodos:
        + guardeUmItem(K, V){}
        + recupereUmItem(K){}
        + removaUmItem(k){}
//construtores e overrides

*/



import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {
    private class Elemento {
        private K chave;
        private V valor;

        public Elemento(K c, V v) throws Exception {
            if (c == null) throw new Exception("chave vazia");
            if (v == null) throw new Exception("valor vazio");
            this.chave = c;
            this.valor = v;
        }

        public K getChave() {
            return this.chave;
        }

        public V getValor() {
            return this.valor;
        }

        public void setValor(V valor) {
            this.valor = valor;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) return false;
            Elemento other = (Elemento) obj;
            return chave.equals(other.chave) && valor.equals(other.valor);
        }

        @Override
        public int hashCode() {
            return chave.hashCode();
        }

        @Override
        public String toString() {
            return chave + " : " + valor;
        }
    }

    private List<Elemento>[] vetor;
    private int qtdElementos = 0;
    private int qtdOcupacao = 0;
    private int tamanho;
    private float taxaDispMin;
    private float taxaDispMax;
    private int capacidadeInicial;

    public HashMap(int capacidadeInicial, float taxaDispMax, float taxaDispMin) {
        this.capacidadeInicial = capacidadeInicial;
        this.tamanho = capacidadeInicial;
        this.taxaDispMax = taxaDispMax;
        this.taxaDispMin = taxaDispMin;
        this.vetor = new ArrayList[capacidadeInicial];
    }

    public void guardeUmItem(K chave, V valor) throws Exception {
        if (chave == null || valor == null) throw new Exception("Chave ou valor nulos");

        int posicao = Math.abs(chave.hashCode() % tamanho);

        if (vetor[posicao] == null) {
            vetor[posicao] = new ArrayList<>();
            qtdOcupacao++;
        }

        // Verificar se já existe um elemento com a mesma chave para atualizar
        for (Elemento elem : vetor[posicao]) {
            if (elem.getChave().equals(chave)) {
                elem.setValor(valor);
                return;
            }
        }

        // Se não houver, adicionar novo elemento
        vetor[posicao].add(new Elemento(chave, valor));
        qtdElementos++;

        verificarRedimensionamento();
    }

    public V recupereUmItem(K chave) throws Exception {
        if (chave == null) throw new Exception("Chave nula");

        int posicao = Math.abs(chave.hashCode() % tamanho);

        if (vetor[posicao] != null) {
            for (Elemento elem : vetor[posicao]) {
                if (elem.getChave().equals(chave)) {
                    return elem.getValor();
                }
            }
        }

        return null; // Chave não encontrada
    }

    public void removaUmItem(K chave) throws Exception {
        if (chave == null) throw new Exception("Chave nula");

        int posicao = Math.abs(chave.hashCode() % tamanho);

        if (vetor[posicao] != null) {
            for (Elemento elem : vetor[posicao]) {
                if (elem.getChave().equals(chave)) {
                    vetor[posicao].remove(elem);
                    qtdElementos--;

                    if (vetor[posicao].isEmpty()) {
                        vetor[posicao] = null;
                        qtdOcupacao--;
                    }

                    verificarRedimensionamento();
                    return;
                }
            }
        }
    }

    private void verificarRedimensionamento() {
        float taxaOcupacao = (float) qtdOcupacao / tamanho;

        if (taxaOcupacao > taxaDispMax) {
            redimensionar(tamanho * 2); // Aumentar
        } else if (taxaOcupacao < taxaDispMin && tamanho > capacidadeInicial) {
            redimensionar(Math.max(capacidadeInicial, tamanho / 2)); // Diminuir
        }
    }

    private void redimensionar(int novoTamanho) {
        List<Elemento>[] novoVetor = new ArrayList[novoTamanho];
        for (List<Elemento> lista : vetor) {
            if (lista != null) {
                for (Elemento elem : lista) {
                    int posicao = Math.abs(elem.getChave().hashCode() % novoTamanho);
                    if (novoVetor[posicao] == null) {
                        novoVetor[posicao] = new ArrayList<>();
                    }
                    novoVetor[posicao].add(elem);
                }
            }
        }
        vetor = novoVetor;
        tamanho = novoTamanho;
        qtdOcupacao = calcularOcupacao();
    }

    private int calcularOcupacao() {
        int ocupacao = 0;
        for (List<Elemento> lista : vetor) {
            if (lista != null && !lista.isEmpty()) {
                ocupacao++;
            }
        }
        return ocupacao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (List<Elemento> lista : vetor) {
            if (lista != null) {
                for (Elemento elem : lista) {
                    sb.append(elem.toString()).append(", ");
                }
            }
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }
}
