package roundedbuttons;

import lib.io.FastReader;

import java.util.ArrayList;
import java.util.List;

import static roundedbuttons.Pair.*;

public class RoundedButtons {

    public static void main(String[] args) {
        String in = """
                3
                1 8 14 13 3 5 8 6 15 8 12 11 14 21 2.5 20
                2 2 13 14 4 5 4 4 4 16 13 14 3 3 3 9
                85.7 114.7 3.2 6.0 1.2 3 86.3 114.8 88.1 118.2 85.9 120.7
                """;
        FastReader io = new FastReader(in);
        int testCases = Integer.parseInt(io.nextLine());

        double x, y, w, h, r;
        for (int i = 0; i < testCases; i++) {
            x = io.nextDouble();
            y = io.nextDouble();
            w = io.nextDouble();
            h = io.nextDouble();
            r = io.nextDouble();

            List<Pair> clicks = new ArrayList<>();
            int numPairs = io.nextInt();
            for (int k = 0; k < numPairs; k++) {
                clicks.add(new Pair(io.nextDouble(), io.nextDouble()));
            }

            List<String> result = calcInOut(x, y, w, h, r, clicks);
            for (String str : result) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    static List<String> calcInOut(double x, double y, double w, double h, double r, List<Pair> clicks) {
        List<String> result = new ArrayList<>();
        double inWidth  = w - (2 * r);
        double inHeight = h - (2 * r);

        // calculate all 4 center points
        Pair center2 = new Pair(x + r, y + r);
        Pair center3 = new Pair(x + r, y + r + inHeight);
        Pair center1 = new Pair(x + r + inWidth, y + r);
        Pair center4 = new Pair(x + r + inWidth, y + r + inHeight);

        double xBegin = x + r;
        double xEnd = xBegin + inWidth;
        double yEnd = y + h;

        for (Pair click : clicks) {
            if (click.x >= xBegin && click.x <= xEnd) {     // vertical rectangle
                if (click.y >= y && click.y <= yEnd) {
                    result.add("inside");
                    continue;
                }
            } else if (click.x >= x && click.x <= x + w) {  // horizontal rectangle
                if (click.y >= y + r && click.y <= y + r + inHeight) {
                    result.add("inside");
                    continue;
                }
            }

            if (click.x < x + r) {
                if (click.y < y + r) {      // quadrant 2
                    populateArray(center2, click, r, result);
                } else {                    // quadrant 3
                    populateArray(center3, click, r, result);
                }
            } else {
                if (click.y < y + r) {      // quadrant 1
                    populateArray(center1, click, r, result);
                } else {                    // quadrant 4
                    populateArray(center4, click, r, result);
                }
            }
        }
        return result;
    }
}

class Pair {
    double x;
    double y;

    public Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }

    static double calcDistance(Pair center, Pair click) {
        double xDistance = (center.x - click.x);
        double yDistance = (center.y - click.y);
        double x = Math.pow(xDistance, 2);
        double y = Math.pow(yDistance, 2);

        return Math.pow(x + y, 0.5);
    }

    static boolean isInside(double distance, double radius) {
        return distance <= radius;
    }

    static void populateArray(Pair center, Pair click, double radius, List<String> result) {
        double distance = calcDistance(center, click);
        if (isInside(distance, radius)) {
            result.add("inside");
        } else {
            result.add("outside");
        }
    }
}
