public class ListaEncadeadaDuplaCircularDesordenada<X> {
    
    private NoDuplo<X> primeiro = null;
    private NoDuplo<X> ultimo = null;

    public ListaEncadeadaDuplaCircularDesordenada(){
        this.primeiro=null;
    }

    public void guardeNoInicio(X i)throws Exception{
        if(i==null)throw new Exception("informação inválida");
        this.primeiro = new NoDuplo<X>(i, this.primeiro, this.primeiro);
    }

    public void guardaNoFinal(X i)throws Exception{
        if(i==null)throw new Exception("informaçaõ inválida");
        if(this.primeiro==null){this.primeiro = new NoDuplo<X>(i);}
        NoDuplo<X> atual = this.primeiro;
        while(atual.getProx()!=this.primeiro){
            atual = atual.getProx();
        }
        this.ultimo =new NoDuplo<X>(i,this.primeiro,atual);
        atual.setProx(ultimo);
        primeiro.setAnt(ultimo);
    }

    public boolean tem (X i){
        NoDuplo<X> atual = this.primeiro;
        while(atual.getProx()!=this.primeiro){
            if(atual.getInfo().equals(i))return true;
            atual =atual.getProx();
        }
        return false;
    }    

    @Override
    public String toString(){
        String ret="[";
        if (this.primeiro==null) return "[]";//se o valor for nulo retorna lista vazia
        ret += this.primeiro.getInfo().toString();
        NoDuplo<X> atual = this.primeiro.getProx();
        while (atual!=null) {
            ret+=", "+atual.getInfo();
            atual=atual.getProx();
        }
        return ret+"]";
    }
    
    public boolean equals (ListaEncadeadaDuplaCircularDesordenada<X> obj){
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj.getClass()!=this.getClass()) return false;
        NoDuplo<X> atualDoThis = this.primeiro;
        NoDuplo<X> atualdoObj = (obj).primeiro;

        while(atualDoThis != null && atualdoObj != null)return false;
        return true;
    }

    public int hashCode(){
        int ret=1;

        NoDuplo<X> atual=this.primeiro;
        while(atual!=null){
            ret=ret*2+atual.getInfo().hashCode();
            atual=atual.getProx();
        }

        if(ret<0) ret=-ret;
        return ret;
    }

    public ListaEncadeadaDuplaCircularDesordenada(ListaEncadeadaDuplaCircularDesordenada<X> modelo)throws Exception{
        if(modelo==null){throw new Exception("modelo nulo");}
        if(modelo.primeiro==null){
            this.primeiro =null;
            return;
        }

        this.primeiro = new NoDuplo<X>(modelo.primeiro.getInfo());
        NoDuplo<X> atualDoThis = this.primeiro;
        NoDuplo<X> atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo.getProx() != modelo.primeiro) {
            atualDoThis.setProx(new NoDuplo<X>(atualDoModelo.getInfo()));
            atualDoThis.getProx().setAnt(atualDoThis);
            atualDoThis = atualDoThis.getProx();
            atualDoModelo = atualDoModelo.getProx();
        }
    }

    public Object clone(){
        ListaEncadeadaDuplaCircularDesordenada<X> ret=null;

        try{
            ret = new ListaEncadeadaDuplaCircularDesordenada<X>(this);
        }catch (Exception erro){}
        return ret;
    }

    public void removaPrimeiro()throws Exception{
        if(this.primeiro==null)throw new Exception("lista vazia");
        this.primeiro = this.primeiro.getProx();
        this.primeiro.setAnt(this.ultimo);
    }

    public void removaUltimo() throws Exception
    {
        if(this.primeiro==null)throw new Exception("lista vazia");
        if(this.primeiro.getProx()==this.primeiro){this.primeiro.setProx(this.primeiro);}

        NoDuplo<X> atual = this.primeiro;
        while (atual.getProx()!=this.primeiro) {
            atual = atual.getProx();            
        }
        atual.setProx(this.primeiro);
    }

    public X getPrimeiro() throws Exception{
        if(this.primeiro==null) throw new Exception("ponteiro nulo");
        X infoPrimeiro = new Clonador<X>().clone(this.primeiro.getInfo());
        return infoPrimeiro;
    }

    public X getUltimo()throws Exception{
        if(this.primeiro==null)throw new Exception("ponteiro nulo");
        NoDuplo<X> atual = this.primeiro;
        atual=atual.getAnt();
        
        X infoUltimo = new Clonador<X>().clone(atual.getInfo());
        return infoUltimo;
    }

    @SuppressWarnings("unused")// não precisamos da menságem de uso
    public X get (int posicao) throws Exception{
        NoDuplo<X> atual = this.primeiro;
        int cout = 0;
        while(atual.getProx()!=this.primeiro && cout<posicao){
            cout++;
            atual = atual.getProx();
        }
        if(atual==null) throw new Exception("ponteiro nulo");
        else{
            X infoAtual = new Clonador<X>().clone(atual.getInfo());
            return infoAtual;
        }
    }

    public void remova(int posicao)throws Exception{
        if(posicao<0||posicao>this.tamanho())throw new Exception("Posição inválida");
        if(posicao == 0)removaPrimeiro();

        NoDuplo<X> atual = this.primeiro;
        int index = 0;
        while(index<posicao && atual.getProx()!=this.primeiro){
            atual = atual.getProx();
            index++;
        }
        atual.setProx(atual.getProx().getProx());
        atual.getProx().setAnt(atual);
    }

    private int tamanho(){
        if(this.primeiro==null){return 0;}
        int count = 0;
        NoDuplo<X> atual = this.primeiro;
        while (atual.getProx()!=this.primeiro) {
            count ++;
            atual = atual.getProx();
        }return count;
    }
    
    public void inverter() {
        if (this.primeiro == null || this.primeiro.getProx() == null) {
            return;
        }
        
        NoDuplo<X> atual = this.primeiro;
        NoDuplo<X> anterior = null;
        NoDuplo<X> proximo = null;
    
        while (atual != null) {
            proximo = atual.getProx();
            atual.setProx(anterior);
            anterior = atual;
            atual = proximo;
        }
        this.primeiro = anterior;
    }

    public void guardeEm (int posicao, X i)throws Exception{
        if(posicao<0 || posicao> this.tamanho()){
            throw new Exception("valor fora de escopo");
        }
        NoDuplo<X> atual = this.primeiro;
        if(posicao==0)this.guardeNoInicio(i);
        int index = 0;
        while (index<posicao) {
            atual = atual.getProx();
        }
        NoDuplo<X> guardePosicao = new NoDuplo<X>(i, atual.getProx(),atual);
        atual.setProx(guardePosicao);
    }
    



    
}
