package keytocrypto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] e = alphabet.toCharArray();
        for (char i : e) {
            //System.out.printf("%s - %d \n", i, i - 65);
        }
        char g = 'G';
        char c = 'C';
        int result = g - 2;
        System.out.println(g);
        System.out.println(result);
        char result2 = (char) result;
        System.out.println(result2);

        String input = "SGZVQBUQAFRWSLC\nACM";
        Scanner scan = new Scanner(input);
        decryptMessage(scan.nextLine(), scan.nextLine());
    }

    /**
     * @param ciphertext the encrypted word (e.g, SGZVQBUQAFRWSLC)
     * @param secretWord (e.g., ACMSENDMOREMONK is the key, and ACM is the secret word)
     */
    public static void decryptMessage(String ciphertext, String secretWord) {
        char[] cipher = ciphertext.toCharArray();
        for (char i : cipher) {
            System.out.printf("%s - %d \n", i, i - 65);
        }
        char[] b = secretWord.toCharArray();
    }

    public static int boundedCounter(int x, int y, int range) {
        return 0;
    }
}
