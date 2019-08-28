package haypoints;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HayPoints {

    public static void main(String[] args) {

        String input = "7 2\n" +
                "administer 100000\n" +
                "spending 200000\n" +
                "manage 50000\n" +
                "responsibility 25000\n" +
                "expertise 100\n" +
                "skill 50\n" +
                "money 75000\n" +
                "the incumbent will administer the spending of kindergarden milk money\n" +
                "and exercise responsibility for making change he or she will share\n" +
                "responsibility for the task of managing the money with the assistant\n" +
                "whose skill and expertise shall ensure the successful spending exercise\n" +
                ".\n" +
                "this individual must have the skill to perform a heart transplant and\n" +
                "expertise in rocket science\n" +
                ".\n";

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
