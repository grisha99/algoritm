package acmp;

import java.util.Arrays;
import java.util.Scanner;

public class VasiaEnglish {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] day = new int[a];
        int evenCount = 0;
        int oddCount = 0;
        StringBuilder even = new StringBuilder();
        in.nextLine();
        String str = in.nextLine();

        day = Arrays.stream(str.split("\\s")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < day.length; i++) {
            if (day[i] % 2 == 0) {
                evenCount++;
                even.append(day[i]).append(" ");
            } else {
                System.out.print(day[i] + " ");
                oddCount++;
            }
        }
        System.out.println();
        System.out.println(even);
        if (evenCount >= oddCount) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
