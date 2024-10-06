public class ListaEncadeadaOrdenada<X extends Comparable<X>> {
    
    private NoSimples<X> primeiro = null;

    public ListaEncadeadaOrdenada(){
        this.primeiro = null;
    }

    public boolean tem(X i) {
        NoSimples<X> atual = this.primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(i)) return true;
            atual = atual.getProx();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("[");
        if (this.primeiro == null) return "[]";
        ret.append(this.primeiro.getInfo().toString());
        NoSimples<X> atual = this.primeiro.getProx();
        while (atual != null) {
            ret.append(", ").append(atual.getInfo());
            atual = atual.getProx();
        }
        return ret.append("]").toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        
        ListaEncadeadaOrdenada<X> listaObj = (ListaEncadeadaOrdenada<X>) obj;
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoObj = listaObj.primeiro;

        while (atualDoThis != null && atualdoObj != null) {
            if (!atualDoThis.getInfo().equals(atualdoObj.getInfo())) return false;
            atualDoThis = atualDoThis.getProx();
            atualdoObj = atualdoObj.getProx();
        }
        return atualDoThis == null && atualdoObj == null;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        NoSimples<X> atual = this.primeiro;
        while (atual != null) {
            ret = ret * 31 + (atual.getInfo() != null ? atual.getInfo().hashCode() : 0);
            atual = atual.getProx();
        }
        return ret;
    }

    public ListaEncadeadaOrdenada(ListaEncadeadaOrdenada<X> modelo) throws Exception {
        if (modelo == null) throw new Exception("modelo nulo");
        if (modelo.primeiro == null) {
            this.primeiro = null;
            return;
        }
        this.primeiro = new NoSimples<X>(modelo.primeiro);
        NoSimples<X> atualDoThis = this.primeiro;
        NoSimples<X> atualdoModelo = modelo.primeiro.getProx();

        while (atualdoModelo != null) {
            atualDoThis.setProx(new NoSimples<X>(atualdoModelo));
            atualDoThis = atualDoThis.getProx();
            atualdoModelo = atualdoModelo.getProx();
        }
    }

    public Object clone() {
        try {
            return new ListaEncadeadaOrdenada<X>(this);
        } catch (Exception e) {
            return null;
        }
    }

    public void removaPrimeiro() throws Exception {
        if (this.primeiro == null) throw new Exception("Nó inválido");
        this.primeiro = this.primeiro.getProx();
    }

    public void removaUltimo() throws Exception {
        if (this.primeiro == null) throw new Exception("Lista vazia");
        if (this.primeiro.getProx() == null) {
            this.primeiro = null;
            return;
        }

        NoSimples<X> atual = this.primeiro;
        while (atual.getProx().getProx() != null) {
            atual = atual.getProx();
        }
        atual.setProx(null);
    }

    public X getPrimeiro() throws Exception {
        if (this.primeiro == null) throw new Exception("ponteiro nulo");
        return this.primeiro.getInfo();
    }

    public X getUltimo() throws Exception {
        if (this.primeiro == null) throw new Exception("ponteiro nulo");
        NoSimples<X> atual = this.primeiro;
        while (atual.getProx() != null) {
            atual = atual.getProx();
        }
        return atual.getInfo();
    }

    public X get(int posicao) throws Exception {
        if (posicao < 0) throw new Exception("Posição inválida");
        NoSimples<X> atual = this.primeiro;
        int index = 0;
        
        while (atual != null && index < posicao) {
            atual = atual.getProx();
            index++;
        }
        if (atual == null) throw new Exception("ponteiro nulo");
        return atual.getInfo();
    }

    public void remova(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho()) throw new Exception("Posição inválida");
        if (posicao == 0) {
            removaPrimeiro();
            return;
        }

        NoSimples<X> atual = this.primeiro;
        for (int index = 0; index < posicao - 1; index++) {
            atual = atual.getProx();
        }
        if (atual.getProx() != null) {
            atual.setProx(atual.getProx().getProx());
        }
    }

    private int tamanho() {
        int count = 0;
        NoSimples<X> atual = this.primeiro;
        while (atual != null) {
            count++;
            atual = atual.getProx();
        }
        return count;
    }

    public void inverter() {
        NoSimples<X> anterior = null;
        NoSimples<X> atual = this.primeiro;
        NoSimples<X> proximo;
        
        while (atual != null) {
            proximo = atual.getProx();
            atual.setProx(anterior);
            anterior = atual;
            atual = proximo;
        }
        this.primeiro = anterior;
    }

    public void inserir(X info) throws Exception {
        if (info == null) throw new Exception("informação ausente");
        
        NoSimples<X> novoNo = new NoSimples<>(info);
        if (primeiro == null || info.compareTo(primeiro.getInfo()) < 0) {
            novoNo.setProx(primeiro);
            primeiro = novoNo;
            return;
        }

        NoSimples<X> atual = primeiro;
        while (atual.getProx() != null && info.compareTo(atual.getProx().getInfo()) > 0) {
            atual = atual.getProx();
        }
        novoNo.setProx(atual.getProx());
        atual.setProx(novoNo);
    }
}
