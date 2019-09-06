package growlinggears;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static growlinggears.Gear.torqueOutput;

public class GrowlingGears {

    public static void main(String[] args) {

        String input = "3\n" +
                "1\n" +
                "1 4 2\n" +
                "2\n" +
                "3 126 1400\n" +
                "2 152 208\n" +
                "2\n" +
                "3 127 1400\n" +
                "2 154 208\n";

        Scanner scan = new Scanner(input);
        int testCases = scan.nextInt();

        List<Gear> engine = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int numGears = scan.nextInt();
            for (int k = 0; k < numGears; k++) {
                int first   = scan.nextInt();
                int second  = scan.nextInt();
                int third   = scan.nextInt();
                Gear gear = new Gear(k+1, first, second, third);
                engine.add(gear);
            }
            if (engine.size() == 1) {
                System.out.println(engine.get(0).gear);
                engine.clear();
                continue;
            }
            for (Gear gear : engine) {
                gear.torque = torqueOutput(gear.coefficients);
            }
            Collections.sort(engine);
            System.out.println(engine.get(0).gear);
            engine.clear();
        }
    }
}

class Gear implements Comparable<Gear> {
    int gear;
    double torque;
    int[] coefficients;

    Gear(int gear, int first, int second, int third) {
        this.coefficients = new int[3];
        this.gear = gear;
        coefficients[0] = first;
        coefficients[1] = second;
        coefficients[2] = third;
    }

    static double torqueOutput(int[] cf) {
        double x = vertexFormula(cf[1], cf[0]);
        double a = cf[0];    float b = cf[1];    float c = cf[2];
        return -a*x*x + b*x + c;
    }

    static double vertexFormula(int b, int a) {
        double x = (double) -b / (2 * a);
        return Math.abs(x);
    }

    @Override
    public int compareTo(Gear o) {
        return Double.compare(o.torque, this.torque);
    }
}
