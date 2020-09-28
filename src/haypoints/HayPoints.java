package haypoints;

import lib.io.FastReader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://open.kattis.com/problems/haypoints

public class HayPoints {

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder file = new StringBuilder("src/haypoints/in");
        FastReader io = new FastReader(file);

        int dictionarySize = io.nextInt();
        int jobDescriptions = io.nextInt();
        Map<String, Integer> job = new HashMap<>();
        int total = 0;

        for (int i = 0; i < dictionarySize; i++) {
            job.put(io.next(), io.nextInt());
        }

        for (int i = 0; i < jobDescriptions; i++) {
            while (true) {
                String word = io.next();
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

    static int calculateSalary(StringBuilder word, Map<String, Integer> map) {
        int totalSalary = 0;

        for (String str : map.keySet()) {
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(word);

            int cnt = 0;
            while (m.find()) {
                cnt++;
            }
            totalSalary += map.get(str) * cnt;
        }
        return totalSalary;
    }
}
