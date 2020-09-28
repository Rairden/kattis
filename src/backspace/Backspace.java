package backspace;

import lib.io.FastReader;

import java.io.FileNotFoundException;

// https://open.kattis.com/problems/backspace

public class Backspace {

    static char BACKSPACE    = '<';
    static char DELETED_CHAR = '8';

    public static void main(String[] args) {
        String in = "c<def<ghi<<<<";
        FastReader io = new FastReader(in);
        StringBuilder sb = backspace((io.nextLine()));

        if (!sb.toString().isBlank()) {
            System.out.println(sb);
        }
    }

    static StringBuilder backspace(String in) {
        StringBuilder sb = new StringBuilder(in);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == BACKSPACE) {
                int backspaces = countRepeatedBackspaces(sb, i);

                if (backspaces >= 1 && i == 0) {
                    i = backspaces - 1;
                } else {
                    deleteChar(sb, i, backspaces);
                    i += backspaces;
                }
            }
        }
        return cleanResult(sb);
    }

    /**
     * Count the number of consecutive backspace symbols.
     * @param sb the input string
     * @param i the current index
     * @return the number of repeated backspace symbols
     */
    static int countRepeatedBackspaces(StringBuilder sb, int i) {
        int backspaces = 1;

        for (int k = i + 1; k < sb.length(); k++) {
            if (sb.charAt(k) == BACKSPACE) {
                backspaces++;
            } else {
                return Math.max(backspaces, 1);
            }
        }
        return backspaces;
    }

    /**
     * Instead of shuffling, I replace the deleted character w/ a magic symbol DELETED_CHAR.
     * @param sb the input string
     * @param i the current index
     * @param backspaces how many characters to delete
     */
    static void deleteChar(StringBuilder sb, int i, int backspaces) {
        int deleted = 0;
        int offset  = 1;

        while (backspaces > deleted) {
            if (sb.charAt(i - offset) != DELETED_CHAR && sb.charAt(i - offset) != BACKSPACE) {
                sb.setCharAt(i - offset, DELETED_CHAR);
                deleted++;
            }
            offset++;

            if (i - offset < 0) return;
        }
    }

    /**
     * This method builds a string ignoring characters that are either '8' or '<'
     * @param sb the input string
     * @return a string less the '8' or '<' characters
     */
    static StringBuilder cleanResult(StringBuilder sb) {
        StringBuilder cleaned = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == DELETED_CHAR || sb.charAt(i) == BACKSPACE) continue;
            cleaned.append(sb.charAt(i));
        }
        return cleaned;
    }
}
