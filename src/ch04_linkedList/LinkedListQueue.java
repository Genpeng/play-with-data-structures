package ch04_linkedList;

import ch03_queue.Queue;

/**
 * Use the self-defined class {@code LinkedList} to implement all the functions of a queue.
 *
 * @param <E> the type of elements
 * @author  StrongXGP
 * @date    2018/06/21
 */
public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node nest) {
            this.e = e;
            this.next = nest;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * The head of the queue.
     */
    private Node head;
    /**
     * The tail of the queue.
     */
    private Node tail;
    /**
     * The number of elements in the queue.
     */
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue!!!");
        }

        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty!!!");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: head ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + " <- ");
            cur = cur.next;
        }
        res.append("null tail");
        return res.toString();
    }
}
