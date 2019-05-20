package fizzbuzz;

import java.util.ArrayList;
import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();

        fizzBuzz(x, y, z);
    }

    private static void fizzBuzz(int x, int y, int n) {

        int lcm = lcm(x, y, n);

        for (int i = 1; i <= n; i++) {
            if (i % lcm == 0) {
                System.out.println("FizzBuzz");
            } else if (i % x == 0) {
                System.out.println("Fizz");
            } else if (i % y == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static int lcm(int x, int y, int n) {

        int lcm = 0;

        ArrayList<Integer> xMultiples = new ArrayList<>();
        ArrayList<Integer> yMultiples = new ArrayList<>();

        int a = x;
        for (int i = 0; i < n; i++) {
            xMultiples.add(a);
            a += x;
        }

        int b = y;
        for (int i = 0; i < n; i++) {
            yMultiples.add(b);
            b += y;
        }

        for (Integer d : xMultiples) {
            for (Integer e : yMultiples) {
                if (d.equals(e)) {
                    lcm = d;
                    return lcm;
                }
            }
        }
        return lcm;
    }
}
