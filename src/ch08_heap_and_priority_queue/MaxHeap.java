package ch08_heap_and_priority_queue;

import ch02_array.Array;

/**
 * A custom (max) heap class that uses a dynamic array as data container,
 * so that the index of its parent node is $(i - 1) / 2$, where $i$
 * represents the index of current node, the index of its left child is
 * $2 * i + 1$, the index of its right child is $2 * i + 2$.
 *
 * @param <E> the type of elements
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/09
 */
public class MaxHeap<E extends Comparable<E>> {
    /**
     * All the elements in the heap.
     */
    private Array<E> data;

    /**
     * Constructs an empty heap with default capacity.
     */
    public MaxHeap() {
        data = new Array<>();
    }

    /**
     * Constructs an empty heap with specified capacity.
     *
     * @param capacity int, the specified capacity
     */
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    /**
     * Returns the number of elements in the heap.
     *
     * @return int, the number of elements in the heap
     */
    public int size() {
        return data.getSize();
    }

    /**
     * Checks whether the heap is empty.
     *
     * @return boolean, true if the heap is empty and false otherwise
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // ======================================================================================= //
    // Some auxiliary functions

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("[ERROR] Illegal index! The index 0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // ======================================================================================= //
}
