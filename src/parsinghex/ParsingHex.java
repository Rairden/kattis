package parsinghex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingHex {

    public static void main(String[] args) {

        String input = """
                uyzrr0x5206aBCtrrwm0Xa8aD4poqwqr
                pqovx0x6d3e6-+ 230xB6fcgmmm
                0xffffffff
                """;
        var scan = new Scanner(input);

        // https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Integer.html#parseInt(java.lang.String,int)
        // To convert bases, use Integer.parseInt(). You cannot use a16 with the prefix '0x'
        String a16 = "0x5206aBC";
        String b16 = "5206aBC";
        String c16 = "5206ABC";
        int Base16to10 = Integer.parseInt(b16, 16);

        String regex = "0[xX][0-9a-fA-F]{1,8}";
        while (scan.hasNextLine()) {
            var pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(scan.nextLine());

            while (match.find()) {
                int length      = match.group().length();
                String str      = match.group();
                String subStr   = match.group().substring(2, length);

                long base16to10 = Long.parseLong(subStr, 16);
                System.out.println(str + " " + base16to10);
            }
        }
    }
}
