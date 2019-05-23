package veci;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String input = "157";
        String[] arr = input.split("");
        int length = input.length();

        Scanner scan = new Scanner(input);
        int number = scan.nextInt();
        foo(arr, number, length);

    }

    public static void foo(String[] arr, int number, int length) {
        IntegerToList convert = IntegerToList.getInstance();
        String[] arrayInitial = arr.clone();

        for (String s : arrayInitial) {
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

        int limit = (int) Math.pow(10, length);
        getNumber(number, length);

    }

    public static int getNumber(int number, int length) {
        int limit = (int) Math.pow(10, length);
        int zero = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;

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

            // now compare firstNum to secondNum
            int x = IntegerToList.convert.one;

        }
        return 0;
    }
}

class IntegerToList {
    public List<Integer> firstNum;
    public List<Integer> secondNum;
    private Stack<Integer> stack;
    int zero;
    int one;
    int two;
    int three;
    int four;
    int five;
    int six;
    int seven;
    int eight;
    int nine;

    static IntegerToList convert = null;

    private IntegerToList() {
        firstNum    = new ArrayList<>();
        secondNum   = new ArrayList<>();
        stack       = new Stack<>();
        int zero = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
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
