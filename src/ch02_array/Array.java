package ch02_array;

/**
 * A self-defined array class, which is efficient and dynamic.
 *
 * @author  StrongXGP
 * @date    2018/06/10
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * Constructor.
     */
    public Array() {
        this(10);
        size = 0;
    }

    /**
     * Constructor with parameter.
     *
     * @param capacity int, the capacity of the array
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Return the number of elements in the array.
     *
     * @return int, the number of elements
     */
    public int getSize() {
        return size;
    }

    /**
     * Return the capacity of the array.
     *
     * @return int, the capacity of the array
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * Check whether the array is empty.
     *
     * @return boolean, true if the array is empty and false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Change the capacity of the array.
     *
     * @param newCapacity new capacity of the array
     */
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0; i<size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i=0; i<size; i++) {
            sb.append(data[i]);
            if (i < size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Create operation
    // ============================================================================ //

    /**
     * Add an element to the end of the array.
     *
     * @param e E object, the element to add
     */
    public void addLast(E e) {
        insert(size, e);
    }

    /**
     * Add an element to the front of the array.
     *
     * @param e E object, the element to add
     */
    public void addFirst(E e) {
        insert(0, e);
    }

    /**
     * Insert an element at given index.
     *
     * @param index int, the position to insert element
     * @param e E object, the element to insert
     */
    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index!!!");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i=size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // Read operation
    // ============================================================================ //

    /**
     * Return the element at the given index.
     *
     * @param index int, the position to return element
     * @return E object, the element to return
     */
    public E get(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Get failed. Illegal index!!!");
        }
        return data[index];
    }

    /**
     * Return the first element in the array.
     *
     * @return E object, the first element in the array
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * Return the last element in the array.
     *
     * @return E object, the last element in the array.
     */
    public E getLast() {
        return get(size-1);
    }

    /**
     * Check whether the array contains the element.
     *
     * @param e E object, the element to find
     * @return boolean, true if the array contains the element
     */
    public boolean contains(E e) {
        for (int i=0; i<size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find out the first index of the element in the array,
     * if the element does note exist, return -1.
     *
     * @param e E object, the element to find
     * @return the index of the element or -1 (if not exist)
     */
    public int find(E e) {
        for (int i=0; i<size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // Update operation
    // ============================================================================ //

    /**
     * Reset the value at the given index.
     *
     * @param index int, the position to reset element.
     * @param e E object, the new element
     */
    public void set(int index, E e) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Set failed. Illegal index!!!");
        }
        data[index] = e;
    }

    // Delete operation
    // ============================================================================ //

    /**
     * Remove the element at the given index.
     *
     * @param index int, the position to remove element
     * @return E object, the element to remove
     */
    public E remove(int index) {
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("Remove failed. Illegal index!!!");
        }

        E res = data[index];
        for (int i=index+1; i<size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length/4 && data.length/2 != 0) {
            resize(data.length/2);
        }

        return res;
    }

    /**
     * Remove the element from the array.
     *
     * @param e E object, the element to remove
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * Remove the first element in the array.
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last element in the array.
     */
    public E removeLast() {
        return remove(size-1);
    }
}
