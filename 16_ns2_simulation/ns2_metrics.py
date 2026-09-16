# CN Lab Experiment 16: Simple NS-2-style metric calculation
# This is a small educational equivalent when NS-2 itself is not installed.
# It calculates sent, received, dropped packets, drop ratio and throughput.

sent = int(input("Enter packets sent: "))             # Total packets generated.
received = int(input("Enter packets received: "))     # Packets successfully received.
duration = float(input("Enter simulation time in seconds: "))  # Simulation time.
packet_size = int(input("Enter packet size in bytes: "))       # Size of each packet.

dropped = max(0, sent - received)                     # Packets that did not arrive.
drop_ratio = dropped / sent if sent > 0 else 0        # Fraction of packets dropped.
throughput = (received * packet_size * 8) / duration if duration > 0 else 0

data_rate = (sent * packet_size * 8) / duration if duration > 0 else 0

print("Packets dropped:", dropped)
print("Drop ratio:", drop_ratio)
print("Throughput (bits/second):", throughput)
print("Data rate (bits/second):", data_rate)
