package simplicity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplicityTest {

    @Test
    void simplicity() {
        assertEquals(4, Simplicity.simplicity("aaaaaabbbbbccccdddeef"));
        assertEquals(1, Simplicity.simplicity("abc"));
        assertEquals(0, Simplicity.simplicity("abb"));
        assertEquals(2, Simplicity.simplicity("abcd"));
        assertEquals(0, Simplicity.simplicity("aabb"));
        assertEquals(0, Simplicity.simplicity("aaab"));
        assertEquals(1, Simplicity.simplicity("abcc"));
        assertEquals(2, Simplicity.simplicity("letter"));
        assertEquals(4, Simplicity.simplicity("string"));
        assertEquals(1, Simplicity.simplicity("aaaaaaaaaaaaaaaaaabc"));
        assertEquals(13, Simplicity.simplicity("uncopyrightable"));
        assertEquals(12, Simplicity.simplicity("ambidextrously"));
        assertEquals(1, Simplicity.simplicity("assesses"));
        assertEquals(2, Simplicity.simplicity("assassins"));
    }

    @Test
    void noDuplicates() {
        assertTrue(Simplicity.noDuplicates("e"));
        assertTrue(Simplicity.noDuplicates("erik"));
        assertTrue(Simplicity.noDuplicates("uncopyrightable"));
        assertTrue(Simplicity.noDuplicates("ambidextrously"));
        assertTrue(Simplicity.noDuplicates("abcdefghijklmnopqrstuvwxyz"));
        assertFalse(Simplicity.noDuplicates("abb"));
    }
}
