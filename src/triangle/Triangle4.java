package triangle;

import lib.kattio.Kattio;
import java.io.*;
import java.util.*;

public class Triangle4 {

    public static void main(String[] args) throws Exception {

        Kattio io = new Kattio(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("src/triangle/10k_onlyWholeNumber.txt"));
        Map<Integer, String> map = new HashMap<>();

        String str;
        int i = 0;
        while ((str = reader.readLine()) != null) {
            map.put(i, str);
            i++;
        }

        int key;
        int n = 1;
        while (io.hasMoreTokens()) {
            key = io.getInt();
            System.out.printf("Case %d: %s\n", n, map.get(key));
            n++;
        }
    }
}
