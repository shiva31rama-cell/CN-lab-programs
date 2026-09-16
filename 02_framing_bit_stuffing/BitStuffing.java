// CN Lab Experiment 2(ii): Bit Stuffing

import java.util.Scanner;

public class BitStuffing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary data string: ");
        String bits = scanner.nextLine(); // Read the input bits.

        StringBuilder stuffed = new StringBuilder(); // Store stuffed bits.
        int ones = 0; // Count consecutive 1 bits.

        for (char bit : bits.toCharArray()) { // Process each input bit.
            stuffed.append(bit);              // Copy the current bit.

            if (bit == '1') {                  // A 1 increases the count.
                ones++;
                if (ones == 5) {               // Five 1s require a stuffed 0.
                    stuffed.append('0');      // Insert the extra 0.
                    ones = 0;                 // Reset the consecutive count.
                }
            } else {
                ones = 0;                      // A 0 breaks the run of 1s.
            }
        }

        System.out.println("Stuffed bits: " + stuffed);
        scanner.close();
    }
}
