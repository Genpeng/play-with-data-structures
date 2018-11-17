package ch09_segment_tree;

/**
 * A merge function, which combines the values of two elements into one.
 * Mergers can passed to the constructor function of segment tree to combine
 * the values of two elements.
 *
 * @param <E> the type of elements
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/17
 */
@FunctionalInterface
public interface Merger<E> {
    /**
     * Combines the values of two elements into one
     *
     * @param e1 E, one element
     * @param e2 E, another element
     * @return E, the merged value of two elements
     */
    E merge(E e1, E e2);
}
