package dicecup;

import java.util.Scanner;

public class DiceCup {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();

        possibleValues(12, 20);
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
