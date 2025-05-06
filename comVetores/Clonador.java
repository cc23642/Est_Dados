public class Clonador {
    
    @SuppressWarnings("unchecked")
    public X clone(X objeto) throws CloneNotSupportedException {
        if (objeto instanceof Cloneable) {
            // Utiliza reflexão para chamar o método clone
            try {
                // Obtém o método clone da classe do objeto
                java.lang.reflect.Method metodoClone = objeto.getClass().getMethod("clone");
                // Invoca o método e retorna o objeto clonado
                return (X) metodoClone.invoke(objeto);
            } catch (NoSuchMethodException e) {
                throw new CloneNotSupportedException("O método clone não está disponível.");
            } catch (Exception e) {
                throw new CloneNotSupportedException("Erro ao clonar o objeto: " + e.getMessage());
            }
        } else {
            throw new CloneNotSupportedException("O objeto não é clonável.");
        }
    }
}
