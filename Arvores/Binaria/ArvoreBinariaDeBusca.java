public class ArvoreBinariaDeBusca<X extends Comparable<X>> {
    private Nodo<X> raiz;

    public ArvoreBinariaDeBusca() {
        this.raiz = null;
    }

    public ArvoreBinariaDeBusca(X value) {
        this.raiz = new Nodo<>(value);
    }

    public void inclui(X item) throws Exception {
        if (item == null) throw new Exception("item nulo");
        Nodo<X> atual = this.raiz;
        while (true) {
            if (item.compareTo(atual.getInfo()) < 0 &&
                    atual.getEsquerdo() != null) {
                atual = atual.getEsquerdo();
            } else if (item.compareTo(atual.getInfo()) > 0 &&
                    atual.getDireito() != null) {
                atual = atual.getDireito();
            } else if (item.compareTo(atual.getInfo()) == 0) {
                throw new Exception("este item ja existe na árvore");
            } else {
                break;
            }
        }
        if (item.compareTo(atual.getInfo()) < 0) {
            atual.setEsquerdo(new Nodo<>(item));
        } else if (item.compareTo(atual.getInfo()) > 0) {
            atual.setDireito(new Nodo<>(item));
        }
    }

    public void remova(X item) throws Exception {
        this.raiz = removaRecursivo(this.raiz, item);
    }

    private Nodo<X> removaRecursivo(Nodo<X> galho, X item) throws Exception {
        if (galho == null) throw new Exception("item não encontrado na árvore");

        if (item.compareTo(galho.getInfo()) < 0) {
            galho.setEsquerdo(removaRecursivo(galho.getEsquerdo(), item));
        } else if (item.compareTo(galho.getInfo()) > 0) {
            galho.setDireito(removaRecursivo(galho.getDireito(), item));
        } else {
            // Caso o nodo tenha um ou nenhum filho
            if (galho.getEsquerdo() == null) {
                return galho.getDireito();
            } else if (galho.getDireito() == null) {
                return galho.getEsquerdo();
            }
            // Nodo com dois filhos
            X menorValorDireita = encontraMinimo(galho.getDireito()).getInfo();
            galho.setInfo(menorValorDireita);
            galho.setDireito(removaRecursivo(galho.getDireito(), menorValorDireita));
        }
        return galho;
    }

    private Nodo<X> encontraMinimo(Nodo<X> galho) {
        while (galho.getEsquerdo() != null) {
            galho = galho.getEsquerdo();
        }
        return galho;
    }

    public void balanceieSe() {
        if (this.raiz == null) return;
        if (Math.abs(altura(this.raiz.getEsquerdo()) - altura(this.raiz.getDireito())) > 1) {
            this.raiz = balancear(this.raiz);
        }
    }

    private Nodo<X> balancear(Nodo<X> galho) {
        int balanceamento = altura(galho.getEsquerdo()) - altura(galho.getDireito());

        if (balanceamento > 1) {
            if (altura(galho.getEsquerdo().getEsquerdo()) >= altura(galho.getEsquerdo().getDireito())) {
                galho = rotacaoDireita(galho);
            } else {
                galho.setEsquerdo(rotacaoEsquerda(galho.getEsquerdo()));
                galho = rotacaoDireita(galho);
            }
        } else if (balanceamento < -1) {
            if (altura(galho.getDireito().getDireito()) >= altura(galho.getDireito().getEsquerdo())) {
                galho = rotacaoEsquerda(galho);
            } else {
                galho.setDireito(rotacaoDireita(galho.getDireito()));
                galho = rotacaoEsquerda(galho);
            }
        }
        return galho;
    }

    private int altura(Nodo<X> galho) {
        if (galho == null) return 0;
        return 1 + Math.max(altura(galho.getEsquerdo()), altura(galho.getDireito()));
    }

    private Nodo<X> rotacaoDireita(Nodo<X> y) {
        Nodo<X> x = y.getEsquerdo();
        Nodo<X> T2 = x.getDireito();
        x.setDireito(y);
        y.setEsquerdo(T2);
        return x;
    }

    private Nodo<X> rotacaoEsquerda(Nodo<X> x) {
        Nodo<X> y = x.getDireito();
        Nodo<X> T2 = y.getEsquerdo();
        y.setEsquerdo(x);
        x.setDireito(T2);
        return y;
    }

    @Override
    public String toString() {
        return toString(this.raiz, "", true);
    }

    private String toString(Nodo<X> galho, String prefix, boolean isTail) {
        StringBuilder sb = new StringBuilder();

        if (galho != null) {
            sb.append(prefix)
                    .append(isTail ? "└── " : "├── ")
                    .append(galho.getInfo().toString())
                    .append("\n");

            String pointer = isTail ? "    " : "│   ";

            if (galho.getEsquerdo() != null || galho.getDireito() != null) {
                if (galho.getEsquerdo() != null) {
                    sb.append(toString(galho.getEsquerdo(), prefix + pointer, galho.getDireito() == null));
                }
                if (galho.getDireito() != null) {
                    sb.append(toString(galho.getDireito(), prefix + pointer, true));
                }
            }
        }

        return sb.toString();
    }
}
