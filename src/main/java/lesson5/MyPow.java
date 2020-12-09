package lesson5;

public class MyPow {

    /**
     *
     * Возведению числа в степень с помощью рекурсии
     *
     * @param digit - целое число != 0
     * @param pow - степень числа
     * @return возведение digit в степень pow
     */

    public static double recPow(double digit, int pow) {
        if (digit == 0) {
            throw new IllegalArgumentException("Digit must not equal (0.0)");
        }
        if (pow == 0) {
            return 1.0;
        }

        if (pow > 0) {
            return recPow(digit, pow - 1) * digit;
        } else {
            return 1 / (recPow(digit, (pow * -1) - 1) * digit);
        }


    }
}
