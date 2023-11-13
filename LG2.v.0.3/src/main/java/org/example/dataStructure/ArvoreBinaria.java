package org.example.dataStructure;

// Implementação de Árvore Binária
public class ArvoreBinaria<T> {
    private NodoArvore<T> raiz;

    public void inserir(T item) {
        raiz = inserirRecursivo(raiz, item);
    }

    private NodoArvore<T> inserirRecursivo(NodoArvore<T> nodo, T item) {
        if (nodo == null) {
            return new NodoArvore<>(item);
        }

        if (item.hashCode() < nodo.getElemento().hashCode()) {
            nodo.setEsquerda(inserirRecursivo(nodo.getEsquerda(), item));
        } else if (item.hashCode() > nodo.getElemento().hashCode()) {
            nodo.setDireita(inserirRecursivo(nodo.getDireita(), item));
        }

        return nodo;
    }

    public void emOrdem() {
        emOrdemRecursivo(raiz);
        System.out.println();
    }

    private void emOrdemRecursivo(NodoArvore<T> nodo) {
        if (nodo != null) {
            emOrdemRecursivo(nodo.getEsquerda());
            System.out.print(nodo.getElemento() + " ");
            emOrdemRecursivo(nodo.getDireita());
        }
    }
}
