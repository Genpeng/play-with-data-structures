package ch6_binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * The self-defined binary search tree class.
 *
 * @param <E> the type of element in the node
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/07/12
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        /**
         * The data of the Node
         */
        public E e;
        /**
         * The left subtree
         */
        public Node left;
        /**
         * The right subtree
         */
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * The root of binary search tree.
     */
    private Node root;
    /**
     * The number of nodes in the binary search tree.
     */
    private int size;

    /**
     * Constructor.
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Return the number of nodes in the binary search tree.
     *
     * @return int, the number of nodes
     */
    public int size() {
        return this.size;
    }

    /**
     * Check whether the binary search tree is empty.
     *
     * @return boolean, true if the binary search tree is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

//    /**
//     * Add element <code>e</code> to this binary search tree (non-recursive version)
//     *
//     * @param e E, the element to add
//     */
//    public void add(E e) {
//        if (this.root == null) {
//            this.root = new Node(e);
//            size++;
//            return;
//        }
//
//        Node node = null;
//        Node subtree = this.root;
//        while (subtree != null) {
//            if (e.equals(subtree.e)) {
//                return;
//            }
//
//            node = subtree;
//
//            if (e.compareTo(subtree.e) < 0) {
//                subtree = subtree.left;
//            } else {
//                subtree = subtree.right;
//            }
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            node.left = new Node(e);
//            size++;
//        } else {
//            node.right = new Node(e);
//            size++;
//        }
//    }

//    /**
//     * Add element <code>e</code> to this binary search tree (original version, deprecated!)
//     *
//     * @param e E, the element to add
//     */
//    public void add(E e) {
//        if (this.root == null) {
//            this.root = new Node(e);
//        } else {
//            add(this.root, e);
//        }
//    }

//    /**
//     * Add element <code>e</code> to the binary search tree whose node is <code>node</code> (original version, deprecated!)
//     *
//     * @param node  Node, the root of binary search tree
//     * @param e     E, the element to add
//     * @return Node, the root of the new binary search tree
//     */
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right = null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else { // e.compareTo(node.e) > 0
//            add(node.right, e);
//        }
//    }

    /**
     * Add element <code>e</code> to this binary search tree.
     *
     * @param e E, the element to add
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * Add element <code>e</code> to the binary search tree whose node is <code>node</code>.
     *
     * @param node  Node, the root of binary search tree
     * @param e     E, the element to add
     * @return Node, the root of the new binary search tree
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * Check whether the binary search tree has element <code>e</code>.
     *
     * @param e E, the element to find
     * @return boolean, true if the binary search tree has element <code>e</code>
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * Check whether the binary search tree with <node>node</node> as root has element <code>e</code>.
     *
     * @param node  Node, the root of the binary search tree
     * @param e     E, the element to find
     * @return boolean, true if the binary search tree has element <code>e</code>
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void preOrderNR() {
        if (root == null) {
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

    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

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
        if (size == 0) {
            throw new IllegalArgumentException("Binary search tree is empty!!!");
        }

        Node minNode = minimum(root);
        return minNode.e;
    }

    /**
     * Find out the minimum value in the binary search tree which root is <code>node</code>.
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

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("Binary search tree is empty!!!");
        }

        Node maxNode = maximum(root);
        return maxNode.e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
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
            res.append("  ");
        }
        return res.toString();
    }
}
