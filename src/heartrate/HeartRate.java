package heartrate;

import java.util.Scanner;

public class HeartRate {

    public static void main(String[] args) {
        bpm();
    }

    private static void bpm() {
        String in = """
                2
                6 5.0000
                2 3.1222
                """;
        Scanner scan = new Scanner(in);
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
