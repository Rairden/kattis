package keytocrypto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://open.kattis.com/problems/keytocrypto

public class KeyToCrypto {

    public static void main(String[] args) {
        String in = """
                SGZVQBUQAFRWSLC
                ACM
                """;
        Scanner scan = new Scanner(in);
        decryptMessage(scan.nextLine(), scan.nextLine());
    }

    /**
     * @param ciphertext the encrypted word (e.g, SGZVQBUQAFRWSLC)
     * @param secretWord (e.g., ACMSENDMOREMONK is the key, and ACM is the secret word)
     */
    static void decryptMessage(String ciphertext, String secretWord) {

        final int CONVERTBASE26 = 65;               // magic offset number. A = 0 and 65 in ASCII
        char[] cipher = ciphertext.toCharArray();   // SGZVQBUQAFRWSLC
        List<Character> key = new ArrayList<>();    // ACM

        char[] secret = secretWord.toCharArray();   // initialize List by adding secretWord (ACM)
        for (char c : secret) {
            key.add(c);
        }

        // cipher - key = message    S-A = S
        // append result to key.     ACM + S
        int i = 0;
        for (char ciph : cipher) {
            // If cipher > key then do simple subtraction.  S - A = S    83 - 0 = 83
            // If cipher < key, create a bounded counter object that loops in reverse (1, 0, 25, 24, ...)
            if (ciph > key.get(i)) {
                int result = ciph - key.get(i) + CONVERTBASE26;
                key.add((char) result);
            } else {
                int begin   = ciph - CONVERTBASE26;
                int end     = key.get(i) - CONVERTBASE26;
                int counter = previous(25, begin, end);
                int result  = counter + CONVERTBASE26;
                key.add((char) result);
            }
            i++;
        }

        // ACMSENDMOREMONKEYS   Trim the front by size of secret word (3).
        //    SENDMOREMONKEYS
        int arrayVsListLengthDiff = key.size() - cipher.length;
        for (int j = 0; j < arrayVsListLengthDiff; j++) {
            key.remove(0);
        }

        for (Character c : key) {
            System.out.print(c);
        }
    }

    static int previous(int upperLimit, int begin, int end) {
        int value = begin;
        for (int k = 0; k < end; k++) {
            if (value == 0) {
                value = upperLimit;
                continue;
            }
            value--;
        }
        return value;
    }
}
