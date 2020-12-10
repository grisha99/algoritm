package lesson6;

public class TreeMapTest {

    public static boolean runBalanceTest(int treeLevel) {

        MyTreeMap<Integer, Integer> mtm = new MyTreeMap<>();
        int key;
        for (int i = 1; i < Math.pow(2, treeLevel + 1); i++) {
            key = (int)(Math.random()*200) - 100;
            mtm.put(key, i * 10);
        }

        return mtm.isBalanced();

    }
}
