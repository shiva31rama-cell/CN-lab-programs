// CN Lab Experiment 6: Go-Back-N Sliding Window Protocol
// Simple console simulation.

import java.util.Scanner;

public class GoBackN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int total = scanner.nextInt(); // Total frames.

        System.out.print("Enter window size: ");
        int window = scanner.nextInt(); // Number of frames per window.

        System.out.print("Enter lost frame number (0 for none): ");
        int lost = scanner.nextInt(); // Frame selected for simulated loss.

        int base = 1; // First unacknowledged frame.

        while (base <= total) { // Continue until every frame is delivered.
            int end = Math.min(base + window - 1, total); // Last frame in window.
            System.out.println("Sending frames " + base + " to " + end);

            if (lost >= base && lost <= end) { // Check for the simulated loss.
                System.out.println(
                    "Frame " + lost + " lost -> retransmit from frame " + lost
                );
                base = lost; // Go back to the lost frame.
                lost = 0;    // Assume retransmission succeeds.
            } else {
                System.out.println("ACK received for frames " + base + " to " + end);
                base = end + 1; // Move to the next window.
            }
        }

        System.out.println("All frames delivered successfully.");
        scanner.close();
    }
}
