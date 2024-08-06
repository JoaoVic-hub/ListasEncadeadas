package src;

public class TesteListaEncadeada {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        // Adiciona elementos
        lista.adicionaInicio(10);
        lista.adicionaInicio(5);
        lista.adicionaFinal(20);
        lista.adiciona(2, 15);

        // Imprime a lista
        System.out.println("Lista: " + lista);

        // Verifica tamanho da lista
        System.out.println("Tamanho: " + lista.getTamanho());

        // Verifica se a lista está vazia
        System.out.println("Está vazia: " + lista.estaVazia());

        // Busca por posição
        System.out.println("Elemento na posição 2: " + lista.buscaPorPosicao(2));

        // Modifica elemento na posição 2
        lista.modificaElemento(2, 25);
        System.out.println("Lista após modificação: " + lista);

        // Remove elemento na posição 1
        lista.remove(1);
        System.out.println("Lista após remoção: " + lista);
    }
}
