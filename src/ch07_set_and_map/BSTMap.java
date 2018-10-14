package ch07_set_and_map;

/**
 * A custom map class that uses a binary search tree as data container,
 * where each node of the binary search tree contains a key-value pair,
 * a left reference and right reference.
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 *
 * @author  StrongXGP
 * @date    2018/10/14
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    /**
     * The root of the binary search tree map.
     */
    private Node root;
    /**
     * The number of nodes in the binary search tree map.
     */
    private int size;

    /**
     * Constructs an empty binary search tree map.
     */
    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        this.root = add(this.root, key, value);
    }

    /**
     * Adds a key-value pair into the binary search tree map
     * whose root is {@code root}.
     *
     * @param root  Node, the root of the binary search tree map
     * @param key   K, the key of the pair
     * @param value V, the value of the pair
     * @return Node, the modified binary search tree map
     */
    public Node add(Node root, K key, V value) {
        if (root == null) {
            ++this.size;
            return new Node(key, value);
        }

        if (key.compareTo(root.key) < 0) {
            root.left = add(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = add(root.right, key, value);
        } else {
            root.value = value;
        }

        return root;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(this.root, key);
        if (node != null) {
            this.root = remove(this.root, key);
            return node.value;
        }
        return null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(this.root, key);
        if (node == null) {
            throw new IllegalArgumentException("[Error] The key '" + key + "' doesn't exist!!!");
        }
        node.value = newValue;
    }

    @Override
    public V get(K key) {
        Node node = getNode(this.root, key);
        return node == null ? null : node.value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(this.root, key) != null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    // ==================================================================================== //
    // Some auxiliary functions

    /**
     * Finds out the node whose key is {@code key} in the binary search tree map,
     * where the root of the binary search tree map is {@code root}.
     *
     * @param root Node, the root of the binary search tree map
     * @param key  K, the key of the pair in the node
     * @return Node, the node whose key is {@code key}
     */
    private Node getNode(Node root, K key) {
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) == 0) {
            return root;
        } else if (key.compareTo(root.key) < 0) {
            return getNode(root.left, key);
        } else { // key.compareTo(root.key) > 0
            return getNode(root.right, key);
        }
    }

    /**
     * Finds out the minimum node in the binary search tree map.
     *
     * @param root Node, the root of the binary search tree
     * @return Node, the minimum node in the binary search tree map
     */
    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    /**
     * Removes the minimum node from the binary search tree map
     * whose root is {@code root}.
     *
     * @param root Node, the root of the binary search tree
     * @return Node, the modified binary search tree map whose minimum node is removed
     */
    private Node removeMin(Node root) {
        if (root.left == null) {
            Node rightNode = root.right;
            root.right = null;
            --size;
            return rightNode;
        }

        root.left = removeMin(root.left);
        return root;
    }

    /**
     * Removes the node whose key is {@code key} from the binary search tree map
     * whose root is {@code root}.
     *
     * @param root Node, the root of the binary search tree map
     * @param key K, the node to remove with its key is {@code key}
     * @return Node, the modified binary search tree map
     */
    private Node remove(Node root, K key) {
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = remove(root.left, key);
            return root;
        } else if (key.compareTo(root.key) > 0) {
            root.right = remove(root.right, key);
            return root;
        } else { // key.compareTo(root.key) == 0
            if (root.left == null) {
                Node rightNode = root.right;
                root.right = null;
                --this.size;
                return rightNode;
            }

            if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;
                --this.size;
                return leftNode;
            }

            Node successor = minimum(root.right);
            successor.right = removeMin(root.right);
            // ++this.size;
            successor.left = root.left;
            // --this.size;
            root.left = root.right = null;
            return successor;
        }
    }

    // ==================================================================================== //

    /**
     * A node of the binary search tree map.
     */
    private class Node {
        /**
         * The key of the pair.
         */
        private K key;
        /**
         * The value of the pair.
         */
        private V value;
        /**
         * The left reference.
         */
        private Node left;
        /**
         * The right reference.
         */
        private Node right;

        /**
         * Constructs a node with specified key-value pair.
         *
         * @param key   K, the key of the pair
         * @param value V, the value of the pair
         */
        public Node(K key, V value) {
            this(key, value, null, null);
        }

        /**
         * Constructs a node with specified key-value pair, left reference and right reference.
         *
         * @param key   K, the key of the pair
         * @param value V, the value of the pair
         * @param left  Node, the left reference
         * @param right Node, the right reference
         */
        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }
}
