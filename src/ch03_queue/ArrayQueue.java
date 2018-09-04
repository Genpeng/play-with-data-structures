package ch03_queue;

import ch02_array.Array;

/**
 * The self-defined queue class.
 *
 * @author  StrongXGP
 * @date    2018/06/17
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    /**
     * Constructor.
     */
    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * Constructor with parameter.
     *
     * @param capacity the capacity of the queue.
     */
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * Return the capacity of the queue.
     *
     * @return int, the capacity of the queue
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("head [");
        for (int i=0; i<array.getSize(); i++) {
            sb.append(array.get(i));
            if (i < array.getSize()-1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
