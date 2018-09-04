package ch04_linkedList;

import ch03_stack.Stack;

/**
 * Use the self-defined linked list to implement all the functions of a stack.
 *
 * @param <E> the type of elements
 * @author  StrongXGP
 * @date    2018/06/21
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> data = null;

    public LinkedListStack() {
        data = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(data);
        return res.toString();
    }
}
