// CN Lab Experiment 12: Broadcast Tree
// BFS is used to create a simple broadcast/spanning tree.

import java.util.*;

public class BroadcastTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of hosts: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n]; // Store host connectivity.

        System.out.println("Enter adjacency matrix (0 = no link):");
        for (int i = 0; i < n; i++) {             // Read each matrix row.
            for (int j = 0; j < n; j++) {         // Read each matrix column.
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter source host (0-based): ");
        int source = scanner.nextInt();

        boolean[] visited = new boolean[n];       // Track hosts already visited.
        Queue<Integer> queue = new LinkedList<>(); // BFS queue.
        List<String> treeEdges = new ArrayList<>(); // Store tree links.

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {                // Process the BFS queue.
            int current = queue.remove();         // Get the next host.

            for (int neighbor = 0; neighbor < n; neighbor++) { // Check neighbors.
                if (graph[current][neighbor] != 0 && !visited[neighbor]) {
                    visited[neighbor] = true;     // Mark neighbor as included.
                    queue.add(neighbor);           // Process it later.
                    treeEdges.add(current + " -> " + neighbor); // Add tree edge.
                }
            }
        }

        System.out.println("Broadcast tree edges:");
        for (String edge : treeEdges) {           // Print all tree edges.
            System.out.println(edge);
        }

        scanner.close();
    }
}
