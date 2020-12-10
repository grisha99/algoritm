package lesson6;

public class Lesson6 {

    public static void main(String[] args) {


        for (int i = 0; i < 20; i++) {
            System.out.println("Balanced: " + TreeMapTest.runBalanceTest(6));
        }

//        на какой попытке случится чудо?
//        Попытки:
//            1: сбалансированность с 3446300 раза
//            2: сбалансированность с 6342851 раза
//            3: сбалансированность с 8865811 раза
//            4: не дождался...
//        int i = 0;
//        while (!TreeMapTest.runBalanceTest(6)) {
//            i++;
//        }
//        System.out.println("Баланс на " + i + " попытке");

    }
}
