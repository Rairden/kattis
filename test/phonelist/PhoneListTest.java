package phonelist;

import lib.io.FastReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneListTest {

    String in1 = """
            3
            911
            97625999
            91125426
            """;

    String in2 = """
            5
            113
            12340
            123440
            12345
            98346
            """;

    FastReader io1 = new FastReader(in1);
    FastReader io2 = new FastReader(in2);

    @Test
    void consistencyCheck() {
        assertFalse(PhoneList.consistencyCheck(io1));
        assertTrue(PhoneList.consistencyCheck(io2));
    }
}
