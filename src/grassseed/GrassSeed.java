package grassseed;

import java.util.Scanner;

public class GrassSeed {

    public static double lawnArea(double width, double length) throws IllegalArgumentException {
        if (width < 0 || length < 0) {
            throw new IllegalArgumentException("width or length cannot be less than zero");
        }
        if (width > 100 || length > 100) {
            throw new IllegalArgumentException("width or length cannot be greater than 100");
        }
        return width * length;
    }

    public static double totalCostOfSeed(double RATE_PER_METER, int numberOfLawns, Scanner scan) {

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
