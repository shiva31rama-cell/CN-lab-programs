// CN Lab Experiment 5: CRC-12, CRC-16 and CRC-CCITT
// This program performs binary polynomial division using XOR.

import java.util.*;

public class CRC {
    static final Map<String, String> POLYNOMIALS = new LinkedHashMap<>();

    static {
        POLYNOMIALS.put("CRC-12", "1100000001111");
        POLYNOMIALS.put("CRC-16", "11000000000000101");
        POLYNOMIALS.put("CRC-CCITT", "10001000000100001");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose CRC (CRC-12 / CRC-16 / CRC-CCITT): ");
        String choice = scanner.nextLine().trim().toUpperCase();

        String polynomial = null;
        for (Map.Entry<String, String> entry : POLYNOMIALS.entrySet()) {
            if (entry.getKey().toUpperCase().equals(choice)) {
                polynomial = entry.getValue(); // Select the requested polynomial.
                break;
            }
        }

        if (polynomial == null) {
            System.out.println("Invalid CRC choice.");
            scanner.close();
            return;
        }

        System.out.print("Enter binary data: ");
        String data = scanner.nextLine().trim();

        char[] working = (data + "0".repeat(polynomial.length() - 1)).toCharArray();

        for (int i = 0; i < data.length(); i++) { // Move across the data.
            if (working[i] == '1') {              // Divide only when bit is 1.
                for (int j = 0; j < polynomial.length(); j++) { // XOR polynomial.
                    working[i + j] =
                        (working[i + j] == polynomial.charAt(j)) ? '0' : '1';
                }
            }
        }

        String remainder = new String(
            working, working.length - polynomial.length() + 1,
            polynomial.length() - 1
        );

        System.out.println("CRC remainder: " + remainder);
        System.out.println("Transmitted frame: " + data + remainder);

        scanner.close();
    }
}
