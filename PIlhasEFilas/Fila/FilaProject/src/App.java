public class App {
    public static void main(String[] args) throws Exception {
        Fila<String> fila = new Fila<String>(10);
        System.out.println(fila.chekcapacidade(fila));
        fila.guarde("Murilo");
        System.out.println(fila.toString());
        fila.guarde("Sophia");
        System.out.println(fila.toString());
        fila.guarde("Regina");
        System.out.println(fila.toString());
        fila.guarde("Marcos");
        System.out.println(fila.toString());
        fila.remova();
        fila.remova();
        System.out.println(fila.getUltimo());
        System.out.println(fila.toString());
        fila.guarde("André");
        System.out.println(fila.getUltimo());
        System.out.println(fila.toString());
        fila.recupere();
        System.out.println(fila.getUltimo());
        System.out.println(fila.toString());
        fila.recupere();
        System.out.println(fila.getUltimo());
        System.out.println(fila.toString());
    }
}
