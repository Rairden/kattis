package weakvertices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://open.kattis.com/problems/weakvertices

public class WeakVertices {

    public static void main(String[] args) {

        String in = """
                9
                0 1 1 1 0 0 0 0 0
                1 0 0 0 0 0 1 0 0
                1 0 0 1 0 1 0 0 0
                1 0 1 0 0 1 1 0 0
                0 0 0 0 0 0 1 1 0
                0 0 1 1 0 0 0 0 0
                0 1 0 1 1 0 0 1 0
                0 0 0 0 1 0 1 0 1
                0 0 0 0 0 0 0 1 0
                1
                0
                -1
                """;

        Scanner scan = new Scanner(in);
        TempList vertex = TempList.getInstance();

        while (scan.hasNextLine()) {
            int[][] arr = populateMatrix(scan);

            for (int i = 0; i < arr.length; i++) {
                getNeighbors(arr, i);     // the neighbors of 0 are (1, 2, 3)

                if (isWeakVertex(arr)) {
                    vertex.weakVertices.add(i);
                }
                vertex.neighbors.clear();
            }
            System.out.println(printWeakVertices());
            vertex.weakVertices.clear();
        }
    }

    public static void getNeighbors(int[][] arr, int row) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[row][i] == 1) {
                TempList.vertex.neighbors.add(i);
            }
        }
    }

    public static int[][] populateMatrix(Scanner scan) {
        int iter = scan.nextInt();
        if (iter == -1) {
            System.exit(0);
        }
        scan.nextLine();
        int[][] arr = new int[iter][iter];

        for (int i = 0; i < iter; i++) {
            for (int j = 0; i < iter; j++) {
                String[] strArr = scan.nextLine().split("\\s");

                for (int k = 0; k < strArr.length; k++) {
                    arr[j][k] = Integer.parseInt(strArr[k]);
                }
                i++;
            }
        }
        return arr;
    }

    public static boolean isWeakVertex(int[][] arr) {
        for (Integer x : TempList.vertex.neighbors) {
            if (arr[x][x] == 1) {
                return false;
            }
            for (Integer y : TempList.vertex.neighbors) {
                if (arr[x][y] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static StringBuilder printWeakVertices() {
        StringBuilder str = new StringBuilder();
        for (Integer weakVertex : TempList.vertex.weakVertices) {
            str.append(weakVertex);
            str.append(" ");
        }
        return str;
    }
}

class TempList {
    static TempList vertex = null;
    List<Integer> neighbors;
    List<Integer> weakVertices;

    private TempList() {
        neighbors = new ArrayList<>();
        weakVertices = new ArrayList<>();
    }

    static TempList getInstance() {
        if (vertex == null) {
            vertex = new TempList();
        }
        return vertex;
    }
}
