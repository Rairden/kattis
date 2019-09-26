package triangle;

import java.math.BigDecimal;

public class Circumference {

    public static int circumference(int iter) {
        iter++;
        BigDecimal function = new BigDecimal("1.5");
        BigDecimal temp = new BigDecimal("2");

        for (int i = 0; i < iter; i++) {
            BigDecimal bd = temp.multiply(function);
            temp = bd;
            // System.out.println(temp);
        }
        String[] splitAtDecimal = temp.toString().split("\\.");
        return splitAtDecimal[0].length();
    }
}
