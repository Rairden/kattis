package enlarginghashtables;

import lib.io.FastReader;

import static lib.math.MyMath.isPrime;

//https://open.kattis.com/problems/enlarginghashtables

public class EnlargingHashtables {

    public static void main(String[] args) {
        String in = """
                29
                33
                0""";
        FastReader io = new FastReader(in);

        while (true) {
            int x = io.nextInt();
            if (x == 0) {
                break;
            }
            resizeHashTable(x);
        }
    }

    static void resizeHashTable(int tableSize) {
        int doubled = tableSize * 2 + 1;
        while (true) {
            if (isPrime(doubled)) {
                if (!isPrime(tableSize)) {
                    System.out.printf("%d (%d is not prime)\n", doubled, tableSize);
                } else {
                    System.out.println(doubled);
                }
                return;
            } else {
                doubled += 2;
            }
        }
    }
}
