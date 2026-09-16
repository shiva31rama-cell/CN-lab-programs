// CN Lab Experiment 8: Stop-and-Wait Protocol
// One frame is sent and acknowledged before the next frame.

import java.util.Scanner;

public class StopAndWait {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int total = scanner.nextInt();

        System.out.print("Enter lost frame number (0 for none): ");
        int lost = scanner.nextInt();

        for (int frame = 1; frame <= total; frame++) { // Send one frame at a time.
            System.out.println("Sending frame " + frame);

            if (frame == lost) { // Simulate one lost frame.
                System.out.println("Frame " + frame + " lost. Retransmitting...");
                System.out.println("Sending frame " + frame + " again.");
                System.out.println("ACK received for frame " + frame);
            } else {
                System.out.println("ACK received for frame " + frame);
            }
        }

        System.out.println("All frames delivered successfully.");
        scanner.close();
    }
}
