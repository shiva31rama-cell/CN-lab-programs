// Additional Experiment 1: TCP Client-Server Chat - Client

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TcpChatClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server IP (example: 127.0.0.1): ");
        String host = scanner.nextLine().trim();

        final int PORT = 5000;

        try (
            Socket socket = new Socket(host, PORT);           // Connect to server.
            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            )
        ) {
            while (true) {                                   // Continue chatting.
                System.out.print("Client: ");
                String message = scanner.nextLine();          // Read client message.
                output.println(message);                      // Send to server.

                if (message.equalsIgnoreCase("exit")) break;

                String reply = input.readLine();              // Read server reply.
                System.out.println("Server: " + reply);

                if (reply == null || reply.equalsIgnoreCase("exit")) break;
            }
        } catch (IOException error) {
            System.out.println("Client error: " + error.getMessage());
        }

        scanner.close();
    }
}
