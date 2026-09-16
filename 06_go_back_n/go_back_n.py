# CN Lab Experiment 6: Go-Back-N Sliding Window Protocol
# This is a simple console simulation. A lost frame causes retransmission
# starting from that frame.

total = int(input("Enter number of frames: "))        # Total frames to send.
window = int(input("Enter window size: "))            # Number of frames in a window.
lost = int(input("Enter lost frame number (0 for none): "))  # Simulated loss.

base = 1                                               # First unacknowledged frame.

while base <= total:                                   # Continue until all frames are sent.
    end = min(base + window - 1, total)                # Find last frame in current window.
    print(f"Sending frames {base} to {end}")

    if lost >= base and lost <= end:                   # Check whether loss is in window.
        print(f"Frame {lost} lost -> Go-Back-N retransmits from frame {lost}.")
        base = lost                                    # Retransmit from the lost frame.
        lost = 0                                       # Simulate successful retransmission.
    else:
        print(f"ACK received for frames {base} to {end}.")
        base = end + 1                                 # Slide window forward.

print("All frames delivered successfully.")
