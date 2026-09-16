// CN Lab Experiment 2(i): Character Stuffing

import java.util.Scanner;

public class CharacterStuffing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final char FLAG = 'F'; // FLAG identifies the start and end of a frame.
        final char ESC = 'E';  // ESC protects special characters inside data.

        System.out.print("Enter data: ");
        String data = scanner.nextLine(); // Read the original data.

        StringBuilder stuffed = new StringBuilder(); // Store stuffed data.

        for (char ch : data.toCharArray()) { // Process each character.
            if (ch == FLAG || ch == ESC) {  // Check whether it is special.
                stuffed.append(ESC);         // Insert ESC before a special character.
            }
            stuffed.append(ch);              // Add the original character.
        }

        String frame = FLAG + stuffed.toString() + FLAG; // Add frame boundaries.
        System.out.println("Stuffed frame: " + frame);

        scanner.close();
    }
}
