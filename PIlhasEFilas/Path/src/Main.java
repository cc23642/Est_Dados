public class Main {
    public static void main(String[] args) throws Exception {
        Pilha<Integer> pilha1 = new Pilha<Integer>(10);
        pilha1.guarde(1);
        pilha1.guarde(2);
        pilha1.guarde(3);
        System.out.println(pilha1);
        pilha1.remova();
        System.out.println(pilha1);
        
    }
}
