package bits;

import java.util.Scanner;

// https://open.kattis.com/problems/bits

public class Bits {

    public static void main(String[] args) {
        String in = """
                7
                1
                2
                3
                4
                10
                94
                72
                """;
        Scanner scan = new Scanner(in);
        int numInputs = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < numInputs; i++) {
            int maxNumberOfOnes = decimalToArray(scan.nextLine());
            System.out.println(maxNumberOfOnes);
        }
    }

    static int decimalToArray(String num) {
        int numberOfOnes    = 0;
        int maxNumberOfOnes = 0;

        String[] decimalArray = num.split("");
        StringBuilder concatNum = new StringBuilder();

        for (String s : decimalArray) {
            String tmp = concatNum.append(s).toString();
            numberOfOnes = countOnes(tmp);
            if (numberOfOnes > maxNumberOfOnes) {
                maxNumberOfOnes = numberOfOnes;
            }
        }
        return maxNumberOfOnes;
    }

    static int countOnes(String decimalVal) {
        int numberOfOnes = 0;
        String decimal = Integer.toBinaryString(Integer.parseInt(decimalVal));
        String[] binaryArray = decimal.split("");
        for (String s : binaryArray) {
            if (s.equals("1")) {
                numberOfOnes++;
            }
        }
        return numberOfOnes;
    }
}
