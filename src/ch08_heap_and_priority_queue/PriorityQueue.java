package ch08_heap_and_priority_queue;

import ch03_queue.Queue;

/**
 * A custom priority queue class based on max heap.
 *
 * @param <E> the type of elements in the queue
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/10
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> data;

    public PriorityQueue() {
        data = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.add(e);
    }

    @Override
    public E dequeue() {
        return data.extractMax();
    }

    @Override
    public E getFront() {
        return data.findMax();
    }
}
