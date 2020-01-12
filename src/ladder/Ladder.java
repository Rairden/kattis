package ladder;

import java.util.Scanner;

public class Ladder {

    public static void main(String[] args) {
        String in = "500 70\n";
        Scanner scan = new Scanner(in);
        double wallHeight = scan.nextInt();
        double theta = scan.nextInt();

        double radians = Math.toRadians(theta);     // convert degrees to radians
        double sinOfTheta = Math.sin(radians);

        double ladderLength = Math.ceil(wallHeight / sinOfTheta);
        System.out.printf("%.0f", ladderLength);
    }
}
