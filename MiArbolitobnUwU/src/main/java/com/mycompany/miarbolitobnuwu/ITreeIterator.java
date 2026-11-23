package com.mycompany.miarbolitobnuwu;

import java.util.Iterator;

/**
 *
 * @author luisa
 */
public interface ITreeIterator<T> {
    Iterator<T> getInorderIterator();
    Iterator<T> getPreorderIterator();
    Iterator<T> getPostorderIterator();
}