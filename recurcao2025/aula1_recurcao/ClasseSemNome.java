package recurcao2025.aula1_recurcao;

public class ClasseSemNome {
    // eficiente e não gasta tanto espaço nem tempo
    public int fatorialIterativo(int n)throws Exception {
        if(n < 0) {
            throw new Exception("Número negativo não é permitido");
        }
        if(n < 2) {
            return 1;
        }
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // ineficiente e gasta muito espaço e tempo
    // não é recomendado
    public int fatorialRecursivo(int n) throws Exception {
        if(n < 0) {
            throw new Exception("Número negativo não é permitido");
        }
        if (n < 2) {
            return 1;
        }
        return n * fatorialRecursivo(n - 1);
    }

    // ineficiente e gasta muito espaço e tempo
    // não é recomendado
    // mas é interessante para entender o conceito de recursão
    public int fatorialRecursivoComVariavel(int n)throws Exception{
        if(n < 0) {
            throw new Exception("Número negativo não é permitido");
        }
        if(n < 2) {
            return 1;
        }
        int fat = n*fatorialIterativo(-1);
        return fatorialRecursivoComVariavel(fat);
    }
}
