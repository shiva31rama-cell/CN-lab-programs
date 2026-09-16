# CN Lab Experiment 13: Wireshark Packet Capture
# This helper starts TShark, the command-line component of Wireshark.
# Install Wireshark first and make sure "tshark" is available in PATH.

import subprocess

interface = input("Enter interface name/number (example: 1): ").strip()
count = input("Enter number of packets to capture: ").strip()

command = ["tshark", "-i", interface, "-c", count]  # Build the capture command.

print("Starting packet capture. Stop only after the requested count is reached.")
try:
    subprocess.run(command, check=True)             # Run TShark and show captured traffic.
except FileNotFoundError:
    print("TShark was not found. Install Wireshark and add TShark to PATH.")
except subprocess.CalledProcessError as error:
    print("TShark returned an error:", error)
