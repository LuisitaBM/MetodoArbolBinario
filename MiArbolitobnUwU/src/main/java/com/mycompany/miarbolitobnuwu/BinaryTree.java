package com.mycompany.miarbolitobnuwu;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author luisa
 */

public class BinaryTree<T> extends BinaryTreeComun<T> implements ITreeIterator<T> {

    public BinaryTree() {
        raiz = null;
    }

    public BinaryTree(T datoRaiz) {
        raiz = new NodoArbolBinario<>(datoRaiz);
    }

    public BinaryTree(T datoRaiz, BinaryTree<T> arbolIzq, BinaryTree<T> arbolDer) {
        setTree(datoRaiz, arbolIzq, arbolDer);
    }

    private void setTree(T datoRaiz, BinaryTree<T> arbolIzq, BinaryTree<T> arbolDer) {
        raiz = new NodoArbolBinario<>(datoRaiz);
        if (arbolIzq != null && !arbolIzq.empty()) {
            raiz.hijoIzq = copy(arbolIzq.raiz);
        }
        if (arbolDer != null && !arbolDer.empty()) {
            raiz.hijoDer = copy(arbolDer.raiz);
        }
    }

    private NodoArbolBinario<T> copy(NodoArbolBinario<T> nodo) {
        if (nodo == null) {
            return null;
        }
        NodoArbolBinario<T> nuevoNodo = new NodoArbolBinario<>(nodo.dato);
        nuevoNodo.hijoIzq = copy(nodo.hijoIzq);
        nuevoNodo.hijoDer = copy(nodo.hijoDer);
        return nuevoNodo;
    }

    @Override
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    @Override
    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    @Override
    public Iterator<T> getPostorderIterator() {
        return new PostorderIterator();
    }

    private class InorderIterator implements Iterator<T> {
        private final LinkedListStack<NodoArbolBinario<T>> pilaNodos = new LinkedListStack<>();

        public InorderIterator() {
            pushSubArbolIzquierdo(raiz);
        }

        private void pushSubArbolIzquierdo(NodoArbolBinario<T> nodo) {
            while (nodo != null) {
                pilaNodos.push(nodo);
                nodo = nodo.hijoIzq;
            }
        }

        @Override
        public boolean hasNext() {
            return !pilaNodos.empty();
        }

        @Override
        public T next() {
            if (pilaNodos.empty()) {
                throw new NoSuchElementException();
            }
            NodoArbolBinario<T> nodoActual = pilaNodos.pop();
            pushSubArbolIzquierdo(nodoActual.hijoDer);
            return nodoActual.dato;
        }
    }

    private class PreorderIterator implements Iterator<T> {
        private final LinkedListStack<NodoArbolBinario<T>> pilaNodos = new LinkedListStack<>();

        public PreorderIterator() {
            if (raiz != null) {
                pilaNodos.push(raiz);
            }
        }

        @Override
        public boolean hasNext() {
            return !pilaNodos.empty();
        }

        @Override
        public T next() {
            if (pilaNodos.empty()) {
                throw new NoSuchElementException();
            }
            NodoArbolBinario<T> actual = pilaNodos.pop();
            if (actual.hijoDer != null) {
                pilaNodos.push(actual.hijoDer);
            }
            if (actual.hijoIzq != null) {
                pilaNodos.push(actual.hijoIzq);
            }
            return actual.dato;
        }
    }

    private class PostorderIterator implements Iterator<T> {
        private final LinkedListStack<NodoArbolBinario<T>> pilaFinal = new LinkedListStack<>();

        public PostorderIterator() {
            if (raiz != null) {
                LinkedListStack<NodoArbolBinario<T>> pilaAux = new LinkedListStack<>();
                pilaAux.push(raiz);
                while (!pilaAux.empty()) {
                    NodoArbolBinario<T> actual = pilaAux.pop();
                    pilaFinal.push(actual);
                    if (actual.hijoIzq != null) {
                        pilaAux.push(actual.hijoIzq);
                    }
                    if (actual.hijoDer != null) {
                        pilaAux.push(actual.hijoDer);
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !pilaFinal.empty();
        }

        @Override
        public T next() {
            if (pilaFinal.empty()) {
                throw new NoSuchElementException();
            }
            return pilaFinal.pop().dato;
        }
    }
}