# Additional Experiment 2: Basic TCP Socket Client

import socket

HOST = input("Enter server IP (example: 127.0.0.1): ").strip()
PORT = 6000

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # Create TCP socket.
client.connect((HOST, PORT))                               # Connect to server.

message = input("Enter message: ")                         # Read data to send.
client.sendall(message.encode())                           # Send data using TCP.

reply = client.recv(1024).decode()                         # Receive server response.
print("Server:", reply)

client.close()                                             # Close TCP connection.
