package org.example.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

// Implementação de Fila
public class Fila<T> {
    private Queue<T> items = new LinkedList<>();

    public void enfileirar(T item) {
        items.offer(item);
    }

    public T desenfileirar() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return items.poll();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
