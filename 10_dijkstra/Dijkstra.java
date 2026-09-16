// CN Lab Experiment 10: Dijkstra's Shortest Path Algorithm
// 0 means no direct edge; positive values are edge weights.

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int INF = 1_000_000_000;

        System.out.print("Enter number of vertices: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n]; // Store the adjacency matrix.

        System.out.println("Enter adjacency matrix (0 means no edge):");
        for (int i = 0; i < n; i++) {             // Read each row.
            for (int j = 0; j < n; j++) {         // Read each column.
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter source vertex (0-based): ");
        int source = scanner.nextInt();

        int[] distance = new int[n];              // Shortest known distances.
        boolean[] visited = new boolean[n];       // Finalized vertices.
        Arrays.fill(distance, INF);
        distance[source] = 0;

        for (int count = 0; count < n; count++) { // Finalize vertices one by one.
            int u = -1;
            int best = INF;

            for (int v = 0; v < n; v++) {         // Find nearest unvisited vertex.
                if (!visited[v] && distance[v] < best) {
                    best = distance[v];
                    u = v;
                }
            }

            if (u == -1) break;                   // Remaining vertices are unreachable.

            visited[u] = true;

            for (int v = 0; v < n; v++) {         // Relax all neighbors.
                if (graph[u][v] > 0 && !visited[v]) {
                    int newDistance = distance[u] + graph[u][v];
                    if (newDistance < distance[v]) {
                        distance[v] = newDistance;
                    }
                }
            }
        }

        System.out.println("Shortest distances from vertex " + source);
        for (int v = 0; v < n; v++) {             // Print final distances.
            System.out.println(v + " -> " +
                (distance[v] == INF ? "INF" : distance[v]));
        }

        scanner.close();
    }
}
