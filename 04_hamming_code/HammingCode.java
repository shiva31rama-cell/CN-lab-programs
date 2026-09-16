// CN Lab Experiment 4: Hamming Code Generation and Error Correction
// Uses even parity and corrects one-bit errors.

import java.util.Scanner;

public class HammingCode {
    static boolean isPowerOfTwo(int number) {
        return number != 0 && (number & (number - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter binary data: ");
        String data = scanner.nextLine().trim();

        int m = data.length(); // Number of data bits.
        int r = 0;             // Number of parity bits.

        while (Math.pow(2, r) < m + r + 1) { // Find enough parity bits.
            r++;
        }

        int n = m + r;
        char[] code = new char[n + 1]; // Use positions 1..n.
        for (int i = 0; i <= n; i++) code[i] = '0';

        int dataIndex = 0;
        for (int position = 1; position <= n; position++) { // Fill data bits.
            if (!isPowerOfTwo(position)) {
                code[position] = data.charAt(dataIndex);
                dataIndex++;
            }
        }

        for (int parity = 0; parity < r; parity++) { // Calculate parity bits.
            int p = 1 << parity;
            int parityValue = 0;

            for (int position = 1; position <= n; position++) { // Check covered bits.
                if ((position & p) != 0) {
                    parityValue ^= code[position] - '0';
                }
            }

            code[p] = (char) ('0' + parityValue);
        }

        StringBuilder encoded = new StringBuilder();
        for (int i = 1; i <= n; i++) encoded.append(code[i]);
        System.out.println("Hamming code: " + encoded);

        System.out.print("Enter received code (or press Enter to use generated code): ");
        String receivedInput = scanner.nextLine().trim();
        if (receivedInput.isEmpty()) receivedInput = encoded.toString();

        char[] received = new char[receivedInput.length() + 1];
        received[0] = '0';
        for (int i = 1; i < received.length; i++) {
            received[i] = receivedInput.charAt(i - 1);
        }

        int errorPosition = 0;

        for (int parity = 0; parity < r; parity++) { // Recalculate parity checks.
            int p = 1 << parity;
            int parityValue = 0;

            for (int position = 1; position < received.length; position++) {
                if ((position & p) != 0) {
                    parityValue ^= received[position] - '0';
                }
            }

            if (parityValue != 0) errorPosition += p; // Build error position.
        }

        if (errorPosition == 0) {
            System.out.println("No single-bit error detected.");
        } else {
            System.out.println("Error position: " + errorPosition);
            received[errorPosition] =
                received[errorPosition] == '0' ? '1' : '0'; // Flip the bad bit.

            StringBuilder corrected = new StringBuilder();
            for (int i = 1; i < received.length; i++) corrected.append(received[i]);
            System.out.println("Corrected code: " + corrected);
        }

        scanner.close();
    }
}
