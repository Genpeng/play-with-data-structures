package ch06_binary_search_tree;

import java.util.*;

/**
 * A binary search tree based {@link Node} implementation.
 *
 * @param <E> the type of element in the node
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/07/12
 */
public class BinarySearchTree<E>
        implements Iterable<E>, Cloneable, java.io.Serializable
{
    /**
     * The root of binary search tree
     */
    private transient Node root;
    /**
     * The number of nodes in the binary search tree
     */
    private transient int size;
    /**
     * The comparator for comparing the elements of the nodes
     *
     * @serial
     */
    private Comparator<? super E> comparator;

    /**
     * Constructs an empty binary search tree.
     */
    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
        this.comparator = null;
    }

    /**
     * Constructs an empty binary search tree with the specified comparator.
     *
     * @param comparator Comparator, an object implements {@code Comparator} interface
     *                   for comparing the elements of the nodes
     */
    public BinarySearchTree(Comparator<E> comparator) {
        this.root = null;
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * Returns the number of nodes in the binary search tree.
     *
     * @return int, the number of nodes
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks whether the binary search tree is empty.
     *
     * @return boolean, true if the binary search tree is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Adds an element {@code e} to this binary search tree (non-recursive version).
     *
     * @param e E, the element to add
     */
    public void addNR(E e) {
        if (this.root == null) {
            this.root = new Node(e);
            ++size;
            return;
        }

        Node node = null;
        Node subtree = this.root;
        while (subtree != null) {
            if (compare(e, subtree.e) == 0) {
                return;
            }

            node = subtree;
            if (compare(e, subtree.e) < 0) {
                subtree = subtree.left;
            } else {
                subtree = subtree.right;
            }
        }

        if (compare(e, node.e) < 0) {
            node.left = new Node(e);
            ++size;
        } else {
            node.right = new Node(e);
            ++size;
        }
    }

//    /**
//     * Adds an element {@code e} to this binary search tree (original version, deprecated!)
//     *
//     * @param e E, the element to add
//     */
//    public void add(E e) {
//        if (this.root == null) {
//            this.root = new Node(e);
//            ++size;
//        } else {
//            add(this.root, e);
//        }
//    }

//    /**
//     * Adds an element {@code e} to this binary search tree whose node is {@code node} (original version, deprecated!)
//     *
//     * @param node Node, the root of binary search tree
//     * @param e    E, the element to add
//     */
//    private void add(Node node, E e) {
//        if (compare(e, node.e) == 0) {
//            return;
//        } else if (compare(e, node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            ++size;
//            return;
//        } else if (compare(e, node.e) > 0 && node.right = null) {
//            node.right = new Node(e);
//            ++size;
//            return;
//        }
//
//        if (compare(e, node.e) < 0) {
//            add(node.left, e);
//        } else { // compare(e, node.e) > 0
//            add(node.right, e);
//        }
//    }

    /**
     * Adds an element {@code e} to this binary search tree.
     *
     * @param e E, the element to add
     */
    public void add(E e) {
        this.root = add(this.root, e);
    }

    /**
     * Adds an element {@code e} to this binary search tree whose root is {@code node}.
     *
     * @param node  Node, the root of binary search tree
     * @param e     E, the element to add
     * @return Node, the root of the new binary search tree
     */
    private Node add(Node node, E e) {
        if (node == null) {
            ++size;
            return new Node(e);
        }

        if (compare(e, node.e) < 0) {
            node.left = add(node.left, e);
        } else if (compare(e, node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * Checks whether the binary search tree has element {@code e} (non-recursive version).
     *
     * @param e E, the element to find
     * @return boolean, true if the binary search tree has element {@code e}
     */
    public boolean containsNR(E e) {
        if (this.root == null) {
            return false;
        }

        Node node = this.root;
        while (node != null) {
            if (compare(e, node.e) == 0) {
                return true;
            } else if (compare(e, node.e) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return false;
    }

    /**
     * Checks whether the binary search tree has element {@code e}.
     *
     * @param e E, the element to find
     * @return boolean, true if the binary search tree has element {@code e}
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * Checks whether the binary search tree with {@code node} as root has element {@code e}.
     *
     * @param node  Node, the root of the binary search tree
     * @param e     E, the element to find
     * @return boolean, true if the binary search tree has element {@code e}
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (compare(e, node.e) == 0) {
            return true;
        } else if (compare(e, node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * Preorder traversal of the binary search tree.
     */
    public void preOrder() {
        preOrder(this.root);
    }

    /**
     * Preorder traversal of a binary search tree whose root is <code>node</code>.
     *
     * @param node Node, the root of the binary search tree
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Preorder traversal of a binary search tree (non-recursive version).
     */
    public void preOrderNR() {
        if (this.root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * Inorder traversal of the binary search tree.
     */
    public void inOrder() {
        inOrder(this.root);
    }

    /**
     * Inorder traversal of a binary search tree whose root is <code>node</code>.
     *
     * @param node Node, the root of the binary search tree
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // TODO: Finish the non-recursive version of inorder traversal

    /**
     * Postorder traversal of the binary search tree.
     */
    public void postOrder() {
        postOrder(this.root);
    }

    /**
     * Postorder traversal of a binary search tree whose root is <code>node</code>.
     *
     * @param node Node, the root of the binary search tree
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // TODO: Finish the non-recursive version of postorder traversal

    /**
     * LevelOrder traversal of a binary search tree.
     */
    public void levelOrder() {
        if (this.root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * Find the minimum value in the binary search tree.
     *
     * @return E, the minimum value
     */
    public E minimum() {
        if (this.size == 0) {
            throw new IllegalArgumentException("The binary search tree is empty!!!");
        }

        Node minNode = minimum(this.root);
        return minNode.e;
    }

    /**
     * Find out the minimum value in the binary search tree whose root is <code>node</code>.
     *
     * @param node Node, the root of the binary search tree
     * @return E, the minimum value
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * Find the minimum value in the binary search tree (non-recursive version).
     *
     * @return E, the minimum value
     */
    public E minimumNR() {
        if (this.size == 0) {
            throw new IllegalArgumentException("The binary search tree is empty!!!");
        }

        Node node = this.root;
        while (node.left != null) {
            node = node.left;
        }
        return node.e;
    }

    /**
     * Find the maximum value in the binary search tree.
     *
     * @return E, the minimum value
     */
    public E maximum() {
        if (this.size == 0) {
            throw new IllegalArgumentException("The binary search tree is empty!!!");
        }

        Node maxNode = maximum(this.root);
        return maxNode.e;
    }

    /**
     * Find out the maximum value in the binary search tree whose root is <code>node</code>.
     *
     * @param node Node, the root of the binary search tree
     * @return E, the minimum value
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * Find the maximum value in the binary search tree (non-recursive version).
     *
     * @return E, the minimum value
     */
    public E maximumNR() {
        if (this.size == 0) {
            throw new IllegalArgumentException("The binary search tree is empty!!!");
        }

        Node node = this.root;
        while (node.right != null) {
            node = node.right;
        }
        return node.e;
    }

    /**
     * Remove the minimum node from the binary search tree.
     *
     * @return E, the data of the minimum node
     */
    public E removeMin() {
        E ret = minimum();
        this.root = removeMin(this.root);
        return ret;
    }

    /**
     * Remove the minimum node from a binary search tree whose root is <code>node</code>.
     *
     * @param node Node, the root of the binary search tree
     * @return Node, the modified binary search tree whose minimum node is removed
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            --size;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * Remove the maximum node from the binary search tree.
     *
     * @return E, the data of the maximum node
     */
    public E removeMax() {
        E ret = maximum();
        this.root = removeMax(this.root);
        return ret;
    }

    /**
     * Remove the maximum node from the binary search tree whose root is <code>node</code>.
     *
     * @param node Node, the root of the binary search tree
     * @return Node, the modified binary search tree whose maximum node is removed
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            --size;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * Remove the node from the binary search tree whose data is {@code e}.
     *
     * @param e E, the data of the node we want to remove
     */
    public void remove(E e) {
        this.root = remove(this.root, e);
    }

    /**
     * Remove the node with its data is {@code e} from a binary search tree whose root is {@code node}.
     *
     * @param node Node, the root of the binary search tree
     * @param e    E, the data we want to remove
     * @return Node, a modified binary search tree
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return node;
        }

        if (compare(e, node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (compare(e, node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e.compareTo(node.e) == 0
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                --size;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                --size;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
//            ++size;
            successor.left = node.left;
//            --size;
            node.left = node.right = null;
            return successor;
        }
    }

    /**
     * Compares data from two nodes using the correct comparison method.
     *
     * @param e1 the first data to be compared
     * @param e2 the second data to be compared
     * @return a negative integer, zero, or a positive integer as the
     *         first data is less than, equal to, or greater than the
     *         second
     */
    @SuppressWarnings("unchecked")
    private int compare(Object e1, Object e2) {
        return comparator == null ? ((Comparable<? super E>) e1).compareTo((E) e2)
                : comparator.compare((E) e1, (E) e2);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(this.root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; ++i) {
            res.append("--");
        }
        return res.toString();
    }

    private static final long serialVersionUID = 487439826767090943L;

    // ==================================================================================
    // Overrides methods of {@code Iterable} interface

    @Override
    public Iterator<E> iterator() {
        return new BSTIterator();
    }

    // ==================================================================================

    /**
     * The iterator of the binary search tree
     */
    private class BSTIterator implements Iterator<E> {
        private Stack<Node> stack = new Stack<>();

        public BSTIterator() {
            if (root != null) {
                stack.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // TODO: To Understand `next()` method

        @Override
        public E next() {
            Node cur = stack.peek();
            if (cur.left != null) {
                stack.push(cur.left);
            } else {
                Node tmp = stack.pop();
                while (tmp.right == null) {
                    if (stack.isEmpty()) {
                        return cur.e;
                    }
                    tmp = stack.pop();
                }
            }
            return cur.e;
        }
    }

    /**
     * A node of the binary search tree.
     */
    private class Node {
        /**
         * The data of the node
         */
        private E e;
        /**
         * The left reference
         */
        private Node left;
        /**
         * The right reference
         */
        private Node right;

        /**
         * Constructs a node with its data is {@code e}.
         *
         * @param e E, the element of the node
         */
        public Node(E e) {
            this(e, null, null);
        }

        /**
         * Constructs a node with its data is {@code e}, left reference is {@code left}
         * and right reference is {@code right}.
         *
         * @param e     E, the element of the node
         * @param left  Node, the left reference of the node
         * @param right Node, the right reference of the node
         */
        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
