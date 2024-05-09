// Program 1 : Implement depth first search algorithm,
// Use an undirected graph and develop a recursive algorithm for searching all the vertices of
// a graph or tree data structure

import java.util.LinkedList;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.AddEdge(1, 2);
        g.AddEdge(1, 5);
        g.AddEdge(2, 3);
        g.AddEdge(2, 5);
        g.AddEdge(3, 4);
        g.AddEdge(4, 5);
        g.AddEdge(4, 6);
        g.AddEdge(5, 6);
        g.DFS();
    }
}

class Graph {
    private int NodeNumber;
    private LinkedList<Integer>[] AdjacentNodes;

    @SuppressWarnings("unchecked")
    Graph(int V) {
        AdjacentNodes = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < AdjacentNodes.length; i++) {
            AdjacentNodes[i] = new LinkedList<>();
        }
        NodeNumber = V;
    }

    public void AddEdge(int v, int w) {
        if (v >= 0 && v < NodeNumber && w >= 0 && w < NodeNumber) {
            AdjacentNodes[v].add(w);
        } else {
            System.out.println("Invalid vertices: " + v + ", " + w);
        }
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println("visiting " + v);
        Iterator<Integer> i = AdjacentNodes[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public void DFS() {
        System.out.println("\nDepth First Search Implementation Is:");
        boolean visited[] = new boolean[NodeNumber];
        for (int i = 0; i < NodeNumber; ++i) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }
}