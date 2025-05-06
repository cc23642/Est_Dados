public class Main {
    public static void main(String[]args){
        Fila fila = new Fila<Integer>();
        Pilha pilha = new Pilha<Integer>();

        for(int i=0;i<=10;i++){
            try {
                pilha.incluaUmItem(i);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for(int i=0;i<1000000;i++){
            try {
                pilha.removaUmItem();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("acabou!---------");
        System.out.println(pilha.toString());
    }
}
