package irepeatmyself;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IRepeatMyselfTest {

    @Test
    void areCharsSame() {
    }

    @Test
    void isRepeating() {
        assertFalse(IRepeatMyself.isRepeating(""));
        assertFalse(IRepeatMyself.isRepeating("sdfsdf"));
        assertFalse(IRepeatMyself.isRepeating("a"));
        assertTrue(IRepeatMyself.isRepeating("bb"));
        assertTrue(IRepeatMyself.isRepeating("ccc"));
    }

    @Test
    void repeatingPattern() {
        assertFalse(IRepeatMyself.repeatingPattern(new StringBuilder("aabb")));
        assertTrue(IRepeatMyself.repeatingPattern(new StringBuilder("abbcabbc")));
        assertTrue(IRepeatMyself.repeatingPattern(new StringBuilder("abaaba")));
        // assertTrue(IRepeatMyself.repeatingPattern(new StringBuilder("abbc abbc")));
        // assertTrue(IRepeatMyself.repeatingPattern(new StringBuilder("aba aba")));
        // assertFalse(IRepeatMyself.repeatingPattern(new StringBuilder("")));
    }

    @Test
    void numMatches() {
    }
}
