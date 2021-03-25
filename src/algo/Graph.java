package algo;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private LinkedList<Integer> adjList[];
    private boolean[] visited;

    public Graph(int vertices) {
        adjList = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    void DFS(int vertex) {
        visited[vertex] = true;

        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjList[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }



    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,3);

        g.DFS(1);
    }
}
