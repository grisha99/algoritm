package lesson3;

public class Lesson3 {

    public static void main(String[] args) {

        Reverse<Character> rv = Reverse.fromString("Algorithm reverse");
        for (int i = rv.size(); i > 0; i--) {
            System.out.print(rv.pop());
        }

    }
}
