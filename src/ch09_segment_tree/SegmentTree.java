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

    public E get(int index) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("[ERROR] Illegal index!");
        }
        return data[index];
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
     * Builds a segment tree with the index of its root is <code>rootIndex</code>, where
     * the lower bound index of the interval is <code>lowerBoundIndex</code>, and the upper
     * bound index of the interval is <code>upperBoundIndex</code>.
     *
     * @param rootIndex int, the index of the root of the segment tree in the static array
     * @param lowerBoundIndex int, the index of the lower bound in the interval
     * @param upperBoundIndex int, the index of the upper bound in the interval
     */
    private void buildSegmentTree(int rootIndex, int lowerBoundIndex, int upperBoundIndex) {
        if (lowerBoundIndex == upperBoundIndex) {
            tree[rootIndex] = data[lowerBoundIndex];
            return;
        }

        // calculate left and right child index
        int leftChildIndex = leftChild(rootIndex);
        int rightChildIndex = rightChild(rootIndex);

        // int midIndex = (lowerBoundIndex + upperBoundIndex) / 2;
        int midIndex = lowerBoundIndex + (upperBoundIndex - lowerBoundIndex) / 2;
        buildSegmentTree(leftChildIndex, lowerBoundIndex, midIndex);
        buildSegmentTree(rightChildIndex, midIndex + 1, upperBoundIndex);

        tree[rootIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    // ============================================================================ //
}
