package repeatingdecimal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RepeatingDecimalTest {

    @Test
    void divideAndTrim() {
        BigDecimal a = BigDecimal.valueOf(3);
        BigDecimal b = BigDecimal.valueOf(7);
        int c = 10;
        assertEquals("0.4285714285", RepeatingDecimal.divideAndTrim(a, b, c));

        BigDecimal a2 = BigDecimal.valueOf(199);
        BigDecimal b2 = BigDecimal.valueOf(200);
        int c2 = 1;
        assertEquals("0.9", RepeatingDecimal.divideAndTrim(a2, b2, c2));

        BigDecimal a3 = BigDecimal.valueOf(9);
        BigDecimal b3 = BigDecimal.valueOf(35);
        int c3 = 25;
        assertEquals("0.2571428571428571428571428", RepeatingDecimal.divideAndTrim(a3, b3, c3));


        BigDecimal a4 = BigDecimal.valueOf(7);
        BigDecimal b4 = BigDecimal.valueOf(10);
        int c4 = 3;
        assertEquals("0.700", RepeatingDecimal.divideAndTrim(a4, b4, c4));

        // wolf = 9.57171514543631    You'll have a repeating decimal if the divisor is prime other than 2 or 5.
        // I also think if both numbers are coprime (gcf(x,y) = 1), then you also get an irrational number.
        BigDecimal a5 = BigDecimal.valueOf(9543);
        BigDecimal b5 = BigDecimal.valueOf(997);
        int c5 = 13;
        assertEquals("9.5717151454363", RepeatingDecimal.divideAndTrim(a5, b5, c5));
    }
}
