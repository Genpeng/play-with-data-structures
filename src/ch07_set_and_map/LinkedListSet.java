package ch07_set_and_map;

import ch04_linked_list.LinkedList;

/**
 * A self-defined set class with a linked list as data container.
 *
 * @param <E> the type of elements
 *
 * @author  Genpeng Xu
 * @date    2018/09/19
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
