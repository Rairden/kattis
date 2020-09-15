package phonelist;

import lib.io.FastReader;

import java.io.FileNotFoundException;

// https://open.kattis.com/problems/phonelist

public class PhoneList {

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder file = new StringBuilder("src/phonelist/in");
        FastReader io = new FastReader(file);
        int cases = io.nextInt();

        for (int i = 0; i < cases; i++) {
            String result = consistencyCheck(io) ? "YES" : "NO";
            System.out.println(result);
        }
    }

    static boolean consistencyCheck(FastReader io) {
        TrieST<Integer> st = new TrieST<>();

        String symbolTable = "0123456789";
        int radix = 10;     // the number of symbols, or base

        for (int i = 0; i < radix; i++) {
            String number = String.valueOf(symbolTable.charAt(i));
            st.put(number, i);
        }

        int phoneNumbers = io.nextInt();
        String[] numbers = new String[phoneNumbers];

        for (int k = 0; k < phoneNumbers; k++) {
            numbers[k] = io.nextLine();
            st.put(numbers[k], k);
        }

        for (String num : numbers) {
            Iterable<String> strings = st.keysWithPrefix(num);
            if (hasPrefix(strings, num)) return false;
        }
        return true;
    }

    static boolean hasPrefix(Iterable<String> strings, String pattern) {
        for (String s : strings) {
            if (!s.equals(pattern)) return true;
        }
        return false;
    }
}
