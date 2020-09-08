package crne;

import java.util.Scanner;

// https://open.kattis.com/problems/crne

public class Crne {

    public static void main(String[] args) {

        String in = "3";
        Scanner scan = new Scanner(in);

        long number = scan.nextLong();
        long result = maximizeShatter(number);

        System.out.println(result);
    }

    static long maximizeShatter(long in) {
        long cutHorizontal = in / 2;
        long cutVertical   = in - cutHorizontal;
        return (cutHorizontal + 1) * (cutVertical + 1);
    }
}
