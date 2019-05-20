package mixedfractions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            convertToMixedFraction(scan.nextInt(), scan.nextInt());
        }
    }

    private static void convertToMixedFraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.exit(0);
        }
        System.out.printf("%d %d / %d \n", numerator / denominator, numerator % denominator, denominator);
    }
}
