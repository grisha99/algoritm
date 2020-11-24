package acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a = in.nextInt();
        int sum = 0;
        if (a > 0) {
            for (int i = 1; i <= a; i++) {
                sum += i;
            }
        } else {
            for (int i = 1; i >= a; i--) {
                sum += i;
            }
        }
        out.println(sum);
        out.flush();
    }
}
