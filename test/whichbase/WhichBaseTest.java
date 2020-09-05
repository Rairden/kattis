package whichbase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhichBaseTest {

    @Test
    void convertToDecimal() {
        assertEquals("668", WhichBase.convertToDecimal("1234", 8));
        assertEquals("4660", WhichBase.convertToDecimal("1234", 16));

        assertEquals("0", WhichBase.convertToDecimal("9", 8));
        assertEquals("9", WhichBase.convertToDecimal("9", 16));

        assertEquals("1023", WhichBase.convertToDecimal("1777", 8));
        assertEquals("6007", WhichBase.convertToDecimal("1777", 16));

        assertEquals("0", WhichBase.convertToDecimal("129", 8));
        assertEquals("297", WhichBase.convertToDecimal("129", 16));
    }

    @Test
    void convertToDecimal2() {
        assertEquals("2097151", WhichBase.convertToDecimal("7777777", 8));
        assertEquals("125269879", WhichBase.convertToDecimal("7777777", 16));

        assertEquals("0", WhichBase.convertToDecimal("9999999", 8));
        assertEquals("161061273", WhichBase.convertToDecimal("9999999", 16));
    }
}
