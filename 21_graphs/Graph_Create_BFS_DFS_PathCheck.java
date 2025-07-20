import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Graph_Create_BFS_DFS_PathCheck {

    // ---------- Edge class ----------
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // ---------- Create Graph ----------
    /**
     * Create a graph with some fixed and random edges.
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Fixed edges
        if (V > 1)
            graph[0].add(new Edge(0, 1, 1));
        if (V > 2)
            graph[1].add(new Edge(1, 2, 1));
        if (V > 3)
            graph[2].add(new Edge(2, 3, 1));
        if (V > 4)
            graph[3].add(new Edge(3, 4, 1));

        // Random additional edges
        Random rand = new Random();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < 2; j++) { // fewer random edges to keep it simple
                int dest = rand.nextInt(V);
                if (dest != i) {
                    graph[i].add(new Edge(i, dest, rand.nextInt(10) + 1));
                }
            }
        }
        return graph;
    }

    // ---------- BFS traversal ----------
    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsComponent(graph, visited, i);
            }
        }
    }

    public static void bfsComponent(ArrayList<Edge>[] graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (Edge e : graph[curr]) {
                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // ---------- DFS traversal ----------
    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V) (due to recursion stack)
     */
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsComponent(graph, i, visited);
                System.out.println();
            }
        }
    }

    public static void dfsComponent(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                dfsComponent(graph, e.dest, visited);
            }
        }
    }

    // ---------- Check if path exists ----------
    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest)
            return true;

        visited[src] = true;

        for (Edge e : graph[src]) {
            if (!visited[e.dest]) {
                if (hasPath(graph, e.dest, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // cyclic check using DFS

    public static boolean DetectCycleDFS(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (DetectCycleDFSUtil(graph, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;

    }

    // Detect cycle in an directed graph using DFS
    public static boolean detectCycleDirected(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] recStack = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleDirectedUtil(graph, i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleDirectedUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited,
            boolean[] recStack) {
        visited[curr] = true;
        recStack[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                if (detectCycleDirectedUtil(graph, e.dest, visited, recStack)) {
                    return true;
                }
            } else if (recStack[e.dest]) {
                return true; // back edge found → cycle
            }
        }

        recStack[curr] = false; // remove from recursion stack before returning
        return false;
    }

    /**
     * Detect cycle in an undirected graph using DFS.
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    // undirected graph cycle detection using DFS
    public static boolean DetectCycleDFSUtil(ArrayList<Edge> graph[], boolean visited[], int curr, int parent) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest] && DetectCycleDFSUtil(graph, visited, e.dest, curr)) {

                return true;

            } else if (e.dest != parent && visited[e.dest]) {
                return true; // cycle detected
            }
        }
        return false;
    }

    public static void printAllPathe(ArrayList<Edge> graph[], boolean visited[], int curr, String path, int tar) {
        if (curr == tar) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                visited[curr] = true;
                printAllPathe(graph, visited, e.dest, path + e.dest, tar);
                visited[curr] = false;
            }
        }
    }
    // TC - O(V+E)
    // SC -O(V)
    // acyclic always bipartite
    public static boolean bipartiteCheck(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;// yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.dest] == -1) {
                            int nextCol = (col[curr] == 0) ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }else if(col[e.dest]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = createGraph(V);

        System.out.println("BFS traversal (all components):");
        bfs(graph);

        System.out.println("DFS traversal (all components):");
        dfs(graph);

        int src = 0, dest = 4;
        boolean pathExists = hasPath(graph, src, dest, new boolean[V]);
        System.out.println("\nPath exists from " + src + " to " + dest + ": " + pathExists);

        System.out.println("\nDetect Cycle using DFS: " + DetectCycleDFS(graph));
        int srcc = 0;
        int tar = 4;
        printAllPathe(graph, new boolean[V], srcc, "0", tar);

        System.out.println(bipartiteCheck(graph));
    }
}
