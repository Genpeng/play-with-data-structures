package ch09_segment_tree;

/**
 * A custom segment tree class, which builds on a static array.
 *
 * @param <E> the type of elements
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/17
 */
public class SegmentTree<E> {
    /**
     * The full binary tree constructed by all the elements in the segment (interval).
     */
    private E[] tree;
    /**
     * All the elements in the segment (interval).
     */
    private E[] data;
    /**
     * A merger which provides a merge function to combine the values of two elements.
     */
    private Merger<E> merger;

    /**
     * Constructs a full binary tree according to the specified array.
     *
     * @param arr E[], the specified array to construct a full binary tree
     * @param merger Merger, a merger to provide a merge function
     */
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        // copy the array
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            data[i] = arr[i];
        }

        // build segment tree
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < tree.length; ++i) {
            if (tree[i] != null) {
                sb.append(tree[i]);
            } else {
                sb.append("null");
            }

            if (i < tree.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Returns the number of elements in the interval.
     *
     * @return the number of elements in the interval
     */
    public int getSize() {
        return data.length;
    }

    /**
     * Returns the corresponding element according to the index.
     *
     * @param index int, the index of the element in the array
     * @return E, the corresponding element at the given index
     */
    public E get(int index) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("[ERROR] Illegal index!");
        }
        return data[index];
    }

    /**
     * Returns the result in the query interval.
     *
     * @param queryL int, the lower bound index of query interval
     * @param queryR int, the upper bound index of query interval
     * @return E, the result of query
     */
    public E query(int queryL, int queryR) {
        if (isIllegal(queryL) || isIllegal(queryR) || queryL > queryR) {
            throw new IllegalArgumentException("[ERROR] Illegal query index!");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // ============================================================================ //
    // Some auxiliary functions

    /**
     * Returns the index of its left child according to the index of current node.
     *
     * @param index int, the index of current node.
     * @return int, the index of its left child
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * Returns the index of its right child according to the index of current node.
     *
     * @param index int, the index of current node.
     * @return int, the index of its right child
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * Builds a segment tree with the index of its root is <code>treeIndex</code>, where
     * the lower bound index of the interval is <code>l</code>, and the upper bound index
     * of the interval is <code>r</code>.
     *
     * @param treeIndex int, the index of the root of the segment tree in the static array
     * @param l         int, the index of the lower bound in the interval
     * @param r         int, the index of the upper bound in the interval
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        // calculate left and right child index
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        // int midIndex = (l + r) / 2;
        int midIndex = l + (r - l) / 2;
        buildSegmentTree(leftChildIndex, l, midIndex);
        buildSegmentTree(rightChildIndex, midIndex + 1, r);

        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    /**
     * Checks whether the given index is legal.
     *
     * @param index int, the position index to check
     * @return boolean, true if the index is legal, and false otherwise
     */
    private boolean isLegal(int index) {
        return index >= 0 && index <= data.length - 1;
    }

    /**
     * Checks whether the given index is illegal.
     *
     * @param index int, the position index to check
     * @return boolean, true if the index is illegal, and false otherwise
     */
    private boolean isIllegal(int index) {
        return !isLegal(index);
    }

    /**
     * Returns the result in the query interval, where the index of the root of the
     * segment tree is <code>treeIndex</code>, the lower bound index of the root is
     * <code>l</code>, the upper bound index of the root is <code>r</code>, the lower
     * bound index of query interval is <code>queryL</code>, and the upper bound index
     * of query interval is <code>queryR</code>.
     *
     * @param treeIndex int, the index of the root of the segment tree
     * @param l         int, the lower bound index of the root
     * @param r         int, the upper bound index of the root
     * @param queryL    int, the lower bound index of query interval
     * @param queryR    int, the upper bound index of query interval
     * @return E, the result of query
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;

        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        if (queryR <= mid) {
            return query(leftChildIndex, l, mid, queryL, queryR);
        } else if (queryL > mid) {
            return query(rightChildIndex, mid + 1, r, queryL, queryR);
        } else {
            E leftResult = query(leftChildIndex, l, mid, queryL, mid);
            E rightResult = query(rightChildIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }
    }

    // ============================================================================ //
}
