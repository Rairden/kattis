package abc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = "1 5 3\nABC";
        Scanner scan = new Scanner(input);
        int[] arr = mySort(scan.nextInt(), scan.nextInt(), scan.nextInt());

        scan.nextLine();    // need to fix this
        String command = scan.nextLine();

        for (int i = 0; i < 3; i++) {
            char cmd = command.charAt(i);
            switch (cmd) {
                case 'A':
                    System.out.print(arr[0] + " ");
                    break;
                case 'B':
                    System.out.print(arr[1] + " ");
                    break;
                case 'C':
                    System.out.print(arr[2] + " ");
                    break;
            }
        }
    }

    private static int[] mySort(int a, int b, int c) {
        int min;
        int mid;
        int max;
        int[] arr = new int[3];

        if (a < b || a < c) {
            if (b < c) {
                max = c;
                if (a < b) {
                    min = a;
                    mid = b;

                } else {
                    min = b;
                    mid = a;
                }
            } else if (b > c && a < c) {
                min = a;
                mid = c;
                max = b;
            } else {
                min = c;
                mid = a;
                max = b;
            }
        } else {
            max = a;
            if (b < c) {
                min = b;
                mid = c;
            } else {
                min = c;
                mid = b;
            }
        }
        arr[0] = min;
        arr[1] = mid;
        arr[2] = max;
        return arr;
    }
}
