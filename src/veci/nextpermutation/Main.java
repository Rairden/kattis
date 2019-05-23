package veci.nextpermutation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] arr = scan.nextLine().toCharArray();
        next_permutation(arr);
    }

    static boolean next_permutation(char[] p) {
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
