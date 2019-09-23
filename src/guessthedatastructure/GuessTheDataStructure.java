package guessthedatastructure;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import static guessthedatastructure.DataStruct.*;
import static guessthedatastructure.Operation.*;

class GuessTheDataStructure {

    public static void main(String[] args) {
        String full = "6\n1 1\n1 2\n1 3\n2 1\n2 2\n2 3\n6\n1 1\n1 2\n1 3\n2 3\n2 2\n2 1\n" +
                "2\n1 1\n2 2\n4\n1 2\n1 1\n2 1\n2 2\n7\n1 2\n1 5\n1 1\n1 3\n2 5\n1 4\n2 4\n1\n2 1\n";
        Scanner scan = new Scanner(full);
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

    public static Stack<Integer> stack;
    public static Queue<Integer> queue;
    public static PriorityQueue<Integer> pq;
    public static StringBuilder sb;
    public static GuessTheDataStructure structs = null;

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
             if (priorityQueueTest(cmd)) {
                return NOT_SURE;
             } else if (queueTest(cmd)) {
                 return NOT_SURE;
             }
            ds = IS_A_STACK;
        }
        if (queueTest(cmd)) {
            if (priorityQueueTest(cmd)) {
                return NOT_SURE;
            }
            ds = IS_A_QUEUE;
        }
        if (priorityQueueTest(cmd)) {
            if (ds == IS_A_STACK || ds == IS_A_QUEUE) {
                return NOT_SURE;
            }
            ds = IS_A_PRIO_QUEUE;
        }
        return ds;
    }

    static boolean stackTest(int[] cmds) {
        // 1 2 1 1 2 1 2 2
        GuessTheDataStructure.getInstance();
        for (int i = 0; i < cmds.length; i += 2) {
            if (cmds[i] == PUSH.id) {
                stack.push(cmds[i + 1]);
            } else if (cmds[i] == REMOVE.id) {
                if (stack.isEmpty()) {
                    return false;
                }
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

    static boolean queueTest(int[] cmds) {
        // 1 1 1 2 1 3 2 1 2 2 2 3
        GuessTheDataStructure.getInstance();
        for (int i = 0; i < cmds.length; i += 2) {
            if (cmds[i] == PUSH.id) {
                queue.add(cmds[i + 1]);
            } else if (cmds[i] == REMOVE.id) {
                if (queue.isEmpty()) {
                    return false;
                }
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

    static boolean priorityQueueTest(int[] cmds) {
        // 1 2 1 5 1 1 1 3 2 5 1 4 2 4
        GuessTheDataStructure.getInstance();
        for (int i = 0; i < cmds.length; i += 2) {
            if (cmds[i] == PUSH.id) {
                pq.add(cmds[i + 1]);
            } else if (cmds[i] == REMOVE.id) {
                if (pq.isEmpty()) {
                    return false;
                }
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
