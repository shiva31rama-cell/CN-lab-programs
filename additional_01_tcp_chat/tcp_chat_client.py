# Additional Experiment 1: TCP Client-Server Chat - Client

import socket

HOST = input("Enter server IP (example: 127.0.0.1): ").strip()
PORT = 5000

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # Create TCP socket.
client.connect((HOST, PORT))                               # Connect to server.

while True:                                                 # Keep chatting until "exit".
    message = input("Client: ")                            # Read client message.
    client.sendall(message.encode())                       # Send message to server.
    if message.lower() == "exit":
        break

    reply = client.recv(1024).decode()                     # Receive server reply.
    print("Server:", reply)
    if reply.lower() == "exit":
        break

client.close()                                              # Close the TCP connection.
