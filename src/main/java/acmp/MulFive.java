package acmp;

import java.util.Scanner;

public class MulFive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        long a2 = 0L;
        String str = Integer.toString(a);
        if (a != 5) {
            a2 = Long.parseLong(str.substring(0, str.length() - 1));
            a2 = Long.parseLong(a2 * (a2 + 1) + "25");
        } else {
            a2 = a*a;
        }
        System.out.println(a2);
    }
}
