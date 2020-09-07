package wordsfornumbers;

import lib.io.FastReader;

import java.util.HashMap;
import java.util.Map;

// https://open.kattis.com/problems/wordsfornumbers

public class WordsForNumbers {

    public static void main(String[] args) {

        String in = """
                The speed limit is 40 mph, but you were going over 65
                99 bottles of ...
                I have 1 life.
                why does my foot have 4 toes?
                There was foul play w/ 38 milliliters of blood on the floor
                """;

        FastReader io = new FastReader(in);

        populateDictionary();

        String line;
        while ((line = io.nextLine()) != null) {
            String[] arr = line.split("\\s");

            StringBuilder word = new StringBuilder();
            int i = 0;
            for (String s : arr) {
                if (!isDigit(s)) {
                    word.append(s).append(" ");
                } else {
                    String convert = convertNumberToWord(s);
                    if (i == 0) {
                        String capitalize = convert.substring(0, 1).toUpperCase() + convert.substring(1);
                        word.append(capitalize).append(" ");
                    } else {
                        word.append(convert).append(" ");
                    }
                }
                i++;
            }
            System.out.println(word.toString().trim());
        }
    }

    static Map<Integer, String> digitToWords = new HashMap<>();

    static String convertNumberToWord(String number) {
        int num = Integer.parseInt(number);

        if (digitToWords.containsKey(num)) return digitToWords.get(num);

        if (num < 60) {
            if (num < 30) return calcWord(num, "twenty");
            if (num < 40) return calcWord(num, "thirty");
            if (num < 50) return calcWord(num, "forty");
            return calcWord(num, "fifty");
        } else {
            if (num < 70) return calcWord(num, "sixty");
            if (num < 80) return calcWord(num, "seventy");
            if (num < 90) return calcWord(num, "eighty");
            return calcWord(num, "ninety");
        }
    }

    static String calcWord(int num, String tens) {
        int ones = num % 10;
        if (ones == 0) return digitToWords.get(num);

        return tens + "-" + digitToWords.get(ones);
    }

    static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void populateDictionary() {
        digitToWords.put(0, "zero");
        digitToWords.put(1, "one");
        digitToWords.put(2, "two");
        digitToWords.put(3, "three");
        digitToWords.put(4, "four");
        digitToWords.put(5, "five");
        digitToWords.put(6, "six");
        digitToWords.put(7, "seven");
        digitToWords.put(8, "eight");
        digitToWords.put(9, "nine");
        digitToWords.put(10, "ten");
        digitToWords.put(11, "eleven");
        digitToWords.put(12, "twelve");
        digitToWords.put(13, "thirteen");
        digitToWords.put(14, "fourteen");
        digitToWords.put(15, "fifteen");
        digitToWords.put(16, "sixteen");
        digitToWords.put(17, "seventeen");
        digitToWords.put(18, "eighteen");
        digitToWords.put(19, "nineteen");
        digitToWords.put(20, "twenty");
        digitToWords.put(30, "thirty");
        digitToWords.put(40, "forty");
        digitToWords.put(50, "fifty");
        digitToWords.put(60, "sixty");
        digitToWords.put(70, "seventy");
        digitToWords.put(80, "eighty");
        digitToWords.put(90, "ninety");
    }
}
