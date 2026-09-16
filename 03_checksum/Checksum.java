// CN Lab Experiment 3: Internet Checksum
// This simple program uses 8-bit words and one's-complement addition.

import java.util.Scanner;

public class Checksum {
    static int addWithCarry(int a, int b) {
        int total = a + b; // Add the two values.

        while (total > 255) { // Continue while a carry exists.
            total = (total & 255) + (total >> 8); // Wrap carry around.
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter hexadecimal bytes separated by spaces: ");
        String[] data = scanner.nextLine().trim().split("\\s+");

        int sum = 0; // Store the running one's-complement sum.

        for (String item : data) { // Process every hexadecimal byte.
            int value = Integer.parseInt(item, 16); // Convert hex to integer.
            sum = addWithCarry(sum, value);          // Add with carry wrapping.
        }

        int checksum = (~sum) & 255; // Take one's complement.
        System.out.printf("Checksum = %02X%n", checksum);

        scanner.close();
    }
}
