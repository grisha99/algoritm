package acmp;

import java.util.Arrays;
import java.util.Scanner;

public class ArrSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arrLen = in.nextInt();
        in.nextLine();
        int[] arr = Arrays.stream(in.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int minIndx = 0;
        int maxIndx = 0;
        int sum = 0;
        int mul = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
            if (arr[i] > arr[maxIndx]) {
                maxIndx = i;
            }
            if (arr[i] < arr[minIndx]) {
                minIndx = i;
            }
        }
        int begin;
        int end;
        if (minIndx > maxIndx) {
            begin = maxIndx;
            end = minIndx;
        } else {
            begin = minIndx;
            end = maxIndx;
        }

        for (int i = begin + 1; i < end; i++) {
            mul *= arr[i];
        }

        System.out.println(sum + " " + mul);

    }
}
