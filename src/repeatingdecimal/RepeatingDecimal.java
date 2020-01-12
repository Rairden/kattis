package repeatingdecimal;

import lib.io.Kattio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepeatingDecimal {

    public static void main(String[] args) {

        Kattio io = new Kattio(System.in);

        while (io.hasMoreTokens()) {
            BigDecimal a = BigDecimal.valueOf(io.getDouble());
            BigDecimal b = BigDecimal.valueOf(io.getDouble());
            int c = io.getInt();

            System.out.println(divideAndTrim(a, b, c));
        }
    }

    static String divideAndTrim(BigDecimal a, BigDecimal b, int c) {
        BigDecimal res = a.divide(b, 10000, RoundingMode.HALF_UP);
        String[] strArr = res.toString().split("\\.");

        String fractionalTrim = strArr[1].substring(0, c);

        return strArr[0] + "." + fractionalTrim;
    }
}
