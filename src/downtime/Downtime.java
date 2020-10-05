package downtime;

import lib.io.FastReader;

import java.io.FileNotFoundException;

// https://open.kattis.com/problems/downtime

public class Downtime {

    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder file = new StringBuilder("src/downtime/in");
        FastReader io = new FastReader(file);
        int request = io.nextInt();
        int rps = io.nextInt();
        int[] requests = new int[request];
        for (int i = 0; i < request; i++) {
            requests[i] = io.nextInt();
        }
        System.out.println(calcNumberOfServers(requests, rps));
    }

    // this produces a wrong answer
    static int calcNumberOfServers(int[] requests, int rps) {
        prevBase = requests[0];
        for (int i = 0; i < requests.length; i++) {
            int curr = 0;
            if (i == 0) {
                i = rps;
                curr = requests[i];
                if (curr >= requests[i - 1] + PROC_TIME) {
                    for (int k = 0; k < 3; k++) {

                    }
                    if (curr >= requests[i - rps] + PROC_TIME) {
                        prevBase = curr;
                        continue;
                    } else {
                        // prevBase = requests[i];
                        serverSize++;
                    }
                }
            } else {
                curr = requests[i];
                if (curr >= prevBase + PROC_TIME) {
                    prevBase = requests[i - rps];
                    continue;
                } else {
                    serverSize++;
                }
            }
        }
        return serverSize;
    }
    static int prevBase     = 0;
    static int serverSize   = 1;
    static int PROC_TIME    = 1000;

}
