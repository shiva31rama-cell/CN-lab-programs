# Additional Experiment 1: TCP Client-Server Chat - Server
# Run the server first, then run the client in another terminal.

import socket

HOST = "0.0.0.0"
PORT = 5000

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # Create TCP socket.
server.bind((HOST, PORT))                                   # Bind IP and port.
server.listen(1)                                            # Wait for one client.

print(f"Waiting for client on port {PORT}...")
connection, address = server.accept()                       # Accept a client connection.
print("Connected:", address)

while True:                                                  # Keep chatting until "exit".
    message = connection.recv(1024).decode()                # Receive client message.
    if not message or message.lower() == "exit":
        break
    print("Client:", message)

    reply = input("Server: ")                               # Read server reply.
    connection.sendall(reply.encode())                       # Send reply to client.
    if reply.lower() == "exit":
        break

connection.close()                                          # Close client connection.
server.close()                                               # Close server socket.
