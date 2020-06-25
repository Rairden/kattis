package growlinggears;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static growlinggears.Gear.torqueOutput;

public class GrowlingGears {

    public static void main(String[] args) {

        String input = """
                3
                1
                1 4 2
                2
                3 126 1400
                2 152 208
                2
                3 127 1400
                2 154 208
                """;

        Scanner scan = new Scanner(input);
        int testCases = scan.nextInt();

        List<Gear> engine = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            int numGears = scan.nextInt();
            for (int k = 0; k < numGears; k++) {
                int a   = scan.nextInt();
                int b   = scan.nextInt();
                int c   = scan.nextInt();
                Gear gear = new Gear(k+1, a, b, c);
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

    Gear(int gear, int a, int b, int c) {
        this.coefficients = new int[3];
        this.gear = gear;
        coefficients[0] = a;
        coefficients[1] = b;
        coefficients[2] = c;
    }

    static double torqueOutput(int[] cf) {
        double x = vertexFormula(cf[0], cf[1]);
        double a = cf[0], b = cf[1], c = cf[2];
        return -a*x*x + b*x + c;
    }

    static double vertexFormula(int a, int b) {
        double x = (double) -b / (2 * a);
        return Math.abs(x);
    }

    @Override
    public int compareTo(Gear o) {
        return Double.compare(o.torque, this.torque);
    }
}
