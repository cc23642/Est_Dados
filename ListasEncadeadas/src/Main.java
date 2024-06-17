public class Main {
    public static void main(String[]args) throws Exception{
        System.out.println("olá");

//TESTADO        
//-----------------------------ListaEncadeadaSimplesDesordenada---------------------------------------------------------------------------------------
        ListaEncadeadaSimplesDesordenada<Integer> liSD = new ListaEncadeadaSimplesDesordenada<>();

        try {
            liSD.guadeNoInicio(5);
            liSD.guardaNoFinal(10);
            liSD.getPrimeiro();
            liSD.getUltimo();
            //liSD.guardeEm(0, 1);
            liSD.guadeNoInicio(0);
            System.out.println(liSD.getPrimeiro());
            System.out.println(liSD.getUltimo());
            if(liSD.tem(5)){
                System.out.println("Tem : "+ liSD.toString());
            }else{System.out.println("Não Tem : "+ liSD.toString());}
            liSD.inverter();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("informaçÕes invÁlidas");}

        String str = liSD.toString();
        System.out.println(str);
        liSD.guardeEm(0, 1);
        liSD.guadeNoInicio(11);
        liSD.guadeNoInicio(22);
        liSD.guadeNoInicio(33);
        System.out.println(liSD.toString());
        liSD.remova(2);
        liSD.removaPrimeiro();
        liSD.removaUltimo();
        System.out.println(liSD.toString());

//TESTADO
//-----------------------------ListaEncadeadaDuplaDesordenada---------------------------------------------------------------------------------------
        ListaEncadeadaDuplaDesordenada<String> liDD = new ListaEncadeadaDuplaDesordenada<>();

        try {
            liDD.guadeNoInicio("str");;
            liDD.guardaNoFinal("murilo");
            liDD.guardaNoFinal("Ana");
            liDD.getPrimeiro();
            liDD.getUltimo();
            //liSD.guardeEm(0, 1);
            liDD.guadeNoInicio("onda");
            System.out.println(liDD.getPrimeiro());
            System.out.println(liDD.getUltimo());
            if(liDD.tem("murilo")){
                System.out.println("Tem : "+ liDD.toString());
            }else{System.out.println("Não Tem : "+ liDD.toString());}
            liDD.inverter();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("informaçÕes invÁlidas");}

        System.out.println(liDD.toString());
        liDD.guardeEm(0, "macarrão");
        liDD.guadeNoInicio("maça");
        liDD.guadeNoInicio("banana");
        liDD.guadeNoInicio("outubro");
        System.out.println(liDD.toString());
        liDD.remova(2);
        liDD.removaPrimeiro();
        liDD.removaUltimo();
        System.out.println(liDD.toString());
//TESTADO
//-----------------------------ListaEncadeadaDuplaOrdenada---------------------------------------------------------------------------------------
        ListaEncadeadaDuplaOrdenada<Integer> liDO = new ListaEncadeadaDuplaOrdenada<>();
        try {
            liDO.inserir(1);
            liDO.inserir(10);
            liDO.inserir(5);
            System.out.println(liDO.getPrimeiro().toString());
            System.out.println(liDO.getUltimo().toString());
            liDO.inserir(7);
            if(liDO.tem(5)){
                System.out.println("Tem : "+ liDO.toString());
            }else{System.out.println("Não Tem : "+ liDO.toString());}
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("informaçÕes invÁlidas");}

        System.out.println(liDO.toString());
        liDO.inserir(2);
        liDO.inserir(3);
        liDO.inserir(0);
        liDO.inserir(9);
        System.out.println(liDO.toString());
        liDO.remova(2);
        liDO.removaPrimeiro();
        liDO.removaUltimo();
        System.out.println(liDO.toString());
/*TESTADO - ERRO
//-----------------------------ListaEncadeadaCircularDesordenada---------------------------------------------------------------------------------------
        ListaEncadeadaCircularDesordenada<Integer> liCD = new ListaEncadeadaCircularDesordenada<>();
        try {
            liCD.guadeNoInicio(5);
            liCD.guardaNoFinal(10);
            liCD.guardaNoFinal(8);
            System.out.println(liCD.getPrimeiro());
            System.out.println(liCD.getUltimo());
            //liSD.guardeEm(0, 1);
            liCD.guadeNoInicio(0);
            System.out.println(liCD.getPrimeiro());
            if(liCD.tem(5)){
                System.out.println("Tem : "+ liCD.toString());
            }else{System.out.println("Não Tem : "+ liCD.toString());}
            liCD.inverter();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("informaçÕes invÁlidas");}

        System.out.println(liSD.toString());
        liCD.guardeEm(0, 1);
        liCD.guadeNoInicio(11);
        liCD.guadeNoInicio(22);
        liCD.guadeNoInicio(33);
        System.out.println(liCD.toString());
        liCD.remova(2);
        liSD.removaPrimeiro();
        liCD.removaUltimo();
        System.out.println(liCD.toString());
*/
//TESTANDO
//-----------------------------ListaEncadeadaCircularOrdenada---------------------------------------------------------------------------------------
        ListaEncadeadaCircularOrdenada<String> liCO = new ListaEncadeadaCircularOrdenada<>();
        try {
            liCO.inserir("maça");
            liCO.inserir("pera");
            liCO.inserir("banana");
            liCO.getPrimeiro();
            liCO.getUltimo();
            liCO.inserir("porta");
            System.out.println(liCO.getPrimeiro());
            System.out.println(liCO.getUltimo());
            if(liCO.tem("pera")){
                System.out.println("Tem : "+ liCO.toString());
            }else{System.out.println("Não Tem : "+ liCO.toString());}
            liCO.inverter();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("informaçÕes invÁlidas");}

        System.out.println(liDO.toString());
        liCO.inserir("porta");
        liCO.inserir("chave");
        liCO.inserir("ola");
        liCO.inserir("amigo");
        System.out.println(liCO.toString());
        liCO.remova(2);
        liCO.removaPrimeiro();
        liCO.removaUltimo();
        System.out.println(liCO.toString());
//-----------------------------ListaEncadeadaDuplaCircularDesordenada---------------------------------------------------------------------------------------
//         ListaEncadeadaDuplaCircularDesordenada<String> liDCD = new ListaEncadeadaDuplaCircularDesordenada<>();
//         try {
//             liDCD.guadeNoInicio("str");;
//             liDCD.guardaNoFinal("murilo");
//             liDCD.guardaNoFinal("Ana");
//             liDCD.getPrimeiro();
//             liDCD.getUltimo();
//             //liSD.guardeEm(0, 1);
//             liDCD.guadeNoInicio("onda");
//             System.out.println(liDCD.getPrimeiro());
//             System.out.println(liDCD.getUltimo());
//             if(liDCD.tem("murilo")){
//                 System.out.println("Tem : "+ liDCD.toString());
//             }else{System.out.println("Não Tem : "+ liDCD.toString());}
//             liDCD.inverter();
//         }catch (Exception e){
//             e.printStackTrace();
//             throw new Exception("informaçÕes invÁlidas");}

//         System.out.println(liDCD.toString());
//         liDCD.guardeEm(0, "macarrão");
//         liDCD.guadeNoInicio("maça");
//         liDCD.guadeNoInicio("banana");
//         liDCD.guadeNoInicio("outubro");
//         System.out.println(liDCD.toString());
//         liDCD.remova(2);
//         liDCD.removaPrimeiro();
//         liDCD.removaUltimo();
//         System.out.println(liDCD.toString());
// //-----------------------------ListaEncadeadaDuplaCircularOrdenada---------------------------------------------------------------------------------------
//         ListaEncadeadaDuplaCircularOrdenada<String> liDCO = new ListaEncadeadaDuplaCircularOrdenada<>();

//         try {
//             liDCO.inserir(1);
//             liDCO.inserir(10);
//             liDCO.inserir(5);
//             liDCO.getPrimeiro();
//             liDCO.getUltimo();
//             liDCO.inserir(7);
//             System.out.println(liDCO.getPrimeiro());
//             System.out.println(liDCO.getUltimo());
//             if(liDCO.tem(5)){
//                 System.out.println("Tem : "+ liDCO.toString());
//             }else{System.out.println("Não Tem : "+ liDCO.toString());}
//             liDCO.inverter();
//         }catch (Exception e){
//             e.printStackTrace();
//             throw new Exception("informaçÕes invÁlidas");}

//         System.out.println(liDCO.toString());
//         liDCO.inserir(2);
//         liDCO.inserir(3);
//         liDCO.inserir(0);
//         liDCO.inserir(9);
//         System.out.println(liDCO.toString());
//         liDCO.remova(2);
//         liDCO.removaPrimeiro();
//         liDCO.removaUltimo();
//         System.out.println(liDCO.toString());

        
     }
}