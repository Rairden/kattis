package primesieve;

import lib.io.FastReader;

import java.util.Arrays;

import static lib.math.MyMath.isPrime;

public class PrimeSieve {

    public static void main(String[] args) {
        String in = """
                100 6
                1
                2
                3
                4
                9972
                9973
                """;
        // n = 9, 25, 100, 10000000.    🗸
        // n = 9973 is off by 1.        🗴

        FastReader io = new FastReader(in);
        int n = io.nextInt();
        int q = io.nextInt();
        System.out.println(n + " " + q);
        for (int i = 0; i < q; i++) {
            System.out.println(io.nextInt());
        }
        System.out.println("-------");

        for (int i = 0; i < 25; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
        System.out.println("-------");

        Boolean[] arr = new Boolean[n];
        Arrays.fill(arr, Boolean.TRUE);

        int rootN = (int) Math.sqrt(n);
        for (int i = 2; i <= rootN; i++) {
            if (arr[i]) {
                int k = 0;
                int r = (int) Math.pow(i, 2);
                for (int j = (int) Math.pow(i, 2); r < n; r = j + (k*i)) {
                    arr[r] = false;
                    k++;
                }
            }
        }

        int primeCnt = 1;
        arr[1] = false;
        arr[2] = true;
        arr[3] = true;
        for (int i = 3; i < n; i++) {
            if (arr[i]) {
                // System.out.println(i + " = " + arr[i]);
                // System.out.println(i);
                primeCnt++;
            }
        }
        System.out.println(primeCnt);
    }
}
