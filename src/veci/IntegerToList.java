package veci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class IntegerToList {

    List<Integer> firstNum;
    List<Integer> secondNum;
    Stack<Integer> stack;
    int zero, one, two, three, four, five, six, seven, eight, nine;

    static IntegerToList convert = null;

    private IntegerToList() {
        firstNum    = new ArrayList<>();
        secondNum   = new ArrayList<>();
        stack       = new Stack<>();
    }

    static IntegerToList getInstance() {
        if (convert == null) {
            convert = new IntegerToList();
        }
        return convert;
    }

    /**
     * @param number the number we want to split apart to add to a List
     */
    static void splitNumber(int number) {
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
