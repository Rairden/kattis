package keytocrypto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = "SGZVQBUQAFRWSLC\nACM";
        Scanner scan = new Scanner(input);
        decryptMessage(scan.nextLine(), scan.nextLine());
    }

    /**
     * @param ciphertext the encrypted word (e.g, SGZVQBUQAFRWSLC)
     * @param secretWord (e.g., ACMSENDMOREMONK is the key, and ACM is the secret word)
     */
    private static List<Character> decryptMessage(String ciphertext, String secretWord) {

        final int CONVERTBASE26 = 65;               // magic offset number
        char[] cipher = ciphertext.toCharArray();   // SGZVQBUQAFRWSLC
        List<Character> key = new ArrayList<>();    // ACM

        // initialize secretWord (ACM) to resizeable List
        char[] secret = secretWord.toCharArray();
        for (char c : secret) {
            key.add(c);
        }

        // 1. cipher - key = message (S - A = S)
        // 2. append result to key. ACM + S
        int i = 0;
        for (char ciph : cipher) {

            // S - A = S
            if (ciph > key.get(i)) {
                int result = ciph - key.get(i) + CONVERTBASE26;
                key.add((char) result);
            }
            // B - N = O    1 - 13 = 14 or 78
            else {
                int result = ciph + key.get(i) - CONVERTBASE26;
                key.add((char) result);
            }
            i++;
        }
        return key;
    }
}
