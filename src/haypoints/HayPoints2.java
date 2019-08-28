package haypoints;

import kattio.Kattio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HayPoints2 {

    public static void main(String[] args) throws IOException {
        Kattio scan = new Kattio(System.in);
        Tokenizer2 token = Tokenizer2.getInstance();
        int dictionarySize = scan.getInt();
        int jobDescriptions = scan.getInt();

        Map<String, Integer> responsibilities = new HashMap<>();

        for (int i = 0; i < dictionarySize; i++) {
            responsibilities.put(scan.getWord(), scan.getInt());
        }

        for (int i = 0; i < jobDescriptions; i++) {
            while (scan.hasMoreTokens()) {
                String line = scan.getWord();
                if (line.equals(".")) {
                    break;
                }
                token.stringBuilder.append(line).append(" ");
            }
            System.out.println(calculateSalary(token, responsibilities));
            token.stringBuilder.setLength(0);
        }
        scan.close();
    }

    static int calculateSalary(Tokenizer2 token, Map<String, Integer> map) {
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

class Tokenizer2 {
    static Tokenizer2 tokenizer = null;
    StringBuilder stringBuilder;

    private Tokenizer2() {
        stringBuilder = new StringBuilder();
    }

    static Tokenizer2 getInstance() {
        if (tokenizer == null) {
            tokenizer = new Tokenizer2();
        }
        return tokenizer;
    }
}
