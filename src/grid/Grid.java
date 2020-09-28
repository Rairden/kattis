package grid;

import lib.io.FastReader;

import java.io.FileNotFoundException;
import java.util.*;

// https://open.kattis.com/problems/grid

public class Grid {

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder file = new StringBuilder("src/grid/in");
        FastReader io = new FastReader(file);

        int rows = io.nextInt();
        int cols = io.nextInt();
        int numVertex = rows * cols;

        Graph graph = new Graph(numVertex, rows, cols);

        int vertex = 0;
        for (int i = 0; i < rows; i++) {
            String line = io.nextLine();
            String[] digit = line.split("");

            for (int k = 0; k < cols; k++) {
                int hop = Integer.parseInt(digit[k]);
                Node node = new Node(vertex, hop);
                graph.nodes[i][k] = node;
                vertex++;
            }
        }

        vertex = 0;
        for (int i = 0; i < graph.nodes.length; i++) {
            for (int k = 0; k < graph.nodes[i].length; k++) {
                graph.adjList.add(new ArrayList<>());
                graph.getNeighbors(i, k, vertex);
                vertex++;
            }
        }

        Node start = graph.nodes[0][0];
        Node end = graph.nodes[rows - 1][cols - 1];

        List<Integer> path = graph.reconstructPath(start, end);
        System.out.println(path.size() - 1);
    }
}

class Node {
    int vertex;
    int hop;
    boolean visited;

    Node(int vertex, int hop) {
        this.vertex = vertex;
        this.hop = hop;
    }

    @Override
    public String toString() {
        return Integer.toString(vertex);
    }
}

class Graph {
    int V;
    Node[][] nodes;
    List<List<Node>> adjList;
    Queue<Node> q;
    Node[] prev;

    Graph(int vertex, int rows, int cols) {
        V       = vertex;
        nodes   = new Node[rows][cols];
        adjList = new ArrayList<>(V);
        q       = new LinkedList<>();
    }

    void bfs(Node start) {
        prev = new Node[V];
        q.add(start);
        start.visited = true;

        while (!q.isEmpty()) {
            Node node = q.remove();
            List<Node> neighbours = adjList.get(node.vertex);

            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    n.visited = true;
                    q.add(n);
                    prev[n.vertex] = node;
                }
            }
        }
    }

    List<Integer> reconstructPath(Node start, Node end) {
        bfs(start);
        List<Integer> path = new ArrayList<>();
        for (Node at = end; at != null; at = prev[at.vertex]) {
            path.add(at.vertex);
        }
        Collections.reverse(path);
        if (path.get(0) == start.vertex) return path;
        path.clear();
        return path;
    }

    void getNeighbors(int i, int k, int vertex) {
        int hop = nodes[i][k].hop;
        if (hop == 0) return;

        addUp(i, k, vertex, hop);
        addDown(i, k, vertex, hop);
        addLeft(i, k, vertex, hop);
        addRight(i, k, vertex, hop);
    }

    void addUp(int i, int k, int vertex, int hop) {
        // (row - 1, col)
        try {
            adjList.get(vertex).add(nodes[i - hop][k]);
        } catch (Exception ignore) {}
    }

    void addDown(int i, int k, int vertex, int hop) {
        // (row + 1, col)
        try {
            adjList.get(vertex).add(nodes[i + hop][k]);
        } catch (Exception ignore) {}
    }

    void addLeft(int i, int k, int vertex, int hop) {
        // (row, col - 1)
        try {
            adjList.get(vertex).add(nodes[i][k - hop]);
        } catch (Exception ignore) {}
    }

    void addRight(int i, int k, int vertex, int hop) {
        // (row, col + 1)
        try {
            adjList.get(vertex).add(nodes[i][k + hop]);
        } catch (Exception ignore) {}
    }
}
