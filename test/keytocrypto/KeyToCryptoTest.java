package keytocrypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyToCryptoTest {

    @Test
    void previous() {
        // B - N = O    1 - 13 = 14
        int result1 = KeyToCrypto.previous(25, 1, 13);
        assertEquals(14, result1);

        // A - O = M    0 - 14 = 12
        int result2 = KeyToCrypto.previous(25, 0, 14);
        assertEquals(12, result2);

        // Y - Z = Z    24 - 25 = 25
        int result3 = KeyToCrypto.previous(25, 24, 25);
        assertEquals(25, result3);
    }
}
