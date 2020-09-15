package veci.nextpermutation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String in = "156";      // answer = 165
        String in2 = "27711";   // answer = 71127

        Scanner scan = new Scanner(in);

        // char[] arr = scan.nextLine().toCharArray();
        String[] num = scan.nextLine().split("");

        int[] arr = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }
        next_permutation(arr);
    }

    static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a) {
            if (p[a] < p[a + 1]) {
                for (int b = p.length - 1; ; --b) {
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        for (int i : p) {
                            System.out.print(i);
                        }
                        return true;
                    }
                }
            }
        }
        System.out.print(0);
        return false;
    }

    static boolean next_permutation2(char[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1; ; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = (char) t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = (char) t;
                        }
                        for (char c : p)
                            System.out.print(c);
                        return true;
                    }
        System.out.print(0);
        return false;
    }
}
