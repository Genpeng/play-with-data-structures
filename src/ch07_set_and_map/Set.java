package ch07_set_and_map;

/**
 * A general interface which defines the functions a set must to implement.
 *
 * @param <E> the type of element
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/09/12
 */
public interface Set<E> {
    /**
     * Add a element {@code e} to the set.
     *
     * @param e E, the element to add
     */
    void add(E e);

    /**
     * Remove a element {@code e} from the set.
     *
     * @param e E, the element we want to remove
     */
    void remove(E e);

    /**
     * Check whether the set contains the element {@code e}.
     *
     * @param e E, the element we want to check
     * @return boolean, true if the set contains the element
     */
    boolean contains(E e);

    /**
     * Return the number of elements in the set.
     *
     * @return int, the number of elements
     */
    int getSize();

    /**
     * Check whether the set is empty.
     *
     * @return boolean, true if the set is empty
     */
    boolean isEmpty();
}
