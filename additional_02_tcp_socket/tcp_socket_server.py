# Additional Experiment 2: Basic TCP Socket Server

import socket

HOST = "0.0.0.0"
PORT = 6000

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # Create TCP socket.
server.bind((HOST, PORT))                                  # Attach socket to port.
server.listen(1)                                           # Listen for one client.

print("Waiting for a TCP client...")
connection, address = server.accept()                      # Accept connection.
print("Connected:", address)

data = connection.recv(1024).decode()                      # Receive one message.
print("Received:", data)

connection.sendall(b"Message received successfully.")       # Send response.

connection.close()                                         # Close client connection.
server.close()                                              # Close server socket.
