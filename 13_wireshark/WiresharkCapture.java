// CN Lab Experiment 13: Wireshark Packet Capture
// This Java helper starts TShark, the command-line component of Wireshark.
// Install Wireshark and make sure "tshark" is available in PATH.

import java.io.IOException;
import java.util.Scanner;

public class WiresharkCapture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter interface name/number (example: 1): ");
        String interfaceName = scanner.nextLine().trim();

        System.out.print("Enter number of packets to capture: ");
        String count = scanner.nextLine().trim();

        ProcessBuilder builder = new ProcessBuilder(
            "tshark", "-i", interfaceName, "-c", count
        ); // Build the TShark command.

        builder.inheritIO(); // Show TShark output directly in the terminal.

        try {
            Process process = builder.start(); // Start packet capture.
            int exitCode = process.waitFor();   // Wait until TShark finishes.
            System.out.println("TShark finished with code: " + exitCode);
        } catch (IOException error) {
            System.out.println(
                "TShark was not found. Install Wireshark and add TShark to PATH."
            );
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt(); // Restore interrupted status.
            System.out.println("Capture was interrupted.");
        }

        scanner.close();
    }
}
