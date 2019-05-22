package keytocrypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void previous() {
        BoundedCounter counter = BoundedCounter.getInstance(25);
        int upperLimit = counter.upperLimit;

        if (counter.getValue() >= 0 && counter.getValue() <= upperLimit) {
            assert true;
        } else {
            assert false;
        }

        int end1 = 13;           // B - N = O    1 - 13 = 14
        counter.setValue(1);
        for (int k = 0; k < end1; k++) {
            counter.previous();
        }
        assertEquals(14, counter.getValue());

        int end2 = 14;           // A - O = M    0 - 14 = 12
        counter.setValue(0);
        for (int k = 0; k < end2; k++) {
            counter.previous();
        }
        assertEquals(12, counter.getValue());

        int end3 = 25;           // Y - Z = Z    24 - 25 = 25
        counter.setValue(24);
        for (int k = 0; k < end3; k++) {
            counter.previous();
        }
        assertEquals(25, counter.getValue());
    }
}
