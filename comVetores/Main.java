public class Main {
    public static void main(String[]args){
        Fila fila = new Fila<Integer>();

        for(int i=0;i<=10;i++){
            try {
                fila.incluaUmItem(i);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for(int i=0;i<10;i++){
            try {
                fila.removaUmItem();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("acabou!---------");
    }
}
