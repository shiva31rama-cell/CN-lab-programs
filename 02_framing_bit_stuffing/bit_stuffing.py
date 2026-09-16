# CN Lab Experiment 2(ii): Bit Stuffing
# A 0 is inserted after every sequence of five consecutive 1 bits.

bits = input("Enter a binary data string: ")  # Read 0/1 data.
stuffed = ""                                  # Store the stuffed result.
ones = 0                                      # Count consecutive 1 bits.

for bit in bits:                              # Process one bit at a time.
    stuffed += bit                            # Copy the current bit.
    if bit == "1":                            # A 1 increases the consecutive count.
        ones += 1
        if ones == 5:                         # Five consecutive 1s require a stuffed 0.
            stuffed += "0"                    # Insert the extra 0 bit.
            ones = 0                          # Restart the count after stuffing.
    else:
        ones = 0                              # A 0 breaks the sequence of 1s.

print("Stuffed bits:", stuffed)
