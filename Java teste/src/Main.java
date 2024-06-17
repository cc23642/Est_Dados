

public class Main {
    public static void main(String[] args) throws Exception {
        ListaEncadeadaSimplesDesordenada<Integer> l;
        l = new ListaEncadeadaSimplesDesordenada<Integer>();
        l.guadeNoInicio(5);
        l.guadeNoInicio(7);
        l.guadeNoInicio(3);

        System.out.println(l.tem(7));//True
        System.out.println(l.tem(9));//False
    }
}
