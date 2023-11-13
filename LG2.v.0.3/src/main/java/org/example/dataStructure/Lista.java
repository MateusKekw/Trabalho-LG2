package org.example.dataStructure;

// Implementação de Lista Encadeada
public class Lista<T> {
    private Nodo<T> primeiro;

    public void adicionar(T item) {
        Nodo<T> novoNodo = new Nodo<>(item);
        if (primeiro == null) {
            primeiro = novoNodo;
        } else {
            Nodo<T> atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNodo);
        }
    }

    public void imprimir() {
        Nodo<T> atual = primeiro;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
