package acmp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HorseMove {

    static int[][] shift = {
            {-1,  2},
            { 1,  2},
            { 2,  1},
            { 2, -1},
            { 1, -2},
            {-1, -2},
            {-2, -1},
            {-2,  1},
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[A-H][1-8]-[A-H][1-8]");
        String a = in.nextLine();

        if (Pattern.matches(pattern.pattern(), a)) {
            String start = a.split("-")[0];
            String end = a.split("-")[1];
            if (isValidTurn(start, end)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("ERROR");
        }
    }

    private static boolean isValidTurn(String startPos, String endPos) {
        int[] beginCoords = new int[2];
        int[] endCoords = new int[2];

        beginCoords[0] = ((byte)startPos.charAt(0)) - 65;
        beginCoords[1] = Character.getNumericValue(startPos.charAt(1)) - 1;
        endCoords[0] = ((byte)endPos.charAt(0)) - 65;
        endCoords[1] = Character.getNumericValue(endPos.charAt(1)) - 1;

        for (int i = 0; i < 8; i++) {
            if ((beginCoords[0] + shift[i][0]) == endCoords[0]) {
                if ((beginCoords[1] + shift[i][1]) == endCoords[1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
