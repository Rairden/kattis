package haypoints;

import lib.kattio.Kattio;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HayPoints2 {

    public static void main(String[] args) {
        Kattio scan = new Kattio(System.in);
        int dictionarySize = scan.getInt();
        int jobDescriptions = scan.getInt();
        Map<String, Integer> job = new HashMap<>();
        int total = 0;

        for (int i = 0; i < dictionarySize; i++) {
            job.put(scan.getWord(), scan.getInt());
        }

        for (int i = 0; i < jobDescriptions; i++) {
            while (scan.hasMoreTokens()) {
                String word = scan.getWord();
                if (word.equals(".")) {
                    System.out.println(total);
                    total = 0;
                    break;
                }
                if (job.containsKey(word)) {
                    total += job.get(word);
                }
            }
        }
        scan.close();
    }

    static int calculateSalary(Tokenizer token, Map<String, Integer> map) {
        String string = token.stringBuilder.toString();
        int totalSalary = 0;

        for (String str : map.keySet()) {
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(string);

            int cnt = 0;
            while (m.find()) {
                cnt++;
            }
            totalSalary += map.get(str) * cnt;
        }
        return totalSalary;
    }
}
