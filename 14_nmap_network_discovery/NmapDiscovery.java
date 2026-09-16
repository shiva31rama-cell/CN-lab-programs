// CN Lab Experiment 14: Nmap Network Discovery
// Nmap must be installed and available in PATH.

import java.io.IOException;
import java.util.Scanner;

public class NmapDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target IP/host (example: 192.168.1.0/24): ");
        String target = scanner.nextLine().trim();

        ProcessBuilder builder = new ProcessBuilder(
            "nmap", "-sn", target
        ); // Build the Nmap command.

        builder.inheritIO(); // Display Nmap output in this terminal.

        try {
            Process process = builder.start(); // Start Nmap.
            int exitCode = process.waitFor();   // Wait for Nmap to finish.
            System.out.println("Nmap finished with code: " + exitCode);
        } catch (IOException error) {
            System.out.println("Nmap was not found. Install Nmap and add it to PATH.");
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt(); // Restore interrupted status.
            System.out.println("Nmap execution was interrupted.");
        }

        scanner.close();
    }
}
