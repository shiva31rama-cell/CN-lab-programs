# CN Lab Experiment 1: Study of Network Devices
# This program prints a simple study table for common network devices.

devices = {
    "Hub": "Broadcasts data to all connected ports.",
    "Switch": "Forwards frames using MAC addresses.",
    "Router": "Connects different networks using IP addresses.",
    "Bridge": "Connects LAN segments and filters frames.",
    "Repeater": "Regenerates weak network signals.",
    "Gateway": "Connects networks that may use different protocols.",
    "Modem": "Converts signals for communication over a service line.",
    "Access Point": "Provides wireless devices access to a network."
}

for name, purpose in devices.items():  # Loop through every device and its purpose.
    print(f"{name}: {purpose}")       # Display the device name and purpose.
