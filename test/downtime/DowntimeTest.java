package downtime;

import lib.io.FastReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DowntimeTest {

    static int[] fileToArr(FastReader io) {
        int requests = io.nextInt();
        int requestsPerSecond = io.nextInt();
        int[] request = new int[requests];
        for (int i = 0; i < requests; i++) {
            request[i] = io.nextInt();
        }
        return request;
    }
/*

    @Test
    void calcNumberOfServers1() throws FileNotFoundException {
        FastReader iop1 = new FastReader("src/downtime/in/in1.txt");
        int[] arr = fileToArr(iop1);
        assertEquals(1, Downtime.calcNumberOfServers(arr, 1));
    }
    @Test
    void calcNumberOfServers2() throws FileNotFoundException {
        FastReader iop2 = new FastReader("src/downtime/in/in2.txt");
        int[] arr2 = fileToArr(iop2);
        assertEquals(2, Downtime.calcNumberOfServers(arr2, 2));
    }
    @Test
    void calcNumberOfServers3() throws FileNotFoundException {
        FastReader iop3 = new FastReader("src/downtime/in/in3.txt");
        int[] arr3 = fileToArr(iop3);
        assertEquals(2, Downtime.calcNumberOfServers(arr3, 2));
    }
    @Test
    void calcNumberOfServers4() throws FileNotFoundException {
        FastReader iop4 = new FastReader("src/downtime/in/in4.txt");
        int[] arr4 = fileToArr(iop4);
        assertEquals(4, Downtime.calcNumberOfServers(arr4, 2));
    }
    @Test
    void calcNumberOfServers5() throws FileNotFoundException {
        FastReader iop5 = new FastReader("src/downtime/in/in5.txt");
        int[] arr5 = fileToArr(iop5);
        assertEquals(3, Downtime.calcNumberOfServers(arr5, 2));
    }
    @Test
    void calcNumberOfServers6() throws FileNotFoundException {
        FastReader iop6 = new FastReader("src/downtime/in/in6.txt");
        int[] arr6 = fileToArr(iop6);
        assertEquals(3, Downtime.calcNumberOfServers(arr6, 2));
    }
*/

}
