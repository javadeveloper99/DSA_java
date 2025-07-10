import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a_graph_basics {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraphs(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // vertex 0
        graph[0].add(new Edge(0, 1, 5));

        // vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 2));

    }

    // BFS traversal TC- O(V + E) where V is vertices and E is edges
    // Space Complexity O(V) for visited array and queue
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true; // Mark start node visited immediately

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!visited[e.dest]) {
                    q.add(e.dest);
                    visited[e.dest] = true; // Mark here to avoid duplicates
                }
            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraphs(graph, V);
        System.out.print("BFS: ");
        bfs(graph);
        System.out.print("DFS: ");
        boolean[] visited = new boolean[V];
        dfs(graph, 0, visited);
    }
}
