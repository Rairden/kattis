package twostones;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        if (x % 2 == 1) {
            System.out.println("Alice");
        }
        if (x % 2 == 0) {
            System.out.println("Bob");
        }
    }
}
