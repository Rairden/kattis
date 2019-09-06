package crackingrsa;

import lib.math.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrackingRSATest {

    @Test
    void findCandidate() {
        assertEquals(7, CrackingRSA.findCandidate(3, 20));
        assertEquals(35, CrackingRSA.findCandidate(11, 48));

        // n = 988027   p = 991   q = 997     e = 7       r = 986040
        assertEquals(140863, CrackingRSA.findCandidate(7, 986040));

        // n = 988027   p = 991   q = 997     e = 65537   r = 986040
        assertEquals(919313, CrackingRSA.findCandidate(65537, 986040));

        // n = 6012707  p = 2357    q = 2551    e = 3674911 r = 6007800  https://youtu.be/mddJvoloGy0?t=1654
        assertEquals(422191, CrackingRSA.findCandidate(3674911, 6007800));

        // n = 2623     p = 43      q = 61      e = 2111    r = 2520
        assertEquals(191, CrackingRSA.findCandidate(2111, 2520));

        // n = 14       p = 2       q = 7       e = 17      r = 60
        assertEquals(5, CrackingRSA.findCandidate(17, 6));

        // n = 10142789312725007     p = 100711409   q = 100711423  e = 5   r = 10142789111302176       // https://stackoverflow.com/questions/4078902/cracking-short-rsa-keys
        assertEquals(8114231289041741L, CrackingRSA.findCandidate(5, 10142789111302176L));
    }

    @Test
    void isPrime() {
        assertFalse(MyMath.isPrime(1));
        assertTrue(MyMath.isPrime(2));
        assertTrue(MyMath.isPrime(997));
        assertTrue(MyMath.isPrime(140863));
        assertTrue(MyMath.isPrime(919313));
        assertTrue(MyMath.isPrime(8114231289041741L));
    }

    @Test
    void gcd() {
        assertEquals(1, MyMath.gcd(8114231289041741L, 5));
    }
}
