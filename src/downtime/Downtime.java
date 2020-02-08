package downtime;

import lib.io.FastReader;

public class Downtime {

    public static void main(String[] args) {
        FastReader io = new FastReader();
        int request = io.nextInt();
        int rps = io.nextInt();
        int[] requests = new int[request];
        for (int i = 0; i < request; i++) {
            requests[i] = io.nextInt();
        }
        System.out.println(calcNumberOfServers(requests, rps));
    }

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