public class Execs {
    public static void main(String[] args){
        System.err.println("oi");
        System.err.println(eMenorQue(10, 5));

        System.err.println(eMaiorQue(8,-2));
        System.err.println(potencia(8, 2));
        System.err.println(multiplicacao(-4, -5));
        System.err.println(valAbsoluto(-5));
        System.err.println(subtracao(3,3));
        System.err.println(soma(3, 5));
        System.err.println(eMenorQueZero(0));

    }

    public static int aux1(int num1, int num2){
        if(num1==0)return 1;
        if(num2==0)return -1;

        return aux1(++num1, --num2);
    }

    public static boolean eMenorQueZero (int num){
        if (num==0) return false;
        if (aux1(num, num)== 1) return true;
        if (aux1(num, num)== -1) return false;
        return false;
            
    }

    public static int soma(int num1, int num2){
        
        if (num1==0) return num2;
        if (num2==0) return num1;
        if (eMenorQueZero(num2)==true) return soma(--num1, ++num2);
        return soma(++num1, --num2);
    }

    public static int subtracao(int num1, int num2){
        if (num2==0) return num1;
        if (eMenorQueZero(num1)==true) {
            if (eMenorQueZero(num2)==true) {
                return subtracao(++num1, ++num2);
            }
        }
        return subtracao(--num1, --num2);
    }

    //que sacoooooooo pqp --->

    public static int valAbsoluto(int val){
        if (val==0) {return 0;}
        if(eMenorQueZero(val)){return -val;}
        return val;
    }


    // MAS QUE MERDAAAAAAAAA!
    //agor ta funcionando :)


    public static int multiplicacao(int num, int mlt){
        if (mlt==1) {
            return num;
        }
        if (mlt==0) {
            return 0;
        }
        if (eMenorQueZero(mlt)==true) {
            if(eMenorQueZero(num)){
                return soma(multiplicacao(num, ++mlt), num);
            }
            return subtracao(multiplicacao(num, ++mlt), num);
        }
        return soma(multiplicacao(num, --mlt), num);
        
    }

    public static int potencia(int num, int expo){
        if (expo==0) {return 1;}
        if (expo==1) {return num;}
        return multiplicacao(potencia(num, --expo), num);
    }

    public static boolean eMaiorQue(int x, int y){
        if(eMenorQueZero(y)){
            if (eMenorQueZero(x)) {
                return eMaiorQue(++x, ++y);
            }
            return true;
        }
        if (x==0) {
            return false;
        }
        if (y==0) {
            if (eMenorQueZero(x)) {return false;}
            return true;
        }
        return eMaiorQue(--x, --y);
    }

    public static boolean eMenorQue(int x, int y){
        if(eMenorQueZero(x)){
            if (eMenorQueZero(y)) {
                return eMenorQue(++x, ++y);
            }
            return true;
        }
        if (y==0) {
            return false;
        }
        if (x==0) {
            if (eMenorQueZero(y)) {return false;}
            return true;
        }
        return eMenorQue(--x, --y);
    }

    public static boolean menorIgualQue(int x, int y){
            if(x==y){return true;}
            if(eMenorQue(x, y)){return true;}
            return false;
    }

    public static boolean maiorIgualQue(int x, int y){
        if(x==y)return true;
        if(eMaiorQue(x, y))return true;
        return false;
    }

    public static boolean eDiferenteDe(int x, int y){
        if(x==y)return false;
        return true;
    }

    
}
