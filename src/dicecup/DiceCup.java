package dicecup;

import java.util.Scanner;

// https://open.kattis.com/problems/dicecup

public class DiceCup {

    public static void main(String[] args) {
        String in = "12 20\n";

        Scanner scan = new Scanner(in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        possibleValues(x, y);
    }

    public static void possibleValues(int x, int y) {

        int minimum1 = x + 1;
        int minimum2 = y + 1;

        if (x == y) {
            System.out.println(x + 1);
        } else if (x > y) {
            while (y < minimum1) {
                System.out.println(y + 1);
                y++;
            }
        } else {
            while (x < minimum2) {
                System.out.println(x + 1);
                x++;
            }
        }
    }
}
