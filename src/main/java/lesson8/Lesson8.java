package lesson8;

import java.util.Random;

public class Lesson8 {

    public static void main(String[] args) {

        ChainHashMap<Integer, String> chm = new ChainHashMap<>();

        Random random = new Random();

        for (int i = 0; i < 20 ; i++) {
            chm.put(random.nextInt(100),"item-"+i );
        }

        System.out.println(chm);

//        System.out.println("remove - " + chm.remove(51));

        System.out.println(chm);

    }
}
