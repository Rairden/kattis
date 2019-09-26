package triangle;

import java.util.Scanner;
import static triangle.Circumference.circumference;

public class Triangle2 {

    public static void main(String[] args) {

        String input = "5\n100\n";
        Scanner scan = new Scanner(input);

        int i = 1;
        while (scan.hasNextLine()) {
            int iteration = Integer.parseInt(scan.nextLine());
            int numberOfDigits = circumference(iteration);
            System.out.printf("Case %d: %d\n", i, numberOfDigits);
            i++;
        }
    }
}
