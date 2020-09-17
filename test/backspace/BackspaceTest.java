package backspace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackspaceTest {

    @Test
    void backspace() {
        assertEquals("b", Backspace.backspace("a<bc<").toString());
        assertEquals("forritun", Backspace.backspace("foss<<rritun").toString());
        assertEquals("", Backspace.backspace("a<b<c<de<<").toString());
    }

    @Test
    void backspace2() {
        assertEquals("a", Backspace.backspace("ab<<<a").toString());
        assertEquals("a", Backspace.backspace("<<<<<<abc<<").toString());
        assertEquals("erik", Backspace.backspace("erika<<krairden<<<<<<<").toString());
        assertEquals("", Backspace.backspace("").toString());
        assertEquals("abc", Backspace.backspace("abc").toString());
        assertEquals("d", Backspace.backspace("c<def<ghi<<<<").toString());
    }
}
