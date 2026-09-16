# CN Lab Experiment 9: Leaky Bucket Congestion Control
# Packets enter a bucket and leave at a fixed output rate.

capacity = int(input("Enter bucket capacity: "))         # Maximum packets stored.
rate = int(input("Enter output rate: "))                 # Packets sent per time unit.
n = int(input("Enter number of time units: "))           # Number of input moments.

bucket = 0

for time in range(1, n + 1):                             # Process each time unit.
    incoming = int(input(f"Packets arriving at time {time}: "))

    if bucket + incoming > capacity:                     # Check for overflow.
        dropped = bucket + incoming - capacity           # Calculate overflow packets.
        bucket = capacity                                # Keep only capacity packets.
    else:
        dropped = 0
        bucket += incoming                               # Add arriving packets.

    sent = min(bucket, rate)                             # Send at most the output rate.
    bucket -= sent                                       # Remove sent packets.

    print(f"Time {time}: incoming={incoming}, sent={sent}, "
          f"dropped={dropped}, remaining={bucket}")

print("Leaky Bucket simulation completed.")
