public class Clonador<X> {

    public X clone(X objeto) {
        if (objeto == null) {
            return null;
        } else if (objeto instanceof NoSimples) {
            return (X)cloneNoSimples(objeto);
        } else {
            // Implemente aqui a lógica de clonagem para outros tipos de objetos, se necessário
            // Se X for um tipo de objeto que pode ser clonado de outra maneira, adicione a lógica aqui
            // Por exemplo, se X for um tipo de objeto que implementa a interface Cloneable
            // você poderia usar o método clone() dessa interface.
            // Se X for um tipo primitivo ou uma classe imutável, pode ser seguro retornar diretamente o objeto.
            // Se necessário, adicione outras verificações e tratamentos específicos para o seu caso de uso.
            return objeto;
        }
    }

    // Método específico para clonar objetos do tipo NoSimples
    private NoSimples<X> cloneNoSimples(NoSimples<X> no) {
        if (no == null) {
            return null;
        } else {
            try {
                // Crie uma nova instância de NoSimples com a mesma informação
                NoSimples<X> novoNo = new NoSimples<X>(no.getInfo());
                // Retorne o novo nó clonado
                return novoNo;
            } catch (Exception e) {
                // Trate exceções, se necessário
                // Aqui, se houver uma exceção ao criar o novo nó, podemos simplesmente retornar null
                return null;
            }
        }
    }
}
