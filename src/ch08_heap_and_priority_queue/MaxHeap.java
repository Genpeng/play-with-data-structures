package ch08_heap_and_priority_queue;

import ch02_array.Array;

/**
 * A custom (max) heap class that uses a dynamic array as data container.
 * Given the index $i$ of any node, the index of its parent node is
 * $(i - 1) / 2$, the index of its left child is $2 * i + 1$, and the
 * index of its right child is $2 * i + 2$.
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
    // Create operations

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // ======================================================================================= //

    // ======================================================================================= //
    // Some auxiliary functions

    /**
     * Returns the index of its parent node according to the index of current node.
     *
     * @param index int, the index of current node.
     * @return int, the index of its parent node
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("[ERROR] Illegal index! The index 0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * Returns the index of its left child according to the index of current node.
     *
     * @param index int, the index of current node.
     * @return int, the index of its left child
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * Returns the index of its right child according to the index of current node.
     *
     * @param index int, the index of current node.
     * @return int, the index of its right child
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * Adjusts the structure of the binary heap according to the new added element,
     * whose index is <code>k</code>, so that all the nodes satisfy properties of
     * binary heap.
     *
     * @param k int, the index of new added element
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // ======================================================================================= //
}
