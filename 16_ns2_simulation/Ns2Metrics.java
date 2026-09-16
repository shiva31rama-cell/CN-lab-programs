// CN Lab Experiment 16: Simple NS-2-style metric calculation
// Educational equivalent when NS-2 itself is not installed.

import java.util.Scanner;

public class Ns2Metrics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter packets sent: ");
        int sent = scanner.nextInt(); // Total generated packets.

        System.out.print("Enter packets received: ");
        int received = scanner.nextInt(); // Successfully received packets.

        System.out.print("Enter simulation time in seconds: ");
        double duration = scanner.nextDouble(); // Simulation duration.

        System.out.print("Enter packet size in bytes: ");
        int packetSize = scanner.nextInt(); // Size of each packet.

        int dropped = Math.max(0, sent - received); // Calculate lost packets.
        double dropRatio = sent > 0 ? (double) dropped / sent : 0; // Drop fraction.

        double throughput = duration > 0
            ? (received * packetSize * 8.0) / duration
            : 0; // Received bits per second.

        double dataRate = duration > 0
            ? (sent * packetSize * 8.0) / duration
            : 0; // Generated bits per second.

        System.out.println("Packets dropped: " + dropped);
        System.out.println("Drop ratio: " + dropRatio);
        System.out.println("Throughput (bits/second): " + throughput);
        System.out.println("Data rate (bits/second): " + dataRate);

        scanner.close();
    }
}
