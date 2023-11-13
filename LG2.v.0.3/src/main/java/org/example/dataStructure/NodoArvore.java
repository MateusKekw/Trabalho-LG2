package org.example.dataStructure;

public class NodoArvore<T> {
    private T elemento;
    private NodoArvore<T> esquerda;
    private NodoArvore<T> direita;

    public NodoArvore(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public NodoArvore<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NodoArvore<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NodoArvore<T> getDireita() {
        return direita;
    }

    public void setDireita(NodoArvore<T> direita) {
        this.direita = direita;
    }
}
