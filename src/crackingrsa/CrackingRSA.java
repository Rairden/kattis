package crackingrsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrackingRSA {

    public static void main(String[] args) {
        String input = """
                3
                33 3
                65 11
                6012707 3674911
                """;

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
}
