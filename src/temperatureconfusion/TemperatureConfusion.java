package temperatureconfusion;

import java.util.Scanner;

public class TemperatureConfusion {

    public static void main(String[] args) {
        String input = "-6/4\n";
        Scanner scan = new Scanner(input);
        String line = scan.nextLine();

        String[] strArr = line.split("/");
        int[] faren = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String numString = strArr[i];
            faren[i] = Integer.parseInt(numString);
        }
        // now subtract 32      (-6/4 - 32/1)
        int[] highTerm32 = getCommonDenom(faren[1]);

        // now subtract the numerators
        int[] addedFractions = new int[2];
        addedFractions[0] = faren[0] + highTerm32[0];
        addedFractions[1] = faren[1];

        int[] answer = {addedFractions[0], highTerm32[1]};
        answer[0] *= 5;
        answer[1] *= 9;

        int[] reducedFraction = reduceFraction(answer[0], answer[1]);
        System.out.println(reducedFraction[0] + "/" + reducedFraction[1]);
    }

    // returns 32 as a number w/ a common denominator with F. If C = -6/4, then return -128/4
    static int[] getCommonDenom(int denom) {
        int[] tmp = new int[2];
        int newNumerator = denom * -32;
        tmp[0] = newNumerator;
        tmp[1] = denom;
        return tmp;
    }

    // returns an array in fraction form of 9/5 * C
    static int[] reduceFraction(int numerator, int denominator) {
        int[] arr = new int[2];
        int GCD = gcd(numerator, denominator);
        arr[0] = numerator / GCD;
        arr[1] = denominator / GCD;
        return arr;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return Math.abs(gcd(b, a % b));
    }
}
