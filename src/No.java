package src;

public class No {
    private int elemento;
    private No proximo;

    public No(int elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public No(int elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
