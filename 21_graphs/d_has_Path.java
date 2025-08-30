import java.util.ArrayList;

public class d_has_Path {

    static class Edge {
        int st;
        int dest;

        public Edge(int s, int d) {
            this.st = s;
            this.dest = d;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int V) {

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

    }

    public static boolean hasPath(ArrayList<Edge> graph[], int curr, int target, boolean vis[]) {
        if (curr == target) {
            return true;
        }
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                if (hasPath(graph, e.dest, target, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);
        System.out.println(hasPath(graph, 0, 8, new boolean[V]));
    }
}
