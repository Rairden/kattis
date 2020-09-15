package veci;

import java.util.*;
import static veci.IntegerToList.splitNumber;

// https://open.kattis.com/problems/veci

public class Veci {

    public static void main(String[] args) {
        String in = "156";
        Scanner scan = new Scanner(in);
        int number = scan.nextInt();

        constructFirstNum(number);
    }

    static void constructFirstNum(int number) {
        IntegerToList convert = IntegerToList.getInstance();

        String str = String.valueOf(number);
        String[] arr = str.split("");
        int length = str.length();

        for (String s : arr) {
            convert.firstNum.add(Integer.parseInt(s));
        }

        for (Integer integer : convert.firstNum) {
            switch (integer) {
                case 0 -> convert.zero += 1;
                case 1 -> convert.one += 1;
                case 2 -> convert.two += 1;
                case 3 -> convert.three += 1;
                case 4 -> convert.four += 1;
                case 5 -> convert.five += 1;
                case 6 -> convert.six += 1;
                case 7 -> convert.seven += 1;
                case 8 -> convert.eight += 1;
                case 9 -> convert.nine += 1;
            }
        }
        findMatchingNumber(number, length);
    }

    static void findMatchingNumber(int number, int length) {
        int limit = (int) Math.pow(10, length) - 1;     // If number is 27,711  then limit = 10^5 - 1 = 99,999
        int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;

        while (number <= limit) {
            number++;
            splitNumber(number);
            for (Integer integer : IntegerToList.convert.secondNum) {
                switch (integer) {
                    case 0 -> zero++;
                    case 1 -> one++;
                    case 2 -> two++;
                    case 3 -> three++;
                    case 4 -> four++;
                    case 5 -> five++;
                    case 6 -> six++;
                    case 7 -> seven++;
                    case 8 -> eight++;
                    case 9 -> nine++;
                }
            }

            // compare firstNum to secondNum, then reset the counters to 0 if it doesn't pass test.
            if (IntegerToList.convert.zero == zero
                    && IntegerToList.convert.one == one
                    && IntegerToList.convert.two == two
                    && IntegerToList.convert.three == three
                    && IntegerToList.convert.four == four
                    && IntegerToList.convert.five == five
                    && IntegerToList.convert.six == six
                    && IntegerToList.convert.seven == seven
                    && IntegerToList.convert.eight == eight
                    && IntegerToList.convert.nine == nine) {
                for (Integer integer : IntegerToList.convert.secondNum) {
                    System.out.print(integer);
                }
                return;
            } else {
                nine = 0;
                zero = one = two = three = four = five = six = seven = eight = nine;
                IntegerToList.convert.secondNum.clear();
            }
        }
        System.out.print(0);
    }
}
