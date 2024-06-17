public class App {
    public static void main(String[] args) throws Exception {
        Pilha<Integer> pilha = new Pilha<Integer>(10);
        pilha.guarde(1);
        pilha.guarde(2);
        pilha.guarde(3);
        pilha.guarde(4);
        pilha.guarde(5);
        System.out.println(pilha.toString());
        pilha.remova();
        System.out.println(pilha.toString());
        pilha.recupere();
        System.out.println(pilha.toString());
    }
}
