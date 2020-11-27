package lesson2;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T extends Comparable<T>> {

    private static final int INIT_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    private T[] list;
    private int size;
    private int capacity;

    public MyArrayList() {
        list = (T[]) new Comparable[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
        size = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Comparable[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public MyArrayList(T[] list) {
        this.list = list;
        size = list.length;
        capacity = size;
        ensureCapacity();
    }

    public T get(int index) {
        checkIndex(index);
        return list[index];
    }

    public void add(T item) {
        ensureCapacity();
        list[size++] = item;
    }

    public void add(int index, T item) {
        checkIndexAdd(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;

    }

    public void set(int index, T item) {
        checkIndex(index);
        list[index] = item;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        list[size--] = null;
    }

    public boolean remove(T item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacity() {
        if (size / (float)capacity >= LOAD_FACTOR) {
            T[] oldList = Arrays.copyOf(list, size);
            capacity = (capacity * 3) / 2 + 1;
            list = (T[]) new Comparable[capacity];
            System.arraycopy(oldList, 0, list, 0, size);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds, size: " + size + "; index: " + index);
        }
    }
    private void checkIndexAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds, size: " + size + "; index: " + index);
        }
    }

    public int size() {
        return size;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    public void clear() {
        Arrays.fill(list, null);
        size = 0;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void selectionSort(Comparator<T> comparator) {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (comparator.compare(list[j], list[iMin]) < 0) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void insertionSort(Comparator<T> comparator) {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && comparator.compare(key, list[j - 1]) < 0) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }
    public void bubbleSort() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                System.out.println("break " + i);
                break;
            }
        }
    }

    public void bubbleSort(Comparator<T> comparator) {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    swap(j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                System.out.println("break " + i);
                break;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
