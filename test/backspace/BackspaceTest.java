package backspace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackspaceTest {

    @Test
    void backspace() {
        assertEquals("b", Backspace.backspace("a<bc<").toString());
        assertEquals("forritun", Backspace.backspace("foss<<rritun").toString());
        assertEquals("", Backspace.backspace("a<a<a<aa<<").toString());
    }

    @Test
    void backspace2() {
        assertEquals("a", Backspace.backspace("ab<<<a").toString());
        assertEquals("", Backspace.backspace("<<<<<<").toString());
        assertEquals("erik", Backspace.backspace("erik <<krairden<<<<<<<").toString());
    }
}
