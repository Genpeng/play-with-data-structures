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
     * Constructs a max heap with a specified array.
     *
     * @param arr E[], the specified array
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; --i) {
            siftDown(i);
        }
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

    /**
     * Adds an element to the heap.
     *
     * @param e E, the element to added
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // ======================================================================================= //

    // ======================================================================================= //
    // Read operations

    /**
     * Peeks the element of the root in the heap (the maximum or minimum element).
     *
     * @return E, the element of the root in the heap
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("[ERROR] The max heap is empty!");
        }
        return data.getFirst();
    }

    /**
     * Returns the element of the root in the heap (the maximum or minimum element).
     *
     * @return E, the element of the root in the heap
     */
    public E extractMax() {
        E ret = findMax();

        // 1. Exchanges the first and last elements
        data.swap(0, data.getSize() - 1);

        // 2. Removes the last element (the maximum element)
        data.removeLast();

        // 3. Sifts down and adjusts the structure of the heap
        siftDown(0);

        return ret;
    }

    // ======================================================================================= //

    // ======================================================================================= //
    // Update operations

    /**
     * Replaces the element of the root in the heap with a new element <code>e</code>.
     *
     * @param e E, the new element
     * @return E, the element of the root in the heap (element to be replaced)
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
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

    /**
     * Adjusts the structure of the binary heap after return the element of the root,
     * so that all the nodes satisfy properties of binary heap.
     *
     * @param k int, the index of the root
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int i = leftChild(k);
            if (i + 1 < data.getSize() &&
                data.get(i+1).compareTo(data.get(i)) > 0) {
                ++i; // i is the index of maximum element in the left and right children
            }

            if (data.get(k).compareTo(data.get(i)) >= 0) {
                break;
            }
            data.swap(k, i);
            k = i;
        }
    }

    // ======================================================================================= //
}
