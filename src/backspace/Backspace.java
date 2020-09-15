package backspace;

import lib.io.FastReader;

// https://open.kattis.com/problems/backspace

public class Backspace {

    public static void main(String[] args) {
        FastReader io = new FastReader(System.in);
        System.out.println(backspace(io.nextLine()));
    }

    static StringBuilder backspace(String in) {
        StringBuilder sb = new StringBuilder(in);
        sb.ensureCapacity(1000000);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '<') {
                try {
                    sb.deleteCharAt(i - 1);
                } catch (Exception e) {
                    sb.deleteCharAt(i);
                    continue;
                }
                sb.deleteCharAt(i - 1);
                i = -1;
            }
        }
        return sb;
    }
}
