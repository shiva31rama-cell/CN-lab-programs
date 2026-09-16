# CN Lab Experiment 8: Stop-and-Wait Protocol
# One frame is sent and acknowledged before the next frame is sent.

total = int(input("Enter number of frames: "))           # Total frames.
lost = int(input("Enter lost frame number (0 for none): "))  # Simulated loss.

for frame in range(1, total + 1):                        # Send frames one by one.
    print(f"Sending frame {frame}")

    if frame == lost:                                   # Simulate one lost frame.
        print(f"Frame {frame} lost. Retransmitting...")
        print(f"Sending frame {frame} again.")
        print(f"ACK received for frame {frame}.")
    else:
        print(f"ACK received for frame {frame}.")

print("All frames delivered successfully.")
