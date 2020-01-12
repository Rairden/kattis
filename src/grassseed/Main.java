package grassseed;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String in = """
                0.75
                2
                2 3.333
                3.41 4.567
                """;
        Scanner scan = new Scanner(in);

        double  RATE_PER_METER = 0;
        int     NUMBER_OF_LAWNS = 0;

        try {
            RATE_PER_METER = scan.nextDouble();
            NUMBER_OF_LAWNS = scan.nextInt();
            System.out.printf("%.7f", GrassSeed.totalCostOfSeed(RATE_PER_METER, NUMBER_OF_LAWNS, scan));
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
