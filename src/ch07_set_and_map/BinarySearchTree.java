package ch07_set_and_map;

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

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this(e, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
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
//            size++;
//        } else {
//            add(this.root, e);
//        }
//    }

//    /**
//     * Add element <code>e</code> to the binary search tree whose node is <code>node</code> (original version, deprecated!)
//     *
//     * @param node  Node, the root of binary search tree
//     * @param e     E, the element to add
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
        this.root = add(this.root, e);
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

//    /**
//     * Check whether the binary search tree has element <code>e</code> (non-recursive version).
//     *
//     * @param e E, the element to find
//     * @return boolean, true if the binary search tree has element <code>e</code>
//     */
//    public boolean contains(E e) {
//        if (this.root == null) {
//            return false;
//        }
//
//        Node node = this.root;
//        while (node != null) {
//            if (e.equals(node.e)) {
//                return true;
//            } else if (e.compareTo(node.e) < 0) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//
//        return false;
//    }

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

    private Node remove(Node node, E e) {
        if (node == null) {
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(this.root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
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
}
