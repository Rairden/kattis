package haypoints;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://open.kattis.com/problems/haypoints

public class HayPoints {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/haypoints/in");
        Scanner scan = new Scanner(file);

        int dictionarySize = scan.nextInt();
        int jobDescriptions = scan.nextInt();
        Map<String, Integer> job = new HashMap<>();
        int total = 0;

        for (int i = 0; i < dictionarySize; i++) {
            job.put(scan.next(), scan.nextInt());
        }

        for (int i = 0; i < jobDescriptions; i++) {
            while (scan.hasNext()) {
                String word = scan.next();
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
