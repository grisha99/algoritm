package acmp;

import java.util.Scanner;

public class CubicEquation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int min = -100;
        int max = 100;

        long a, b, c, d;

        String str = in.nextLine();

        a = Long.parseLong(str.split("\\s")[0]);
        b = Long.parseLong(str.split("\\s")[1]);
        c = Long.parseLong(str.split("\\s")[2]);
        d = Long.parseLong(str.split("\\s")[3]);

        StringBuilder answer = new StringBuilder("");
        for (int i = min; i <= max; i++) {
            if ((a * (long)Math.pow(i, 3) + b * (long)Math.pow(i, 2) + c*i + d) == 0) {
                answer.append(i).append(" ");
            }
        }
        System.out.println(answer.toString().trim());

    }
}
