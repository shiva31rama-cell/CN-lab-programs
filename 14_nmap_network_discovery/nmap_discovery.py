# CN Lab Experiment 14: Nmap Network Discovery
# Nmap must be installed and available in PATH.
import subprocess

target = input("Enter target IP/host (example: 192.168.1.0/24): ").strip()
command = ["nmap", "-sn", target]  # Build the Nmap command.

try:
    subprocess.run(command, check=True)  # Run Nmap and display its output.
except FileNotFoundError:
    print("Nmap was not found. Install Nmap and add it to PATH.")
except subprocess.CalledProcessError as error:
    print("Nmap returned an error:", error)
