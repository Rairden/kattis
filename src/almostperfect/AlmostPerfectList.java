package almostperfect;

import lib.AQ;

import java.util.ArrayList;
import java.util.List;

public class AlmostPerfectList {

    public static void main(String[] args) {
        AQ.add(() -> {
            for (int p = 2; p < 100000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 100000000; p < 200000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 200000000; p < 300000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 300000000; p < 400000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 400000000; p < 500000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 500000000; p < 600000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 600000000; p < 700000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 700000000; p <= 800000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 800000000; p <= 900000000; p++) {
                calcPerfectNumber(p);
            }
        });
        AQ.add(() -> {
            for (int p = 900000000; p <= 1000000000; p++) {
                calcPerfectNumber(p);
            }
        });

        AQ.finish();
        System.out.println(almostPerfect.toString());
    }

    static int sumAllDivisors(int p) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                if (p / i == i) {
                    sum += i;
                } else {
                    sum += i;
                    sum = sum + (p / i);
                }
            }
        }
        return sum;
    }

    static String calcPerfectNumber(int p) {
        // list of perfect numbers below 1 billion
        if (p == 6 || p == 28 || p == 496 || p == 8128 || p == 33550336) {
            return "perfect";
        }

        int sum = sumAllDivisors(p);

        if (sum >= p - 2 && sum <= p + 2) {
            almostPerfect.add(p);
            return "almost perfect";
        } else {
            return "not perfect";
        }
    }

    // almost perfect, least deficient or slightly defective number (± 2)
    static List<Integer> almostPerfect = new ArrayList<>();
}
