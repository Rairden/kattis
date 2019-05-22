package keytocrypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void previous() {
        // B - N = O    1 - 13 = 14
        int result = Main.previous(25, 1, 13);
        assertEquals(14, result);

        // A - O = M    0 - 14 = 12
        int result2 = Main.previous(25, 0, 14);
        assertEquals(12, result2);

        // Y - Z = Z    24 - 25 = 25
        int result3 = Main.previous(25, 24, 25);
        assertEquals(25, Main.previous(25, 24, 25));
    }
}
