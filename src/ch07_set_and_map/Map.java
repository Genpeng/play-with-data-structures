package ch07_set_and_map;

/**
 * A general interface which defines functions a map must to implement.
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/10/03
 */
public interface Map<K, V> {
    /**
     * Adds a key-value pair to the map.
     *
     * @param key   K, the key of the pair
     * @param value V, the value of the pair
     */
    void add(K key, V value);

    /**
     * Removes a key-value pair from the map.
     *
     * @param key K, the key of the pair to remove
     * @return V, the value of the pair to remove
     */
    V remove(K key);

    /**
     * Updates a existed key-value pair in the map.
     *
     * @param key      K, the key of the pair we want to update
     * @param newValue V, the value of the pair we want to update
     */
    void set(K key, V newValue);

    /**
     * Returns the value of the corresponding key.
     *
     * @param key K, the key we want to check
     * @return V, the value of the key we want to check
     */
    V get(K key);

    /**
     * Checks whether the map contains the key.
     *
     * @param key K, the key we want to check
     * @return boolean, true if the map contains the key
     */
    boolean contains(K key);

    /**
     * Returns the number of the key-value pairs in the map.
     *
     * @return the number of the key-value pairs in the map
     */
    int getSize();

    /**
     * Checks whether the map contains any key-value pairs.
     *
     * @return boolean, true if the map is empty, i.e., the number of
     *         key-value pairs in the map is zero
     */
    boolean isEmpty();
}
