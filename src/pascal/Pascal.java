package pascal;

import java.util.Scanner;

public class Pascal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(pascal(scan.nextInt()));
    }

    static int pascal(int N) {
        int cnt = 0;
        int n = N - 1;

        for (int i = n; i > 2; i--) {
            cnt++;
            if (N % i == 0) {
                break;
            }
        }
        return cnt;
    }
}
