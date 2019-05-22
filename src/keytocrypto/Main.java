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
    private static void decryptMessage(String ciphertext, String secretWord) {

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
                BoundedCounter counter = BoundedCounter.getInstance(25);        // A-Z is 0-25
                int begin = ciph - CONVERTBASE26;
                int end = key.get(i) - CONVERTBASE26;
                counter.setValue(begin);
                for (int k = 0; k < end; k++) {
                    counter.previous();
                }
                int result = counter.getValue() + CONVERTBASE26;
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
}

class BoundedCounter {
    private int value;
    public int upperLimit;

    static BoundedCounter counter = null;

    private BoundedCounter(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public static BoundedCounter getInstance(int upperLimit) {
        if (counter == null) {
            counter = new BoundedCounter(upperLimit);
        }
        return counter;
    }

    public void previous() {
        if (value == 0) {
            value = upperLimit;
            return;
        }
        value--;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int x) {
        if (x >= 0 && x <= upperLimit) {
            value = x;
        }
    }

    public String toString() {
        return "" + value;
    }
}
