package veci;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String input = "156";
        String[] arr = input.split("");
        int length = input.length();

        Scanner scan = new Scanner(input);
        int number = scan.nextInt();
        constructFirstNum(arr, number, length);
    }

    public static void constructFirstNum(String[] arr, int number, int length) {
        IntegerToList convert = IntegerToList.getInstance();

        for (String s : arr) {
            convert.firstNum.add(Integer.parseInt(s));
        }

        for (Integer integer : IntegerToList.convert.firstNum) {
            if (integer == 0)
                IntegerToList.convert.zero++;
            else if (integer == 1)
                IntegerToList.convert.one++;
            else if (integer == 2)
                IntegerToList.convert.two++;
            else if (integer == 3)
                IntegerToList.convert.three++;
            else if (integer == 4)
                IntegerToList.convert.four++;
            else if (integer == 5)
                IntegerToList.convert.five++;
            else if (integer == 6)
                IntegerToList.convert.six++;
            else if (integer == 7)
                IntegerToList.convert.seven++;
            else if (integer == 8)
                IntegerToList.convert.eight++;
            else if (integer == 9)
                IntegerToList.convert.nine++;
        }
        findMatchingNumber(number, length);
    }

    public static void findMatchingNumber(int number, int length) {
        int limit = (int) Math.pow(10, length) - 1;     // If number is 27,711  then limit = 10^5 - 1 = 99,999
        int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;

        while (number <= limit) {
            number++;
            IntegerToList.splitNumber(number);
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
    }
}

class IntegerToList {
    public List<Integer> firstNum;
    public List<Integer> secondNum;
    private Stack<Integer> stack;
    public int zero, one, two, three, four, five, six, seven, eight, nine;

    static IntegerToList convert = null;

    private IntegerToList() {
        firstNum    = new ArrayList<>();
        secondNum   = new ArrayList<>();
        stack       = new Stack<>();
        int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;
    }

    public static IntegerToList getInstance() {
        if (convert == null) {
            convert = new IntegerToList();
        }
        return convert;
    }

    /**
     * @param number the num we want to split apart
     * @return an ArrayList of the individual numbers we want to later compare
     */
    public static void splitNumber(int number) {
        while (number > 0) {
            int remainder = number % 10;
            convert.stack.push(remainder);
            number /= 10;
        }

        for (Iterator<Integer> itr = convert.stack.iterator(); itr.hasNext(); ) {
            convert.secondNum.add(convert.stack.pop());
        }
    }
}
