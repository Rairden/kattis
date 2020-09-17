package almostperfect;

import lib.io.FastReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlmostPerfect {

    public static void main(String[] args) {
        String in = """
                6
                65
                650
                """;
        FastReader io = new FastReader(in);

        String line;
        while ((line = io.nextLine()) != null) {
            int p = Integer.parseInt(line);
            System.out.println(p + " " + calcPerfectNumber(p));
        }
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
        int sum = sumAllDivisors(p);
        if (sum == p) {
            return "perfect";
        }
        return (sum >= p - 2 && sum <= p + 2) ? "almost perfect" : "not perfect";
    }

    static String calcPerfectNumber2(int p) {
        // list of perfect numbers below 1 billion
        if (p == 6 || p == 28 || p == 496 || p == 8128 || p == 33550336) {
            return "perfect";
        }
        if (almostPerfect.contains(p)) {
            return "almost perfect";
        }
        return "not perfect";
    }

    // almost perfect, least deficient or slightly defective numbers (± 2)
    static List<Integer> almostPerfect = new ArrayList<>(Arrays.asList(2, 3, 4, 8, 10, 16, 20, 32, 64, 104,
            128, 136, 256, 464, 512, 650, 1024, 1952, 2048, 4096, 8192, 16384, 32768, 32896, 65536, 130304,
            131072, 262144, 522752, 524288, 1048576, 2097152, 4194304, 8382464, 8388608, 16777216, 33554432,
            67108864, 134193152, 134217728, 268435456, 536870912));
}
