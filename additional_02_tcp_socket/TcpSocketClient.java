// Additional Experiment 2: Basic TCP Socket Client

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TcpSocketClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server IP (example: 127.0.0.1): ");
        String host = scanner.nextLine().trim();

        final int PORT = 6000;

        try (
            Socket socket = new Socket(host, PORT);        // Connect to server.
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            )
        ) {
            System.out.print("Enter message: ");
            String message = scanner.nextLine();           // Read message.

            output.println(message);                        // Send message.
            String reply = input.readLine();               // Receive response.

            System.out.println("Server: " + reply);
        } catch (IOException error) {
            System.out.println("Client error: " + error.getMessage());
        }

        scanner.close();
    }
}
