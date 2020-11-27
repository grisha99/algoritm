package lesson2;

import java.util.Comparator;

public class Tasks {

    int arrayLength;
    int[] arrSource;
    MyArrayList<Integer> mal = new MyArrayList();

    public Tasks(int arrayLength) {
        this.arrayLength = arrayLength;
        arrSource = new int[arrayLength];
        for (int i = 0; i < arrSource.length; i++) {
            arrSource[i] = (int) (Math.random() * arrayLength);
        }
    }

    public void runTest(){

        fillList();

        System.out.println(mal.toString());
        long beginTime = System.currentTimeMillis();
        mal.selectionSort();
        long endTime = System.currentTimeMillis();
        System.out.println("SelectionSort time: " + (endTime - beginTime));

        fillList();

        beginTime = System.currentTimeMillis();
        mal.insertionSort(Comparator.naturalOrder());
        endTime = System.currentTimeMillis();
        System.out.println("InsertionSort time: " + (endTime - beginTime));

        fillList();

        beginTime = System.currentTimeMillis();
        mal.bubbleSort();
        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort time: " + (endTime - beginTime));

    }

    private void fillList() {
        mal.clear();
        for (int i = 0; i < arrSource.length; i++) {
            mal.add(arrSource[i]);
        }
    }
}
