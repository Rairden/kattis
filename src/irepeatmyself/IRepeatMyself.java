package irepeatmyself;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IRepeatMyself {

    public static void main(String[] args) {

        String input = "7\n" +
                "I Repeat Myself I Repeat Myself I Repeat\n" +
                "aaaaaaaaaaaaaaaaaaaaa\n" +
                "abbcabbcabbabbcabb\n" +
                "a\n" +
                "aa\n" +
                "ab\n" +
                "baba\n";

        Scanner scan = new Scanner(input);
        int testCases = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < testCases; i++) {
            String string = scan.nextLine();
            StringBuilder sb = new StringBuilder(128);

            if (string.length() <= 2) {
                continue;
            }

            boolean reset = false;
            int j = 0, k = 0;
            int longest = 0, tmpLongest = 0;

            while (true) {
                try {
                    sb.append(string.charAt(k));
                } catch (Exception e) {
                    break;
                }

                int matches = numMatches(string, sb);
                if (matches == 0) {
                    k++;
                    continue;
                } else if (matches == 1 && reset) {
                    // test if repeating pattern
                    if (repeatingPattern(sb)) {
                        // code the last case here:  "abbcabbcabbabbcabb"
                        if (!areCharsSame(sb, false)) {
                            int f = 0, g = 0;
                            f = k;
                            sb.append(string.charAt(k));
                            while (string.charAt(f + 1) == string.charAt(g)) {
                                sb.append(string.charAt(g));
                                f++;
                                g++;
                            }
                            tmpLongest = sb.length();
                        } else {
                            tmpLongest = 1;
                        }
                    } else {
                        if (tmpLongest > longest) {
                            longest = sb.length() - 1;
                        }
                        reset = false;
                        sb.delete(0, sb.length());
                        j++;
                        k = j;
                    }
                    continue;
                } else if (matches == 1 && !reset) {
                    k++;
                    continue;
                } else if (matches == 2 && !areCharsSame(sb, true)) {
                    tmpLongest = sb.length();
                    reset = true;
                } else {
                    // matches > 2
                    if (sb.length() >= 2) {
                        if (areCharsSame(sb, true)) {
                            tmpLongest = 1;
                            k++;
                            continue;
                        }
                    }
                    tmpLongest = sb.length();
                    if (matches == string.length()) {
                        longest = 1;
                        break;
                    }
                }
                // int ansDebug = Math.max(tmpLongest, longest);
                // System.out.printf("%d %d %d.%s\n", k, j, ansDebug, sb.toString());
                k++;
            }
            int answer = Math.max(tmpLongest, longest);
            System.out.println(answer);
        }
    }

    static boolean areCharsSame(StringBuilder sb, boolean manyMatches) {
        if (!manyMatches) {
            sb.setLength(sb.length() - 1);
            return isRepeating(sb.toString());
        } else {
            return isRepeating(sb.toString());
        }
    }

    static boolean isRepeating(String str) {
        if (str.length() <= 1) return false;
        if (str.charAt(0) == str.charAt(1)) {
            char char1 = str.charAt(0);
            String rep = String.valueOf(char1);
            rep = rep.repeat(str.length());
            return str.equals(rep);
        } else {
            return false;
        }
    }

    static boolean repeatingPattern(StringBuilder sb) {
        StringBuilder sbb = new StringBuilder();
        for (int i = 0; i < sb.length() / 2; i++) {
            sbb.append(sb.charAt(i));
        }
        String halfStr = sbb.toString();
        return halfStr.repeat(2).equals(sb.toString());
    }

    static int numMatches(String string, StringBuilder sb) {
        Pattern p = Pattern.compile(sb.toString());
        Matcher m = p.matcher(string);
        int cnt = 0;
        while (m.find()) {
            cnt++;
        }
        return cnt;
    }
}
