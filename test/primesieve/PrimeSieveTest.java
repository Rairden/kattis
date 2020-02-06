package primesieve;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeSieveTest {

    @Test
    void sieve() {
        assertEquals(0, PrimeSieve.sieve(1));
        assertEquals(4, PrimeSieve.sieve(9));
        assertEquals(9, PrimeSieve.sieve(25));
        assertEquals(25, PrimeSieve.sieve(100));
        assertEquals(78498, PrimeSieve.sieve(1000000));
        assertEquals(664579, PrimeSieve.sieve(10000000));
    }

    @Test
    void sieve2() {
        assertEquals(1229, PrimeSieve.sieve(9973));
    }

    @Test
    void sieve3() {
        assertEquals(1857859, PrimeSieve.sieve(30000000));
        assertEquals(1857921, PrimeSieve.sieve(30001000));
    }
}
