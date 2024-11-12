public class Main {
    static HashMap<String,Integer> hashMap = new HashMap<>(10,2,2);
    public static void main(String[]args) throws Exception {
        System.out.println("Código iniciado com Sucesso!");
        String[] chaves = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        int inteiro = 0;
        for (String chave : chaves){
            inteiro++;
            hashMap.guardeUmItem(chave,inteiro);

        }


        System.out.println(hashMap.toString());

    }

}
