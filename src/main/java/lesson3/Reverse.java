package lesson3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Reverse<T> {

    private T[] list;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    public static Reverse<Character> fromString(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }

        Reverse<Character> result = new Reverse<>(str.length());

        for (int i = 0; i < str.length(); i++) {
            result.push(str.charAt(i));
        }

        return result;
    }
    public Reverse(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
        this.capacity = capacity;
        ensureCapacity();
    }

    public Reverse() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item) {
        ensureCapacity();
        list[size++] = item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public T pop() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void ensureCapacity() {
        if (size / (float)capacity >= LOAD_FACTOR) {
            T[] oldList = Arrays.copyOf(list, size);
            capacity = (capacity * 3) / 2 + 1;
            list = (T[]) new Object[capacity];
            System.arraycopy(oldList, 0, list, 0, size);
        }
    }
}
