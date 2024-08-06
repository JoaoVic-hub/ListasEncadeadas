package src;

public class ListaEncadeada {

    private No inicio;
    private No ultimo;
    private int tamanho = 0;

    private final String NAO_EXISTE = "Posição não existe.";
    private final String LISTA_VAZIA = "Lista está vazia.";

    // Criação da lista vazia
    public ListaEncadeada() {
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    // Verificar se a lista está vazia
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    // Obter o tamanho da lista
    public int getTamanho() {
        return this.tamanho;
    }

    // Obter o valor do elemento de uma determinada posição na lista
    public int buscaPorPosicao(int posicao) {
        return this.buscaNo(posicao - 1).getElemento();
    }

    // Modificar o valor do elemento de uma determinada posição na lista
    public void modificaElemento(int posicao, int elemento) {
        if (this.posicaoNaoExiste(posicao - 1)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        No no = this.buscaNo(posicao - 1);
        no.setElemento(elemento);
    }

    // Inserir um elemento em uma determinada posição
    public void adiciona(int posicao, int elemento) {
        if (this.posicaoNaoExiste(posicao - 1) && posicao != tamanho + 1) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        if (posicao == 1) {
            this.adicionaInicio(elemento);
        } else if (posicao == this.tamanho + 1) {
            this.adicionaFinal(elemento);
        } else {
            No noAnterior = this.buscaNo(posicao - 2);
            No proximoNo = noAnterior.getProximo();
            No novoNo = new No(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    public void adicionaInicio(int elemento) {
        if (this.tamanho == 0) {
            No novoNo = new No(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No novoNo = new No(elemento, this.inicio);
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    public void adicionaFinal(int elemento) {
        No celula = new No(elemento);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    // Retirar um elemento de uma determinada posição
    public int remove(int posicao) {
        if (this.posicaoNaoExiste(posicao - 1)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        if (posicao == 1) {
            return this.removeInicio();
        }
        if (posicao == this.tamanho) {
            return this.removeFinal();
        }
        No noAnterior = this.buscaNo(posicao - 2);
        No atual = noAnterior.getProximo();
        No proximo = atual.getProximo();
        noAnterior.setProximo(proximo);
        atual.setProximo(null);
        this.tamanho--;
        return atual.getElemento();
    }

    public int removeInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        int removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {
            this.ultimo = null;
        }

        return removido;
    }

    public int removeFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        if (this.tamanho == 1) {
            return this.removeInicio();
        }
        No penultimoNo = this.buscaNo(this.tamanho - 2);
        int removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }

    private No buscaNo(int posicao) {
        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        No noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    private boolean posicaoNaoExiste(int posicao) {
        return !(posicao >= 0 && posicao < this.tamanho);
    }

    // Imprimir os elementos de toda a lista
    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        return builder.toString();
    }
}

