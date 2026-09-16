# CN Lab Experiment 7: Selective Repeat Sliding Window Protocol
# Only the lost/unacknowledged frame is retransmitted.

total = int(input("Enter number of frames: "))          # Total frames.
window = int(input("Enter window size: "))              # Frames in each window.
lost = int(input("Enter lost frame number (0 for none): "))  # Simulated loss.

base = 1
while base <= total:                                    # Process each window.
    end = min(base + window - 1, total)
    print(f"Sending frames {base} to {end}")

    if lost >= base and lost <= end:                    # Check for a lost frame.
        print(f"Frame {lost} lost.")
        for frame in range(base, end + 1):              # Receive ACKs for good frames.
            if frame != lost:
                print(f"ACK received for frame {frame}.")
        print(f"Retransmitting only frame {lost}.")     # Selective retransmission.
        print(f"ACK received for frame {lost}.")
        lost = 0                                        # Assume retransmission succeeds.
    else:
        for frame in range(base, end + 1):              # ACK every frame.
            print(f"ACK received for frame {frame}.")

    base = end + 1                                     # Move to the next window.

print("All frames delivered successfully.")
