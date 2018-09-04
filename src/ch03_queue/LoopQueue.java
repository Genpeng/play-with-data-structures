package ch03_queue;

/**
 * The self-defined queue class.
 *
 * @author  StrongXGP
 * @date    2018/06/17
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    /**
     * Constructor.
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * Constructor with parameter.
     *
     * @param capacity int, the capacity of the queue
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    /**
     * Return the capacity of the queue.
     *
     * @return int, the capacity of the queue
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail+1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!!!");
        }
        return data[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from a empty queue!!!");
        }

        E bak = data[front];
        data[front] = null;
        front = (front+1) % data.length;
        size--;

        if (size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity() / 2);
        }

        return bak;
    }

    /**
     * Change the capacity of the queue.
     *
     * @param newCapacity int, the new capacity of the queue
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("head [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            sb.append(data[i]);
            if ((i+1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
