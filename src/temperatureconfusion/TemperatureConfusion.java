package temperatureconfusion;

import java.util.Scanner;

public class TemperatureConfusion {

    public static void main(String[] args) {
        // F = 9/5 * C + 32       C = (F - 32) * 5/9
        String input = "-6/4\n";
        String input2 = "33/1\n";

        Scanner scan = new Scanner(input);
        String line = scan.nextLine();

        String[] strArr = line.split("/");
        int[] faren = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String numString = strArr[i];
            faren[i] = Integer.parseInt(numString);
        }

        int numerator = faren[0];
        int denominator = faren[1];

        // now subtract 32      (-6/4 - 32/1)
        int[] $32 = getCommonDenom(denominator);

        // now subtract the numerators
        int[] addedFractions = new int[2];

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                addedFractions[i] = faren[i] + $32[i];
            } else {
                addedFractions[i] = faren[i];
            }
        }

        int[] answer = {addedFractions[0], $32[1]};
        answer[0] *= 5;
        answer[1] *= 9;

        if (answer[0] == 0) {
            answer[1] = 1;
        }

        int[] finalAnswer = reduceFraction(answer[0], answer[1]);
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
                System.out.print("/");
            }
            System.out.print(finalAnswer[i]);
        }
    }

    // returns 32 as a number w/ a common denominator   (-128/4)
    static int[] getCommonDenom(int denom) {
        int [] tmp = new int[2];
        int newNumerator = denom * -32 ;
        tmp[0] = newNumerator;
        tmp[1] = denom;
        return tmp;
    }

    // @return an array in in lowest terms; reduced fraction
    static int[] reduceFraction(int numerator, int denominator) {
        int[] arr = new int[2];
        boolean isNegative = numerator < 0;
        int negativeNum = 0;

        if (isNegative) {
            negativeNum = numerator * -1;
            int GCF = gcd(negativeNum, denominator);
            arr[0] = numerator / GCF;
            arr[1] = denominator / GCF;
            return arr;
        } else {
            int GCF = gcd(numerator, denominator);
            arr[0] = numerator/GCF;
            arr[1] = denominator/GCF;
            return arr;
        }
    }

    static int gcf(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    // Function to implement Stein's algorithm. Supposed to be 60% faster than the Euclidean Algorithm (arithmetic division vs bit shifting)
    static int gcd(int a, int b) {
        // GCD(0, b) == b; GCD(a, 0) == a, GCD(0, 0) == 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Finding K, where K is the greatest power of 2 that divides both a and b
        int k;
        for (k = 0; ((a | b) & 1) == 0; ++k) {
            a >>= 1;
            b >>= 1;
        }

        // Dividing a by 2 until a becomes odd
        while ((a & 1) == 0)
            a >>= 1;

        // From here on, 'a' is always odd.
        do {
            // If b is even, remove all factor of 2 in b
            while ((b & 1) == 0)
                b >>= 1;

            // Now a and b are both odd. Swap if necessary so a <= b, then set b = b - a (which is even)
            if (a > b) {
                // Swap u and v.
                int temp = a;
                a = b;
                b = temp;
            }

            b = (b - a);
        } while (b != 0);

        // restore common factors of 2
        return a << k;
    }
}
