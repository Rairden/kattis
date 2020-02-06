package primesieve;

import lib.io.FastReader;
import java.util.Arrays;
import static java.lang.Boolean.TRUE;

public class PrimeSieve {

    public static void main(String[] args) {

        FastReader io = new FastReader(System.in);
        int n = io.nextInt();
        int q = io.nextInt();

        System.out.println(sieve(n));

        for (int i = 0; i < q; i++) {
            if (isPrime(io.nextInt())) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static int sieve(int n) {
        if (n == 1) {
            return 0;
        }
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, TRUE);

        int rootN = (int) Math.sqrt(n);
        for (int i = 2; i <= rootN; i++) {
            if (arr[i]) {
                int k = 0;
                int r = (int) Math.pow(i, 2);
                for (int j = (int) Math.pow(i, 2); r <= n; r = j + (k*i)) {
                    arr[r] = false;
                    k++;
                }
            }
        }

        int primeCnt = 1;
        for (int i = 3; i <= n; i++) {
            if (arr[i]) {
                primeCnt++;
            }
        }
        return primeCnt;
    }

    public static boolean isPrime(long n) {
        // check lower boundaries on primality
        if (n == 2) {
            return true;
        } else if (n == 1 || (n & 1) == 0) {    // 1 is not prime, even numbers > 2 are not prime
            return false;
        }

        double sqrtN = Math.sqrt(n);
        // Check for primality using odd numbers from 3 to sqrt(n)
        for (int i = 3; i <= sqrtN; i += 2) {
            // n is not prime if it is evenly divisible by some 'i' in this range
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
