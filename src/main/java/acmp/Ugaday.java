package acmp;

import java.util.Scanner;

public class Ugaday {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println((a * 100) + 90 + (9 - a));
    }
}
