// CN Lab Experiment 9: Leaky Bucket Congestion Control

import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bucket capacity: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter output rate: ");
        int rate = scanner.nextInt();

        System.out.print("Enter number of time units: ");
        int n = scanner.nextInt();

        int bucket = 0; // Current number of packets in the bucket.

        for (int time = 1; time <= n; time++) { // Process each time unit.
            System.out.print("Packets arriving at time " + time + ": ");
            int incoming = scanner.nextInt();

            int dropped = 0; // Number of packets lost because of overflow.

            if (bucket + incoming > capacity) { // Check bucket overflow.
                dropped = bucket + incoming - capacity;
                bucket = capacity;
            } else {
                bucket += incoming; // Add all incoming packets.
            }

            int sent = Math.min(bucket, rate); // Send at most rate packets.
            bucket -= sent;                    // Remove transmitted packets.

            System.out.println(
                "Time " + time + ": incoming=" + incoming +
                ", sent=" + sent +
                ", dropped=" + dropped +
                ", remaining=" + bucket
            );
        }

        System.out.println("Leaky Bucket simulation completed.");
        scanner.close();
    }
}
