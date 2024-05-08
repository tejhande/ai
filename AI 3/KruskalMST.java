import java.util.*;

class KruskalMST {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public String toString() {
            return "(" + src + ", " + dest + ", " + weight + ")";
        }
    }

    static class DisjointSet {
        private static Map<Integer, Integer> parent = new HashMap<>();
        private static Map<Integer, Integer> rank = new HashMap<>();

        public static void makeSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.put(i, i);
                rank.put(i, 0);
            }
        }

        private static int find(int k) {
            if (parent.get(k) == k) {
                return k;
            }
            parent.put(k, find(parent.get(k)));
            return parent.get(k);
        }

        private static void union(int a, int b) {
            int x = find(a);
            int y = find(b);

            if (rank.get(x) < rank.get(y)) {
                parent.put(x, y);
            } else if (rank.get(x) > rank.get(y)) {
                parent.put(y, x);
            } else {
                parent.put(y, x);
                rank.put(x, rank.get(x) + 1);
            }
        }

        public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
            List<Edge> MST = new ArrayList<>();
            DisjointSet.makeSet(n);

            if (edges.size() < n - 1) {
                System.out.println("Not enough edges to form a Minimum Spanning Tree.");
                return MST;
            }

            Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

            for (Edge edge : edges) {
                int x = DisjointSet.find(edge.src);
                int y = DisjointSet.find(edge.dest);

                if (x != y) {
                    MST.add(edge);
                    DisjointSet.union(x, y);

                    if (MST.size() == n - 1) {
                        break;
                    }
                }
            }

            return MST;
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 7), new Edge(1, 2, 8), new Edge(0, 3, 5),
                new Edge(1, 3, 9), new Edge(1, 4, 7), new Edge(2, 4, 5),
                new Edge(3, 4, 15), new Edge(3, 5, 6), new Edge(4, 5, 8),
                new Edge(4, 6, 9), new Edge(5, 6, 11));
        int n = 7;

        List<Edge> mst = DisjointSet.runKruskalAlgorithm(edges, n);
        System.out.println("Minimum Spanning Tree: " + mst);
    }
}