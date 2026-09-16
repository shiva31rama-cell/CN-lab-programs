// Additional Experiment 1: TCP Client-Server Chat - Server

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TcpChatServer {
    public static void main(String[] args) {
        final int PORT = 5000;

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Waiting for client on port " + PORT + "...");

            try (
                Socket socket = server.accept();             // Accept a client.
                BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
                );
                PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
                );
                Scanner scanner = new Scanner(System.in)
            ) {
                System.out.println("Client connected.");

                while (true) {                               // Continue chatting.
                    String message = input.readLine();       // Read client message.
                    if (message == null || message.equalsIgnoreCase("exit")) break;

                    System.out.println("Client: " + message);

                    System.out.print("Server: ");
                    String reply = scanner.nextLine();       // Read server reply.
                    output.println(reply);                   // Send reply.

                    if (reply.equalsIgnoreCase("exit")) break;
                }
            }
        } catch (IOException error) {
            System.out.println("Server error: " + error.getMessage());
        }
    }
}
