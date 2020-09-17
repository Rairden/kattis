package goldbach2;

import lib.io.FastReader;

import java.util.ArrayList;
import java.util.List;

import static lib.math.MyMath.isPrime;

// https://open.kattis.com/problems/goldbach2

public class GoldBach2 {

    public static void main(String[] args) {
        String in = """
                3
                4
                26
                100
                """;
        FastReader io = new FastReader(in);
        int testCases = io.nextInt();

        for (int i = 0; i < testCases; i++) {
            sumOfTwoPrimes(io.nextInt());
        }
    }

    static void sumOfTwoPrimes(int evenNum) {
        if (evenNum == 4) {
            System.out.println("4 has 1 representation(s)");
            System.out.println("2+2\n");
            return;
        }

        List<Integer> pairs = new ArrayList<>();
        int cnt = 0;
        int iter = 3;
        while (iter <= evenNum / 2) {
            if (isPrime(iter)) {
                int sum = evenNum - iter;
                if (evenNum == sum + iter && isPrime(sum)) {
                    pairs.add(iter);
                    pairs.add(sum);
                    cnt++;
                }
            }
            iter += 2;
        }
        System.out.println(evenNum + " has " + cnt + " representation(s)");

        for (int i = 0; i < pairs.size(); i += 2) {
            System.out.println(pairs.get(i) + "+" + pairs.get(i+1));
        }
        System.out.println();
    }
}
