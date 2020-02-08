package pascal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PascalTest {

    @Test
    void pascal() {
        assertEquals(0, Pascal.pascal(1));
        assertEquals(5, Pascal.pascal(10));
        assertEquals(18, Pascal.pascal(27));
    }

    @Test
    void pascal2() {
        assertEquals(18, Pascal.pascal(27));
    }

    @Test
    void pascal3() {
        assertEquals(435000000, Pascal.pascal(870000000));
        assertEquals(949999990, Pascal.pascal(949999993));
    }
}
