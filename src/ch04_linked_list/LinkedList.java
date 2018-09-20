package ch04_linked_list;

/**
 * A self-defined linked list class.
 *
 * @author  StrongXGP
 * @date    2018/06/18
 */
public class LinkedList<E> {
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

    private Node dummyHead;
    private int size;

    /**
     * Constructor.
     */
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * Return the number of elements in the linked list.
     *
     * @return int, the number of elements
     */
    public int getSize() {
        return size;
    }

    /**
     * Check whether the linked list is empty.
     *
     * @return boolean, true if the linked list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + " -> ");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append(" -> ");
        }
        res.append("null");
        return res.toString();
    }

    // Create operation
    // ============================================================================ //

    /**
     * Add an element to the index position of the linked list.
     *
     * @param index int, the position to add
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index!!!");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * Add an element to the head of the linked list.
     *
     * @param e E object, the element to add
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Add an element to the tail of the linked list.
     *
     * @param e E object, the element to add
     */
    public void addLast(E e) {
        add(size, e);
    }

    // Read operation
    // ============================================================================ //

    /**
     * Return the element at the given position in the linked list.
     *
     * @param index int, the position of the element
     * @return E object, the element to return
     */
    public E get(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Get failed. Illegal index!!!");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * Return the first element in the linked list.
     *
     * @return E object, the first element in the linked list
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * Return the last element in the linked list.
     *
     * @return E object, the last element in the linked list
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Check whether the linked list contains the given element.
     *
     * @param e E object, the element to check
     * @return boolean, true if the linked list contains the given element, and false otherwise
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // Update operation
    // ============================================================================ //

    /**
     * Change the value of the element at the given position in the linked list.
     *
     * @param index int, the position to change
     * @param e E object, changed value
     */
    public void set(int index, E e) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Set failed. Illegal index!!!");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // Delete operation
    // ============================================================================ //

    /**
     * Remove the element at the given position in the linked list.
     *
     * @param index int, the position to remove element
     * @return E object, the removed element
     */
    public E remove(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Remove failed. Illegal index!!!");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * Remove the first element in the linked list.
     *
     * @return E object, the first element
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last element in the linked list.
     *
     * @return E object, the last element
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * Remove the specified element in the linked list.
     *
     * @param e E object, the element to remove
     */
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }
}
