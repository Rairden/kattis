package simplicity;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simplicity {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(simplicity(str));
    }

    /** @return removed - the total number of chars removed */
    static int simplicity(String str) {
        if (str.length() <= 2) {
            return 0;
        } else if (str.length() == 3) {
            if (isRepeating(str)) {
                return 0;
            } else {
                return noDuplicates(str) ? 1 : 0;
            }
        } else {
            // length >= 4
            if (noDuplicates(str)) {
                return str.length() - 2;
            } else if (isRepeating(str)) {
                return 0;
            }

            // from here onwards:  non-repeating, 4+ chars  (e.g, aabb, aaab)
            // calc unique chars.  letter: l(1), e(2), t(2), r(1)     delete until list.size() == 2
            List<Chars> chars = findDuplicates(str);
            Collections.sort(chars);
            int removed = 0;
            for (Iterator<Chars> itr = chars.iterator(); itr.hasNext(); ) {
                if (chars.size() == 2) {
                    return 0;
                } else {
                    int cnt = chars.get(0).count;
                    chars.remove(0);
                    removed += cnt;
                    if (chars.size() == 2 || chars.size() == 1) {
                        return removed;
                    }
                }
            }
            return removed;
        }
    }

    static List<Chars> findDuplicates(String string) {
        List<Chars> duplicates = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            String ch = Character.toString(string.charAt(i));
            Chars chars = new Chars(ch, numMatches(string, ch));
            if (i == 0) {
                duplicates.add(chars);
            } else {
                if (!duplicates.contains(chars)) {
                    duplicates.add(chars);
                }
            }
        }
        return duplicates;
    }

    static boolean noDuplicates(String str) {
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }

    static boolean isRepeating(String str) {
        if (str.charAt(0) == str.charAt(1)) {
            String rep = Character.toString(str.charAt(0));
            rep = rep.repeat(str.length());
            return str.equals(rep);
        } else {
            return false;
        }
    }

    static int numMatches(String string, String ch) {
        Pattern p = Pattern.compile(ch);
        Matcher m = p.matcher(string);
        int cnt = 0;
        while (m.find()) {
            cnt++;
        }
        return cnt;
    }
}

class Chars implements Comparable<Chars> {
    String ch;
    int count;

    public Chars(String ch, int count) {
        this.ch = ch;
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Chars chars = (Chars) obj;
        return this.ch.equals(chars.ch);
    }

    @Override
    public int compareTo(Chars o) {
        int i = this.count - o.count;
        if (i != 0) {
            return i;
        }
        return this.count - o.count;
    }
}
