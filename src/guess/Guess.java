package guess;

import java.util.Scanner;

// https://open.kattis.com/problems/guess

public class Guess {

    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 1000;
        int guess = (upperBound + lowerBound) / 2;
        System.out.println(guess);
        binarySearch(lowerBound, upperBound, guess);
    }

    static void binarySearch(int lowerBound, int upperBound, int guess) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String response = scan.nextLine();
            if (response.equals("lower")) {
                upperBound = guess;
                guess = ((upperBound + lowerBound) / 2);
            }
            if (response.equals("higher")) {
                lowerBound = guess;
                guess = ((upperBound + lowerBound + 1) / 2);
            }
            if (response.equals("correct")) {
                return;
            }
            System.out.println(guess);
        }
    }
}
