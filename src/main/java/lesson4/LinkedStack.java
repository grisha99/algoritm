package lesson4;

import java.util.Stack;

public class LinkedStack<T> extends MyLinkedList<T> {

    public LinkedStack() {
        super();
    }

    public void push(T item) {
        insertLast(item);
    }

    public T pop() {
        return removeLast();
    }

    public T peek() {
        return getLast();
    }

    public int search(T item) {
        return indexOf(item);
    }
}
