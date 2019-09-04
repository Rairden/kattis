package crackingrsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrackingRSA {

    public static void main(String[] args) {
        String input = "6\n" +
                "33 3\n" +
                "65 11\n" +
                "10142789312725007 5\n" +
                "988027 7\n" +
                "6012707 3674911\n" +
                "14 17\n";

        Scanner scan = new Scanner(input);
        int numKeys = scan.nextInt();

        for (int i = 0; i < numKeys; i++) {
            List<Long> pf = primeFactors(scan.nextLong());
            long p, q, e;
            e = scan.nextLong();
            p = pf.get(0);
            q = pf.get(1);

            long r = (p - 1) * (q - 1);
            findCandidate(e, r);
        }
    }

    /**
     * It is important for RSA that the value of the φ function (r) is coprime to e (the greatest common divisor must be 1).
     * e and d should be different to be strong.  k <= e    ed = k * r
     * @param e a prime number given as input
     * @param r is easily computed to (p - 1) * (q - 1)
     * @return d a prime number. This is the answer and secret private key
     */
    static long findCandidate(long e, long r) {
        for (long index_k = 1; index_k <= e; index_k++) {
            long candidateK = calcCandidate(r, index_k);
            if (candidateK % e == 0) {
                long d = candidateK / e;
                System.out.println(d);
                return d;
            }
        }
        return -1;
    }

    static long calcCandidate(long r, long index_k) {
        r = r * index_k + 1;
        return r;
    }

    static long gcf(long a, long b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    // Function to implement Stein's algorithm. Supposed to be 60% faster than the Euclidean Algorithm (arithmetic division vs bit shifting)
    static long gcd(long a, long b) {
        // GCD(0, b) == b; GCD(a, 0) == a, GCD(0, 0) == 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Finding K, where K is the greatest power of 2 that divides both a and b
        long k;
        for (k = 0; ((a | b) & 1) == 0; ++k) {
            a >>= 1;
            b >>= 1;
        }

        // Dividing a by 2 until a becomes odd
        while ((a & 1) == 0)
            a >>= 1;

        // From here on, 'a' is always odd.
        do {
            // If b is even, remove all factor of 2 in b
            while ((b & 1) == 0)
                b >>= 1;

            // Now a and b are both odd. Swap if necessary so a <= b, then set b = b - a (which is even)
            if (a > b) {
                // Swap u and v.
                long temp = a;
                a = b;
                b = temp;
            }

            b = (b - a);
        } while (b != 0);

        // restore common factors of 2
        return a << k;
    }

    // The extended Euclidean algorithm is particularly useful when a and b are coprime (or gcd is 1).
    static long gcdExtended(long a, long b, long x, long y) {
        // Base Case
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }

        long x1 = 1, y1 = 1; // To store results of recursive call
        long gcd = gcdExtended(b % a, a, x1, y1);

        // Update x and y using results of recursive call
        x = y1 - (b / a) * x1;
        y = x1;

        return gcd;
    }

    static List<Long> primeFactors(long r) {
        List<Long> factors = new ArrayList<>();
        for (long i = 2; i <= r; i++) {
            while (r % i == 0) {
                factors.add(i);
                r /= i;
            }
        }
        return factors;
    }

    static boolean isPrime(long n) {
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

    // my attempt at prime method (not perfect)
    static int[] primeFactorize(int x) {
        int[] arr = new int[3];
        arr[2] = 1;
        int factor1 = 0;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                factor1 = x / i;        // x = 33, factor1 = 11
                arr[0] = factor1;
                arr[1] = i;
                arr[2] = 0;
                break;
            }
        }
        return arr;
    }
}
