package guessthedatastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import static guessthedatastructure.DataStruct.*;
import static guessthedatastructure.Operation.*;

// https://open.kattis.com/problems/guessthedatastructure

class GuessTheDataStructure {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/guessthedatastructure/in");
        Scanner scan = new Scanner(file);
        GuessTheDataStructure.getInstance();

        while (scan.hasNextLine()) {
            sb.setLength(0);
            int numOperations = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < numOperations; i++) {
                sb.append(scan.nextLine()).append(" ");
            }
            DataStruct dst = calcStructure(sb);
            System.out.println(dst.name);
        }
    }

    static Stack<Integer> stack;
    static Queue<Integer> queue;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;
    static GuessTheDataStructure structs = null;

    private GuessTheDataStructure() {
        stack   = new Stack<>();
        queue   = new ArrayBlockingQueue<>(1000);
        pq      = new PriorityQueue<>(Collections.reverseOrder());
        sb      = new StringBuilder();
    }

    public static GuessTheDataStructure getInstance() {
        if (structs == null) {
            structs = new GuessTheDataStructure();
        }
        return structs;
    }

    static int[] getInts(StringBuilder line) {
        int[] cmds = new int[line.length() / 2];
        String[] strArr = line.toString().split("\\s");
        for (int i = 0; i < strArr.length; i++) {
            cmds[i] = Integer.parseInt(strArr[i]);
        }
        return cmds;
    }

    static DataStruct calcStructure(StringBuilder sb) {
        int[] cmd = getInts(sb);
        DataStruct ds = IMPOSSIBLE;

        if (stackTest(cmd)) {
            if (priorityQueueTest(cmd)) return NOT_SURE;
            if (queueTest(cmd)) return NOT_SURE;
            ds = IS_A_STACK;
        }
        if (queueTest(cmd)) {
            if (priorityQueueTest(cmd)) return NOT_SURE;
            ds = IS_A_QUEUE;
        }
        if (priorityQueueTest(cmd)) {
            if (ds == IS_A_STACK || ds == IS_A_QUEUE) return NOT_SURE;
            ds = IS_A_PRIO_QUEUE;
        }
        return ds;
    }

    // 1 2 1 1 2 1 2 2
    static boolean stackTest(int[] cmds) {

        for (int i = 0; i < cmds.length; i += 2) {
            if (cmds[i] == PUSH.id) {
                stack.push(cmds[i + 1]);
            } else if (cmds[i] == REMOVE.id) {
                if (stack.isEmpty()) return false;

                int topStack = cmds[i + 1];
                if (stack.peek() == topStack) {
                    stack.pop();
                } else {
                    stack.clear();
                    return false;
                }
            }
        }
        stack.clear();
        return true;
    }

    // 1 1 1 2 1 3 2 1 2 2 2 3
    static boolean queueTest(int[] cmds) {

        for (int i = 0; i < cmds.length; i += 2) {
            if (cmds[i] == PUSH.id) {
                queue.add(cmds[i + 1]);
            } else if (cmds[i] == REMOVE.id) {
                if (queue.isEmpty()) return false;

                int next = cmds[i + 1];
                if (queue.peek() == next) {
                    queue.remove();
                } else {
                    queue.clear();
                    return false;
                }
            }
        }
        queue.clear();
        return true;
    }

    // 1 2 1 5 1 1 1 3 2 5 1 4 2 4
    static boolean priorityQueueTest(int[] cmds) {

        for (int i = 0; i < cmds.length; i += 2) {
            if (cmds[i] == PUSH.id) {
                pq.add(cmds[i + 1]);
            } else if (cmds[i] == REMOVE.id) {
                if (pq.isEmpty()) return false;

                int next = cmds[i + 1];
                if (pq.peek() == next) {
                    pq.remove();
                } else {
                    pq.clear();
                    return false;
                }
            }
        }
        pq.clear();
        return true;
    }
}

enum DataStruct {
    IS_A_STACK("stack"), IS_A_QUEUE("queue"), IS_A_PRIO_QUEUE("priority queue"),
    NOT_SURE("not sure"), IMPOSSIBLE("impossible");

    public final String name;
    DataStruct(String name) {
        this.name = name;
    }
}

enum Operation {
    PUSH(1), REMOVE(2);

    public final int id;
    Operation(int id) {
        this.id = id;
    }
}
