package bits;

import java.util.Scanner;

public class Bits {

    public static void main(String[] args) {
        String input = "7\n" +
                "1\n2\n3\n4\n10\n94\n72\n";
        Scanner scan = new Scanner(input);
        int numInputs = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < numInputs; i++) {
            int maxNumberOfOnes = decimalToArray(String.valueOf(scan.nextLine()));
            System.out.println(maxNumberOfOnes);
        }
    }

    static int decimalToArray(String num) {
        int numberOfOnes, maxNumberOfOnes = 0;
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
