package guessthedatastructure;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuessTheDataStructureTest {

    String full = "6\n1 1\n1 2\n1 3\n2 1\n2 2\n2 3\n6\n1 1\n1 2\n1 3\n2 3\n2 2\n2 1\n" +
            "2\n1 1\n2 2\n4\n1 2\n1 1\n2 1\n2 2\n" +
            "7\n1 2\n1 5\n1 1\n1 3\n2 5\n1 4\n2 4\n1\n2 1\n";
    StringBuilder q1 = new StringBuilder("1 1 1 2 1 3 2 1 2 2 2 3 ");
    StringBuilder ns = new StringBuilder("1 1 1 2 1 3 2 3 2 2 2 1 ");
    StringBuilder i1 = new StringBuilder("1 1 2 2 ");
    StringBuilder s4 = new StringBuilder("1 2 1 1 2 1 2 2 ");
    StringBuilder pq = new StringBuilder("1 2 1 5 1 1 1 3 2 5 1 4 2 4 ");
    StringBuilder i2 = new StringBuilder("2 1 ");
    int[] q = {1, 1, 1, 2, 1, 3, 2, 1, 2, 2, 2, 3};
    int[] s = {1, 2, 1, 1, 2, 1, 2, 2};
    int[] pq5 = {1, 2, 1, 5, 1, 1, 1, 3, 2, 5, 1, 4, 2, 4};
    int[] ns2 = {1, 1, 1, 2, 1, 3, 2, 3, 2, 2, 2, 1};
    int[] Q_P_notS = {1, 5, 1, 3, 2, 5};
    int[] impossible = {1, 1, 2, 1, 2, 1};

    @Test
    void stackTest() {
        assertFalse(GuessTheDataStructure.stackTest(q));
        assertTrue(GuessTheDataStructure.stackTest(s));
        assertTrue(GuessTheDataStructure.stackTest(ns2));
        assertFalse(GuessTheDataStructure.stackTest(Q_P_notS));
        assertFalse(GuessTheDataStructure.stackTest(impossible));
    }

    @Test
    void queueTest() {
        assertTrue(GuessTheDataStructure.queueTest(q));
        assertFalse(GuessTheDataStructure.queueTest(s));
        assertFalse(GuessTheDataStructure.queueTest(ns2));
        assertTrue(GuessTheDataStructure.queueTest(Q_P_notS));
        assertFalse(GuessTheDataStructure.queueTest(impossible));
    }

    @Test
    void priorityQueueTest() {
        assertFalse(GuessTheDataStructure.priorityQueueTest(q));
        assertFalse(GuessTheDataStructure.priorityQueueTest(s));
        assertTrue(GuessTheDataStructure.priorityQueueTest(pq5));
        assertTrue(GuessTheDataStructure.priorityQueueTest(ns2));
        assertTrue(GuessTheDataStructure.priorityQueueTest(Q_P_notS));
        assertFalse(GuessTheDataStructure.priorityQueueTest(impossible));
    }

    @Test
    void getInts() {
        assertArrayEquals(q, GuessTheDataStructure.getInts(q1));
        assertArrayEquals(s, GuessTheDataStructure.getInts(s4));
        assertArrayEquals(pq5, GuessTheDataStructure.getInts(pq));
    }

    @Test
    void calcStructure() {
        assertEquals("queue", GuessTheDataStructure.calcStructure(q1).name);
        assertEquals("not sure", GuessTheDataStructure.calcStructure(ns).name);
        assertEquals("impossible", GuessTheDataStructure.calcStructure(i1).name);
        assertEquals("stack", GuessTheDataStructure.calcStructure(s4).name);
        assertEquals("priority queue", GuessTheDataStructure.calcStructure(pq).name);
        assertEquals("impossible", GuessTheDataStructure.calcStructure(i2).name);
    }
}
