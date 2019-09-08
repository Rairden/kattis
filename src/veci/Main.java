package veci;

import java.util.*;
import static veci.IntegerToList.splitNumber;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
            if (integer == 0)
                convert.zero++;
            else if (integer == 1)
                convert.one++;
            else if (integer == 2)
                convert.two++;
            else if (integer == 3)
                convert.three++;
            else if (integer == 4)
                convert.four++;
            else if (integer == 5)
                convert.five++;
            else if (integer == 6)
                convert.six++;
            else if (integer == 7)
                convert.seven++;
            else if (integer == 8)
                convert.eight++;
            else if (integer == 9)
                convert.nine++;
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
                if (integer == 0)
                    zero++;
                else if (integer == 1)
                    one++;
                else if (integer == 2)
                    two++;
                else if (integer == 3)
                    three++;
                else if (integer == 4)
                    four++;
                else if (integer == 5)
                    five++;
                else if (integer == 6)
                    six++;
                else if (integer == 7)
                    seven++;
                else if (integer == 8)
                    eight++;
                else if (integer == 9)
                    nine++;
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
