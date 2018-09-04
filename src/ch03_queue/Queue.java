package ch03_queue;

/**
 * A interface class which defines the functions a queue must to implement.
 *
 * @param <E> the type of elements in the queue
 * @author  StrongXGP
 * @date    2018/06/17
 */
public interface Queue<E> {
    /**
     * Return the number of elements in the queue.
     *
     * @return int, the number of elements
     */
    int getSize();

    /**
     * Check whether the queue is empty.
     *
     * @return boolean, true if the queue is empty and false otherwise.
     */
    boolean isEmpty();

    /**
     * Add element to the tail of the queue.
     *
     * @param e E object, the element to add
     */
    void enqueue(E e);

    /**
     * Remove the element at the head of the queue.
     *
     * @return E object, the element to remove
     */
    E dequeue();

    /**
     * Return the element at the head of the queue.
     *
     * @return E object, the element to return
     */
    E getFront();
}
