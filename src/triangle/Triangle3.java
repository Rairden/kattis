package triangle;

import java.io.*;
import java.util.*;
import static triangle.Circumference.circumference;

public class Triangle3 {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("src/triangle/10k_onlyWholeNumber.txt"));
        Map<Integer, String> map = new HashMap<>();
        String str;
        int i = 0;
        while ((str = reader.readLine()) != null) {
            map.put(i, str);
            i++;
        }

        int iteration1 = 10001;
        for (int r = 0; r < iteration1; r++) {
            int numberOfDigits = circumference(r);
            System.out.println(numberOfDigits);
        }
    }
}
