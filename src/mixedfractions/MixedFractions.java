package mixedfractions;

import java.util.Scanner;

public class MixedFractions {
    public static void main(String[] args) {
        String in = """
            27 12
            2460000 98400
            3 4000
            0 0
            """;
        Scanner scan = new Scanner(in);
        while (scan.hasNextLine()) {
            convertToMixedFraction(scan.nextInt(), scan.nextInt());
        }
    }

    static void convertToMixedFraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.exit(0);
        }
        System.out.printf("%d %d / %d \n", numerator / denominator, numerator % denominator, denominator);
    }
}
