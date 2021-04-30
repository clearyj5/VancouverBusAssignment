import java.security.Key;
import java.util.*;


public class TST {
    private int size; // size
    private Node<String> root; // root of TST

    private static class Node<String> {
        private char c; // Character
        private Node<String> left, mid, right; // Subtries
        private String val;
    }

    /**
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
    }

    /**
     * @return true if key exists
     */
    public boolean contains(String key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     * 
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol
     *         table and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null} or empty
     */
    public String get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Calling get() with a null argument");
        } else if (key.length() == 0) {
            throw new IllegalArgumentException("Key must be of lentgh >=1");
        }
        Node<String> x = get(root, key, 0);
        return x == null ? null : x.val;
    }

    // Return subtrie corresponding to given key
    public Node<String> get(Node<String> x, String key, int d) {

        if (x == null)
            return null;

        if (key.length() == 0)
            throw new IllegalStateException("Key must be of lentgh >=1");

        char c = key.charAt(d);
        if (c < x.c)
            return get(x.left, key, d);
        else if (c > x.c)
            return get(x.right, key, d);
        else if (d < key.length() - 1)
            return get(x.mid, key, d + 1);

        else
            return x;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table. If the value is
     * {@code null}, this effectively deletes the key from the symbol table.
     * 
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(String val, String key) {
        if (val == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }

        if (!contains(key)) {
            size++;
            root = put(root, key, val, 0);
        }
    }

    private Node<String> put(Node<String> x, String key, String val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node<>();
            x.c = c;
        }

        if (c < x.c)
            x.left = put(x.left, key, val, d);
        else if (c > x.c)
            x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1)
            x.mid = put(x.mid, key, val, d + 1);
        else
            x.val = val;
        return x;
    }

    /**
     * Returns all of the keys in the set that start with {@code prefix}.
     * 
     * @param prefix the prefix
     * @return all of the values in the set that start with {@code prefix}, as a
     *         list
     * @throws IllegalArgumentException if {@code prefix} is {@code null}
     */
    public List<String> valuesWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Calls valuesWithPrefix() with null argument");
        }

        List<String> values = new ArrayList<>();

        Node<String> x = get(root, prefix, 0);

        if (x == null) {
            return values;
        } else if (x.val != null) {
            values.add(x.val);
        }

        collect(x.mid, new StringBuilder(prefix), values);
        return values;
    }

    // All values in subtrie rooted at x with given prefix
    public void collect(Node<String> x, StringBuilder prefix, List<String> values) {
        if (x == null)
            return;
        collect(x.left, prefix, values);
        if (x.val != null)
            values.add(x.val);
        collect(x.mid, prefix.append(x.c), values);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, values);
    }
}