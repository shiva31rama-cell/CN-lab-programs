// CN Lab Experiment 11: Distance Vector Routing
// Repeated Bellman-Ford style updates produce stable routing costs.

import java.util.*;

public class DistanceVector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int INF = 1_000_000_000;

        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        int[][] distance = new int[n][n]; // Current distance vector tables.

        System.out.println(
            "Enter cost matrix (0 for same node, -1 for no direct link):"
        );

        for (int i = 0; i < n; i++) {           // Read every source row.
            for (int j = 0; j < n; j++) {       // Read every destination cost.
                int value = scanner.nextInt();
                if (i != j && value == -1) {
                    value = INF;                // Mark missing links as infinity.
                }
                distance[i][j] = value;
            }
        }

        boolean changed;

        do {
            changed = false;                    // Assume no table changes.

            for (int i = 0; i < n; i++) {       // Update node i.
                for (int j = 0; j < n; j++) {   // Try destination j.
                    for (int k = 0; k < n; k++) { // Try intermediate k.
                        if (distance[i][k] < INF && distance[k][j] < INF) {
                            int newCost = distance[i][k] + distance[k][j];

                            if (newCost < distance[i][j]) {
                                distance[i][j] = newCost;
                                changed = true; // A better route was found.
                            }
                        }
                    }
                }
            }
        } while (changed);                       // Repeat until stable.

        for (int i = 0; i < n; i++) {            // Print every routing table.
            System.out.println("\nRouting table for node " + i + ":");

            for (int j = 0; j < n; j++) {        // Print each destination.
                String value =
                    distance[i][j] >= INF ? "INF" : String.valueOf(distance[i][j]);
                System.out.println("Destination " + j + ": " + value);
            }
        }

        scanner.close();
    }
}
