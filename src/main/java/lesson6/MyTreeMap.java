package lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;
        private int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    public boolean isBalanced() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Tree is empty");
        }

        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {

        if (node == null) {
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right) ;

    }

    public boolean isEmpty() {
        return root == null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key shouldn't be null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            return;
        }

        root = put(root, key, value);
    }

    private Node put(Node node , Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }

        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left) , height(node.right)) + 1;
        return node;
    }

    public Key minKey(Key key) {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty.");
        }

        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);

    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Tree is empty");
        }

        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left) , height(node.right)) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);

        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left) , height(node.right)) + 1;
        return node;


    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.key + " " + toString(node.right);
    }


}