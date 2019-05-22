package abc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = "1 5 3 \n ABC";
        Scanner scan = new Scanner(input);
        mySort(2,1,3);
    }

    private static int[] mySort(int a, int b, int c) {
        int min = 0;
        int mid = 0;
        int max = 0;
        int[] arr = new int[]{0,0,0};

        if (a < b || a < c) {
            if (b < c) {
                min = a;
                mid = b;
                max = c;
            }
            else if ( b > c) {
                min = a;
                mid = c;
                max = b;
            }
        } else if (a > b || a > c) {
            if (b > c)
                max = c;
            else if (b < c) {
                min = b;
                mid = c;
                max = a;
            } else {
                min = c;
                mid = b;
                max = a;
            }
        }

        arr[0] = min;
        arr[1] = mid;
        arr[2] = max;
        return arr;
    }

}
