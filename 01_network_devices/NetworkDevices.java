// CN Lab Experiment 1: Study of Network Devices
// This program prints a simple study table for common network devices.

public class NetworkDevices {
    public static void main(String[] args) {

        String[][] devices = {
            {"Hub", "Broadcasts data to all connected ports."},
            {"Switch", "Forwards frames using MAC addresses."},
            {"Router", "Connects different networks using IP addresses."},
            {"Bridge", "Connects LAN segments and filters frames."},
            {"Repeater", "Regenerates weak network signals."},
            {"Gateway", "Connects networks that may use different protocols."},
            {"Modem", "Converts signals for communication over a service line."},
            {"Access Point", "Provides wireless devices access to a network."}
        };

        for (String[] device : devices) { // Loop through every device.
            System.out.println(device[0] + ": " + device[1]); // Print name and purpose.
        }
    }
}
