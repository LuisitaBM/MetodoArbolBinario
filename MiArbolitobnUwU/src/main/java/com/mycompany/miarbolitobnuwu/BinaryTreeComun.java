package com.mycompany.miarbolitobnuwu;

/**
 *
 * @author luisa
 */
public class BinaryTreeComun <T> implements ITree<T> {

    NodoArbolBinario<T> raiz;
    
    class NodoArbolBinario<T>{
        T dato;
        NodoArbolBinario<T> hijoIzq;
        NodoArbolBinario<T> hijoDer;
        
        public NodoArbolBinario (T dato){
            this.dato = dato;
        }
    }
    
    @Override
    public T getRootData() {
        //Obtiene la raiz del arbol
        if(raiz == null){
            return null;
        }
        return raiz.dato;
    }

    @Override
    public int getHeight() {
        return getHeight(raiz);
    }
    
    public int getHeight(NodoArbolBinario<T> nodo){
        int height = 0;
        if(nodo != null){
            height = 1 + Math.max(getHeight(nodo.hijoIzq), getHeight(nodo.hijoDer));
        }
        return height;
    }
    
    @Override
    public int getNumberNodes() {
        return getNumberNodes(raiz);
    }
    
    public int getNumberNodes(NodoArbolBinario<T> nodo) {
        //Obtiene  la cantidad de nodos que tiene el arbol
        if(nodo == null){
            return 0;
        }
        int nNodosIzq = getNumberNodes(nodo.hijoIzq);
        int nNodosDer = getNumberNodes(nodo.hijoDer);
        return 1 + nNodosIzq + nNodosDer;
    }

    @Override
    public boolean empty() {
        return raiz == null;
    }

    @Override
    public void crear() {
         raiz = null;
    }
    
}
