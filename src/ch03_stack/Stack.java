package ch03_stack;

/**
 * An interface class which defines the functions a stack must to implement.
 *
 * @param <E> the type of the element
 * @author  StrongXGP
 * @date    2018/06/12
 */
public interface Stack<E> {
    /**
     * Return the number of elements in the stack.
     *
     * @return the number of elements
     */
    int getSize();

    /**
     * Check whether the stack is empty.
     *
     * @return boolean, true if the stack is empty and false otherwise
     */
    boolean isEmpty();

    /**
     * Add an element to the top of the stack.
     *
     * @param e E object, the element to push
     */
    void push(E e);

    /**
     * Remove an element from the top of the stack.
     *
     * @return E object, the element to pop
     */
    E pop();

    /**
     * Return the element in the top of the stack.
     *
     * @return E object, the last element
     */
    E peek();
}
