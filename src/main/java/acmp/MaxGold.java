package acmp;

import java.math.BigInteger;
import java.util.Scanner;

public class MaxGold {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("\\s");
        BigInteger max = new BigInteger(str[0]);

        for (int i = 1; i < str.length; i++) {
            if (max.compareTo(new BigInteger(str[i])) == -1) {
                max = new BigInteger(str[i]);
            }
        }

        System.out.println(max);
    }
}
