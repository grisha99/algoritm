package lesson5;

import lesson5.backpack.Backpack;
import lesson5.backpack.PackItem;

import java.util.ArrayList;
import java.util.List;

public class Lesson5 {

    public static void main(String[] args) {

        System.out.println(MyPow.recPow(5, 3));

        List<PackItem> items = new ArrayList<>();

        items.add(new PackItem(5, 10));
        items.add(new PackItem(7, 3));
        items.add(new PackItem(3, 5));
        items.add(new PackItem(8, 6));
        items.add(new PackItem(2, 8));
        items.add(new PackItem(4, 7));
        items.add(new PackItem(9, 9));
        items.add(new PackItem(5, 4));
        items.add(new PackItem(1, 2));

        Backpack backpack = new Backpack(15);
        backpack.pack(items);
        System.out.println(backpack);

    }
}
