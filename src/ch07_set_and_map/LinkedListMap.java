package ch07_set_and_map;

/**
 * A custom map class that uses a linked list as data container, where each node
 * of the linked list contains a key-value pair and a reference to the next node.
 *
 * @param <K> the type of the key in the key-value pair
 * @param <V> the type of the value in the key-value pair
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/10/03
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    /**
     * The dummy head node
     */
    private Node dummyHead;
    /**
     * The number of the nodes in the linked list
     */
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * Returns the node according to the key.
     *
     * @param key K, the key we want to find
     * @return Node, the node whose key is {@code key}
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            ++size;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            --size;
            return delNode.value;
        }

        return null;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("[ERROR] The key '" + key + "' doesn't exist!!!");
        } else {
            node.value = value;
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        /**
         * The key of the key-value pair
         */
        private K key;
        /**
         * The value of the key-value pair
         */
        private V value;
        /**
         * The reference to the next node
         */
        private Node next;

        /**
         * Constructs a new node with the specified key, value and reference.
         *
         * @param key   K, the key of the pair
         * @param value V, the value of the pair
         * @param next  Node, the reference to the next node
         */
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * Constructs a new node with the specified key and value.
         *
         * @param key   K, the key of the pair
         * @param value V, the value of the pair
         */
        public Node(K key, V value) {
            this(key, value, null);
        }

        /**
         * Constructs a new node.
         */
        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }
}
