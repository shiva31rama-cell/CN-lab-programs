// CN Lab Experiment 10: Dijkstra's Shortest Path Algorithm
// 0 means no direct edge; positive values are edge weights.

import java.util.Scanner;

public class Dijkstra {

    public static void main(String[] args) {

        // Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Ask for number of vertices
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        // Create adjacency matrix
        // graph[i][j] stores the edge weight from i to j
        int[][] graph = new int[n][n];

        // Read the adjacency matrix
        // 0 means there is no direct edge
        System.out.println("Enter adjacency matrix (0 = no edge):");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                graph[i][j] = sc.nextInt();
            }
        }

        // Ask for the starting/source vertex
        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();


        // distance[i] stores the shortest distance
        // from source to vertex i
        int[] distance = new int[n];

        // visited[i] tells whether vertex i is finalized
        boolean[] visited = new boolean[n];


        // Initially, assume every vertex is very far away
        // 999 means infinity (unreachable for now)
        for (int i = 0; i < n; i++) {
            distance[i] = 999;
        }


        // Distance from source to itself is always 0
        distance[source] = 0;


        // Repeat the process for all vertices
        for (int i = 0; i < n; i++) {


            // u will store the nearest unvisited vertex
            int u = -1;


            // Find the unvisited vertex
            // having the smallest distance
            for (int j = 0; j < n; j++) {

                if (!visited[j] &&
                    (u == -1 || distance[j] < distance[u])) {

                    u = j;
                }
            }


            // Mark the nearest vertex as visited
            // Its shortest distance is now finalized
            visited[u] = true;


            // Check all vertices connected to u
            for (int v = 0; v < n; v++) {


                // If there is an edge from u to v
                // and v is not already visited
                if (graph[u][v] != 0 && !visited[v]) {


                    // Calculate a new possible distance
                    //
                    // distance from source to u
                    // +
                    // edge weight from u to v
                    int newDistance =
                            distance[u] + graph[u][v];


                    // If the new distance is smaller
                    // update the shortest distance
                    if (newDistance < distance[v]) {

                        distance[v] = newDistance;
                    }
                }
            }
        }


        // Display the final shortest distances
        System.out.println("\nShortest distances from " + source + ":");


        // Print distance from source to every vertex
        for (int i = 0; i < n; i++) {

            System.out.println(
                    source + " -> " + i +
                    " = " + distance[i]
            );
        }


        // Close Scanner
        sc.close();
    }
}
