package heartrate;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        bpm();
    }

    private static void bpm() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int beats       = scan.nextInt();
            double seconds  = scan.nextDouble();
            double BPM      = 60 * beats / seconds;
            double diff     = 60 / seconds;

            System.out.printf("%.4f %.4f %.4f \n", (BPM - diff), BPM, (BPM + diff));
        }
    }
}
