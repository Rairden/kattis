package conversationlog;

import lib.io.FastReader;

import java.io.FileNotFoundException;
import java.util.*;
import static conversationlog.ConversationLog.skipWords;

// https://open.kattis.com/problems/conversationlog

public class ConversationLog {

    static Set<String> skipWords = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder file = new StringBuilder("src/conversationlog/in2");
        FastReader io = new FastReader(file);
        int numCases = io.nextInt();

        var map = new HashMap<String, User>();
        for (int i = 0; i < numCases; i++) {
            String words = io.nextLine();
            String[] arr = words.split("\\s");

            var name = arr[0];
            var list = new ArrayList<>(Arrays.asList(arr).subList(1, arr.length));
            var user = new User(name, list);

            if (map.containsKey(name)) {
                map.get(name).words.addAll(list);
            } else {
                map.put(name, user);
            }
        }
        for (User user : map.values()) {
            user.uniqueWords = new HashSet<>(user.words);
        }

        var keyWords = new ArrayList<Match>();
        var keySet   = new HashSet<String>();
        for (User user : map.values()) {
            for (String uniqueWord : user.uniqueWords) {
                if (keySet.contains(uniqueWord) || skipWords.contains(uniqueWord)) continue;

                int numberOfMatches = user.allSetsContainWord(map, uniqueWord);
                if (numberOfMatches > 0) {
                    Match m = new Match(uniqueWord, numberOfMatches);
                    keyWords.add(m);
                    keySet.add(uniqueWord);
                }
            }
        }
        if (keyWords.size() == 0) {
            System.out.println("ALL CLEAR");
            return;
        }
        Collections.sort(keyWords);
        for (Match match : keyWords) {
            System.out.println(match.word);
        }
    }
}

class User {
    String name;
    List<String> words;
    Set<String> uniqueWords;

    public User(String name, List<String> words) {
        this.name = name;
        this.words = words;
    }

    int allSetsContainWord(Map<String, User> map, String uniqueWord) {
        Collection<User> values = map.values();
        for (User user : values) {
            if (!user.uniqueWords.contains(uniqueWord)) {
                skipWords.add(uniqueWord);
                return 0;
            }
        }

        int cnt = 0;
        for (User user : values) {
            for (String word : user.words) {
                if (word.equals(uniqueWord)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Match implements Comparable<Match> {
    String word;
    int numberOfMatches;

    public Match(String word, int numberOfMatches) {
        this.word = word;
        this.numberOfMatches = numberOfMatches;
    }

    @Override
    public int compareTo(Match o) {
        int i = o.numberOfMatches - this.numberOfMatches;
        if (i != 0) {
            return i;
        }
        return this.word.compareTo(o.word);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Match match = (Match) obj;
        return this.word.equals(match.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
