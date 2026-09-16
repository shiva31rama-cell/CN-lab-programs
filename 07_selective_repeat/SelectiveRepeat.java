// CN Lab Experiment 7: Selective Repeat Sliding Window Protocol
// Only the lost frame is retransmitted.

import java.util.Scanner;

public class SelectiveRepeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int total = scanner.nextInt();

        System.out.print("Enter window size: ");
        int window = scanner.nextInt();

        System.out.print("Enter lost frame number (0 for none): ");
        int lost = scanner.nextInt();

        int base = 1; // First frame in the current window.

        while (base <= total) { // Process all windows.
            int end = Math.min(base + window - 1, total);
            System.out.println("Sending frames " + base + " to " + end);

            if (lost >= base && lost <= end) { // Check for simulated loss.
                System.out.println("Frame " + lost + " lost.");

                for (int frame = base; frame <= end; frame++) { // ACK good frames.
                    if (frame != lost) {
                        System.out.println("ACK received for frame " + frame);
                    }
                }

                System.out.println("Retransmitting only frame " + lost);
                System.out.println("ACK received for frame " + lost);
                lost = 0; // Assume retransmission succeeds.
            } else {
                for (int frame = base; frame <= end; frame++) {
                    System.out.println("ACK received for frame " + frame);
                }
            }

            base = end + 1; // Slide to the next window.
        }

        System.out.println("All frames delivered successfully.");
        scanner.close();
    }
}
