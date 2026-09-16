// Additional Experiment 2: Basic TCP Socket Server

import java.io.*;
import java.net.*;

public class TcpSocketServer {
    public static void main(String[] args) {
        final int PORT = 6000;

        try (
            ServerSocket server = new ServerSocket(PORT) // Create listening socket.
        ) {
            System.out.println("Waiting for a TCP client...");

            try (
                Socket socket = server.accept();         // Accept client.
                BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );
                PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
                )
            ) {
                String message = input.readLine();        // Receive one message.
                System.out.println("Received: " + message);

                output.println("Message received successfully."); // Send response.
            }
        } catch (IOException error) {
            System.out.println("Server error: " + error.getMessage());
        }
    }
}
