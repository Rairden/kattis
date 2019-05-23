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

        int limit = (int) Math.pow(10, length);
        getNumber(number, length);

    }

    public static int getNumber(int number, int length) {
        int limit = (int) Math.pow(10, length);
        while (number <= limit) {
            number++;
            IntegerToList.splitNumber(number);

        }

        return 0;
    }

}

class IntegerToList {
    public List<Integer> firstNum;
    public List<Integer> secondNum;
    private Stack<Integer> stack;

    static IntegerToList convert = null;

    private IntegerToList() {
        firstNum    = new ArrayList<>();
        secondNum   = new ArrayList<>();
        stack       = new Stack<>();
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
