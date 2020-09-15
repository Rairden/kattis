package grassseed;

import java.util.Scanner;

// https://open.kattis.com/problems/grassseed

public class GrassSeed {

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

    static double lawnArea(double width, double length) throws IllegalArgumentException {
        if (width < 0 || length < 0) {
            throw new IllegalArgumentException("width or length cannot be less than zero");
        }
        if (width > 100 || length > 100) {
            throw new IllegalArgumentException("width or length cannot be greater than 100");
        }
        return width * length;
    }

    static double totalCostOfSeed(double RATE_PER_METER, int numberOfLawns, Scanner scan) {

        double totalCost = 0;

        for (int i = 0; i < numberOfLawns; i++) {
            double width = 0;
            double length = 0;
            try {
                width = scan.nextDouble();
                length = scan.nextDouble();
                double area = lawnArea(width, length);
                totalCost += area * RATE_PER_METER;

            } catch (Exception e) {
                System.exit(-1);
            }
        }
        return totalCost;
    }
}
