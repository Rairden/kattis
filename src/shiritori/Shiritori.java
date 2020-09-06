package shiritori;

import lib.io.FastReader;

import java.util.HashSet;
import java.util.Set;

// https://open.kattis.com/problems/shiritori

public class Shiritori {

    public static void main(String[] args) {

        String in = """
                3
                apple
                extra
                apple
                """;

        FastReader io = new FastReader(in);
        int cases = io.nextInt();

        String firstWord = io.nextLine();
        dict.add(firstWord);
        lastChar = firstWord.charAt(firstWord.length() - 1);

        for (int i = 2; i <= cases; i++) {
            String word = io.nextLine();
            firstChar = word.charAt(0);

            if (lastChar != firstChar || !addWord(word)) {
                printResult(i);
                return;
            }

            lastChar = word.charAt(word.length() - 1);
        }

        System.out.println("Fair Game");
    }

    static void printResult(int i) {
        int player = getPlayer(i);
        System.out.println("Player " + player + " lost");
    }

    // player1 is odd. player2 is even.
    static int getPlayer(int i) {
        int player = i % 2;
        player = (player == 1) ? 1 : 2;
        return player;
    }

    static boolean addWord(String word) {
        return dict.add(word);
    }

    static char firstChar;
    static char lastChar;
    static Set<String> dict = new HashSet<>();
}
