package com.mycompany.miarbolitobnuwu;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 *
 * @author luisa
 */
public class LinkedListStack<T> {
    private final LinkedList<T> elementos = new LinkedList<>();

    public void push(T elemento) {
        elementos.addFirst(elemento);
    }

    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return elementos.removeFirst();
    }

    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return elementos.getFirst();
    }

    public boolean empty() {
        return elementos.isEmpty();
    }
}