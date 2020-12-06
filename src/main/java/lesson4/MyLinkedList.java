package lesson4;

import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        return new ListIter(index);
    }

    private class Node {
        private T value;
        private Node next;
        private Node prev;

        public Node(T item) {
            this.value = item;
        }

        public Node(T item, Node next) {
            this.value = item;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        newNode.setNext(null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
        }
        last = newNode;
        size++;
    }

    public T removeFirst() {
        T oldFirst = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return oldFirst;
    }

    public T removeLast() {
        T oldLast = getLast();
        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrev();
        size--;
        return oldLast;

    }

    public final int indexOf(T item) {
        int index = 0;
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.getValue().equals(item)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.getValue();
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.getValue();
    }

    public Node getNode(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            return first;
        }
        if (index == size) {
            return last;
        }

        int i = 0;
        Node res = first;
        while (i != size - 1) {
            res = res.getNext();
            i++;
        }
        return res;
    }

    public boolean isContain(T item) {
        return indexOf(item) != -1;
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            insertFirst(item);
        }

        if (index == size) {
            insertLast(item);
        }

        Node newNode = new Node(item);
        int i = 0;
        Node currentNode = first;
        while (i < index - 1) {
            currentNode = currentNode.getNext();
            i++;
        }

        newNode.setNext(currentNode);
        newNode.setPrev(currentNode.getPrev());
        currentNode.setPrev(newNode);
        currentNode.getPrev().setNext(newNode);
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node removeNode = first;
        int i = 0;
        while (i < index) {
            removeNode = removeNode.getNext();
            i++;
        }

        removeNode.getNext().setPrev(removeNode.getPrev());
        removeNode.getPrev().setNext(removeNode.getNext());
        size--;
        return removeNode.getValue();
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }
        if (last.getValue().equals(item)) {
            removeLast();
            return true;
        }

        Node removeNode = first;
        while (!removeNode.getValue().equals(item) && removeNode != null) {
            removeNode = removeNode.getNext();
        }
        if (removeNode == null) {
            return false;
        }

        removeNode.getNext().setPrev(removeNode.getPrev());
        removeNode.getPrev().setNext(removeNode.getNext());
        size--;
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue() + ", ");
            current = current.getNext();
        }
        if (!isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    private class ListIter implements ListIterator<T> {

        Node nextNode;
        Node inspectedNode;
        int index;

        public ListIter(int index) {
            if (index == size) {
                nextNode = null;
            } else {
                nextNode = getNode(index);
            }
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            inspectedNode = nextNode;
            nextNode = nextNode.getNext();
            index++;
            return inspectedNode.getValue();
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextNode == null) {
                inspectedNode = last;
                nextNode = last.getPrev();

            } else {
                inspectedNode = nextNode;
                nextNode = nextNode.getPrev();

            }
            index--;
            return inspectedNode.getValue();
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            if (inspectedNode == null) {
                throw new IllegalStateException();
            }

            if (inspectedNode == first) {
                removeFirst();
                inspectedNode = first;
                return;
            }
            if (inspectedNode == last) {
                removeLast();
                inspectedNode = last;
                index--;
                return;
            }

            if (nextNode == inspectedNode.getNext()) {                  // движение вправо
                nextNode.setPrev(inspectedNode.getPrev());
                inspectedNode.getPrev().setNext(nextNode);
                index--;
                size--;
            } else {                                                    // движение влево
                nextNode.setNext(inspectedNode.getNext());
                inspectedNode.getNext().setPrev(nextNode);
                size--;
            }
        }

        @Override
        public void set(T t) {
            if (inspectedNode == null) {
                throw new IllegalStateException();
            }
            inspectedNode.value = t;
        }

        @Override
        public void add(T t) {
            if (inspectedNode == null) {
                insertFirst(t);
                nextNode = first;
                return;
            }
            if (nextNode == null) {
                insertLast(t);
                inspectedNode = last;
                index++;
                return;
            }
            Node newNode = new Node(t);
            if (nextNode == inspectedNode.getNext()) {          // движение вправо
                inspectedNode.setNext(newNode);
                newNode.setPrev(inspectedNode);
                newNode.setNext(nextNode);
                nextNode.setPrev(newNode);
                index++;
            } else {                                            // движение влево
                nextNode.setNext(newNode);
                newNode.setPrev(nextNode);
                newNode.setNext(inspectedNode);
                inspectedNode.setPrev(newNode);
            }
            inspectedNode = newNode;
            size++;
        }
    }

    private class Iter implements Iterator<T> {

        Node currentNode = new Node(null, first);

        @Override
        public boolean hasNext() {
            return currentNode.getNext() != null;
        }

        @Override
        public T next() {
            currentNode = currentNode.getNext();
            return currentNode.getValue();
        }

        @Override
        public void remove() {
            if (currentNode == null) {
                throw new IllegalArgumentException();
            }

            if (currentNode == first) {
                first = currentNode.getNext();
                first.setPrev(null);
                size--;
                return;
            }
            if (currentNode == last) {
                last = last.getPrev();
                last.setNext(null);
                size--;
                return;
            }

            currentNode.getPrev().setNext(currentNode.getNext());
            currentNode.getNext().setPrev(currentNode.getPrev());
            size--;
        }
    }

}
