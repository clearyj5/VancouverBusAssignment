import java.security.Key;
import java.util.*;
import java.io.*;

public class TST<Value> {
    private int size; // size
    private Node<Value> root; // root of TST

    private static class Node<Value> {
        private char c; // Character
        private Node<Value> left, mid, right; // Subtries
        private Value val;
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
    public Value get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Calling get() with a null argument");
        } else if (key.length() == 0) {
            throw new IllegalArgumentException("Key must be of lentgh >=1");
        }
        Node<Value> x = get(root, key, 0);
        return x == null ? null : x.val;
    }

    // Return subtrie corresponding to given key
    public Node<Value> get(Node<Value> x, String key, int d) {

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
    public void put(Value val, String key) {
        if (val == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }

        if (!contains(key)) {
            size++;
            root = put(root, key, val, 0);
        }
    }

    private Node<Value> put(Node<Value> x, String key, Value val, int d) {
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
    public List<Value> valuesWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Calls valuesWithPrefix() with null argument");
        }

        List<Value> values = new ArrayList<>();

        Node<Value> x = get(root, prefix, 0);

        if (x == null) {
            return values;
        } else if (x.val != null) {
            values.add(x.val);
        }

        collect(x.mid, new StringBuilder(prefix), values);
        return values;
    }

    // All values in subtrie rooted at x with given prefix
    public void collect(Node<Value> x, StringBuilder prefix, List<Value> values) {
        if (x == null)
            return;
        collect(x.left, prefix, values);
        if (x.val != null)
            values.add(x.val);
        collect(x.mid, prefix.append(x.c), values);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, values);
    }

 
    public static void main(String[] args) {
        ReadFile keyValueFile = new ReadFile();
        File stopInfo = new File("stops.txt");

        String[] keyArray = keyValueFile.keyArray(stopInfo);
        String[] valueArray = keyValueFile.valueArray(stopInfo);

        for (int i = 0; i < 8758; i++) {
            String currentKey;
            currentKey = keyArray[i];
            
            String currentValue;
            currentValue = valueArray[i];

            put(currentValue, currentKey);
        
        }
    }
}
