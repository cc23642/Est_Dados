package Labirinto;

public class Main {
    public static void main (String[]args){
        Script script = new Script();
        try {
            script.lerArquivo("comVetores/Labirinto/labirintostxt/labrinto01.txt");
            System.out.println(script.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
