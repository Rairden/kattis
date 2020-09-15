package variablearithmetic;

import lib.io.FastReader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

// https://open.kattis.com/problems/variablearithmetic

public class VariableArithmetic {

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder file = new StringBuilder("src/variablearithmetic/in");
        FastReader io = new FastReader(file);
        Map<String, Integer> vars = new HashMap<>();

        while (true) {
            String line = io.nextLine();
            if (line.equals("0")) break;

            String[] tok = line.split("\\s");
            String output = processLine(tok, vars);

            if (output.equals("assignment")) continue;

            // here output is "6". And maybe more:  "6 + width + depth"
            System.out.println(output);
        }
    }

    static boolean hasAnUndefinedVariable = false;

    // every line is a combination of four things: variable, number, +, =
    static String processLine(String[] line, Map<String, Integer> vars) {
        StringBuilder sb = new StringBuilder();
        hasAnUndefinedVariable = false;
        int sum = 0;

        try {
            if (line[1].equals("=")) {
                assignVariable(line, vars);
                return "assignment";
            }
        } catch (Exception ignored) {}

        for (String s : line) {
            if (s.equals("+")) continue;

            if (isDigit(s)) {
                sum += Integer.parseInt(s);
                continue;
            }

            // It's a variable.
            if (vars.get(s) == null) {
                sb.append(s).append(" + ");
                hasAnUndefinedVariable = true;
            } else {
                sum += vars.get(s);
            }
        }

        if (sum == 0) {
            if (hasAnUndefinedVariable) {
                sb.setLength(sb.length() - 3);
                return sb.toString();
            }
            return String.valueOf(sum);
        }

        if (!isDigit(sb.toString()) && !sb.toString().isEmpty()) {
            sb.setLength(sb.length() - 3);
            return sum + " + " + sb.toString();
        } else {
            return String.valueOf(sum);
        }
    }

    static void assignVariable(String[] s, Map<String, Integer> vars) {
        vars.put(s[0], Integer.parseInt(s[2]));
    }

    static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
