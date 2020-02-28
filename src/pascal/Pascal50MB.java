package pascal;

import java.util.Scanner;

public class Pascal50MB {

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        System.out.println(pascal(10));
    }

    static int pascal(int N) {
        int cnt = 0;
        int n = N - 1;
        int inc = smallestDivisor(N);
        int i = 0;
        // if N is even AND inc = 2, then +- 1 to i.

        if (N % 2 == 0 && inc == 2) {
            cnt++;
        }

        for (i = n; i > 2; i -= inc) {
            if (i == N) {
                continue;
            }
            cnt += inc;
            if (N % i == 0) {
                break;
            }
        }
        return cnt;
    }

    static int smallestDivisor(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
