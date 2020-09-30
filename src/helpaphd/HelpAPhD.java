package helpaphd;

import lib.io.FastReader;

import java.io.FileNotFoundException;

// https://open.kattis.com/problems/helpaphd

public class HelpAPhD {

    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder file = new StringBuilder("src/helpaphd/in");
        FastReader io = new FastReader(file);
        int testCases = io.nextInt();

        for (int i = 0; i < testCases; i++) {
            String line = io.nextLine();
            String[] split = line.split("[+=]");

            if (isDigit(split[0])) {
                System.out.println(addNumbers(split));
            } else {
                System.out.println("skipped");
            }
        }
    }

    static int addNumbers(String[] arr) {
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);
        return a + b;
    }

    static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
