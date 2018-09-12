package ch07_set_and_map;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-defined set class with a binary search tree as data container.
 *
 * @param <E> the type of elements
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/09/12
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BSTSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public String toString() {
        return bst.toString();
    }
}
