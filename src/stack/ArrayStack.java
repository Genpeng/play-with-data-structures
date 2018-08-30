package stack;

import array.Array;

/**
 * The self-defined stack class.
 *
 * @param <E> the type of element
 * @author  StrongXGP
 * @date    2018/06/12
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    /**
     * Constructor.
     */
    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * Constructor with parameters.
     *
     * @param capacity the number of the elements
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * Return the capacity of the stack.
     *
     * @return int, the capacity of the stack
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // Create operation
    // ========================================================================= //

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    // Read operation
    // ========================================================================= //

    @Override
    public E peek() {
        return array.getLast();
    }

    // Delete operation
    // ========================================================================= //

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("[");
        for (int i=0; i<array.getSize(); i++) {
            sb.append(array.get(i));
            if (i < array.getSize()-1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
