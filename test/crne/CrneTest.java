package crne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrneTest {

    @Test
    void maximizeShatter() {
        assertEquals(2, Crne.maximizeShatter(1));
        assertEquals(6, Crne.maximizeShatter(3));
        assertEquals(16, Crne.maximizeShatter(6));
        assertEquals(20, Crne.maximizeShatter(7));
        assertEquals(25, Crne.maximizeShatter(8));
    }

    // If you use doubles, you get a wrong answer above around 500M. Output is short by 1. The reason is because
    // double's largest integer value is 2^53 = 9e15. And the answers for this problem are bigger (2.5e17)
    // 2^53 = 9,007,199,254,740,992
    @Test
    void maximizeShatter3() {
        assertEquals(122500000700000001L, Crne.maximizeShatter(700000000));
        assertEquals(250000001000000001L, Crne.maximizeShatter(1000000000));
    }
}
