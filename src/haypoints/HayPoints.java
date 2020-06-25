package haypoints;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HayPoints {

    public static void main(String[] args) {

        String input = """
                7 2
                administer 100000
                spending 200000
                manage 50000
                responsibility 25000
                expertise 100
                skill 50
                money 75000
                the incumbent will administer the spending of kindergarden milk money
                and exercise responsibility for making change he or she will share
                responsibility for the task of managing the money with the assistant
                whose skill and expertise shall ensure the successful spending exercise
                .
                this individual must have the skill to perform a heart transplant and
                expertise in rocket science
                .
                """;

        Scanner scan = new Scanner(System.in);

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
