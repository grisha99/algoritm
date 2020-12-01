package lesson3;

import java.util.Arrays;

public class MyDeque<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private T[] elements;
    private int capacity;
    private int size;

    private int right;
    private int left;

    public MyDeque() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public void pushRight(T element) {
        if (element == null) {
            throw new NullPointerException();
        }

        right = nextDecIndex(right);
        elements[right] = element;
        size++;
        if (right == left) {
            ensureCapacity();
        }
    }

    public void pushLeft(T element) {
        if (element == null) {
            throw new NullPointerException();
        }

        elements[left] = element;
        left = nextIncIndex(left);
        size++;
        if (left == right) {
            ensureCapacity();
        }
    }

    public void push(T element) {
        pushLeft(element);
    }

    public T peekLeft() {
        return elements[nextDecIndex(left)];
    }

    public T peekRight() {
        return elements[right];
    }

    public T peek() {
        return peekLeft();
    }

    public T popleft() {
        T result = peekLeft();
        if (result != null) {
            left = nextDecIndex(left);
            elements[left] = null;
            size--;
        }

        return result;
    }

    public T popRight() {
        T result = peekRight();
        if (result != null) {
            elements[right] = null;
            right = nextIncIndex(right);
            size--;
        }

        return result;
    }

    public T pop() {
        return popleft();
    }

    public int size() {

        return size;
    }

    private void ensureCapacity() {
        int nextLeft = elements.length;
        int rightOffset = elements.length - right;
        capacity = (capacity * 3) / 2 + 1;

        T[] newElements = (T[]) new Object[capacity];

        System.arraycopy(elements, right, newElements, 0, rightOffset);
        System.arraycopy(elements, 0, newElements, rightOffset, right);
        elements = newElements;
        right = 0;
        left = nextLeft;

        System.out.println(Arrays.toString(elements));
    }

    private int nextIncIndex(int index) {
        if (index + 1 == elements.length) {
            return 0;
        } else {
            return index + 1;
        }
    }

    private int nextDecIndex(int index) {
        if (index - 1 < 0) {
            return elements.length - 1;
        } else {
            return index - 1;
        }

    }

    @Override
    public String toString() {
        return "MyDeque{" +
                "elements=" + Arrays.toString(elements) +
                "}; left: " + left + "; right: " + right + "; size: " + size();
    }
}

