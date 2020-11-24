package acmp;

import java.util.Arrays;
import java.util.Scanner;

public class Mul {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] val = Arrays.stream(in.nextLine().split("\\s")).mapToInt(Integer::new).toArray();

        if (val[0] * val[1] == val[2]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
