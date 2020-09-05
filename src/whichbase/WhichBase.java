package whichbase;

import lib.io.FastReader;

// https://open.kattis.com/problems/whichbase

public class WhichBase {

    public static void main(String[] args) {

        String in = """
                4
                1 1234
                2 9
                3 1777
                4 129
                """;

        FastReader io = new FastReader(in);

        int cases = Integer.parseInt(io.nextLine());

        for (int i = 1; i <= cases; i++) {
            io.nextInt();
            String num = io.next();

            String octToDec = convertToDecimal(num, 8);
            String hexToDec = convertToDecimal(num, 16);

            System.out.printf("%s %s %s %s\n", i, octToDec, num, hexToDec);
        }
    }

    static String convertToDecimal(String x, int base) {
        int result = 0;
        try {
            result = Integer.parseInt(x, base);
        } catch (NumberFormatException e) {
            return "0";
        }
        return String.valueOf(result);
    }
}
