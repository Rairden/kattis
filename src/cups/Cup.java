package cups;

import java.util.*;

public class Cup implements Comparable<Cup> {

    public static void main(String[] args) {
        String input = """
                3
                red 10
                10 blue
                green 7
                """;

        Scanner scan    = new Scanner(input);
        List<Cup> cups  = new ArrayList<>();
        int numCups     = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < numCups; i++) {
            String tok1 = scan.next();
            String tok2 = scan.next();
            if (tok1.matches("\\d+")) {
                Cup cup = new Cup(tok2, Integer.parseInt(tok1)/2);
                cups.add(cup);
            } else {
                Cup cup = new Cup(tok1, Integer.parseInt(tok2));
                cups.add(cup);
            }
        }

        Collections.sort(cups);
        for (Cup cup : cups) {
            System.out.println(cup.color);
        }
    }

    int radius;
    String color;

    public Cup(String color, int radius) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public int compareTo(Cup o) {
        int i = this.radius - o.radius;
        if (i != 0) {
            return i;
        }
        return this.radius - o.radius;
    }
}
