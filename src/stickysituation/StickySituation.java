package stickysituation;

import lib.io.FastReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://open.kattis.com/problems/stickysituation

public class StickySituation {

    public static void main(String[] args) {
        FastReader io = new FastReader(System.in);
        io.next();  // skip number of sticks

        String line = io.nextLine();
        String[] stick = line.split("\\s");

        List<Long> sticks = new ArrayList<>();
        for (String s : stick) {
            sticks.add(Long.parseLong(s));
        }

        Collections.sort(sticks);

        int start = 0;
        for (int i = 0; i < sticks.size() - 2; i++) {
            if (sticks.get(i) + sticks.get(i + 1) <= sticks.get(i + 2)) {
                start++;
            } else {
                break;
            }
        }

        if (sticks.size() - 1 - start < 2) {
            System.out.println("impossible");
            return;
        }
        if (sticks.get(start) + sticks.get(start + 1) > sticks.get(start + 2)) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
    }
}
