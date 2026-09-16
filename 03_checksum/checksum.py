# CN Lab Experiment 3: Internet Checksum
# This simple program uses 8-bit words and one's-complement addition.

def add_with_carry(a, b):
    total = a + b                         # Add the two 8-bit values.
    while total > 255:                    # Repeat while a carry exists.
        total = (total & 255) + (total >> 8)  # Wrap the carry around.
    return total

data = input("Enter hexadecimal bytes separated by spaces: ").split()
words = [int(x, 16) for x in data]        # Convert each hex byte to an integer.

sum_value = 0
for word in words:                        # Add every byte to the running sum.
    sum_value = add_with_carry(sum_value, word)

checksum = (~sum_value) & 255             # One's complement gives the checksum.
print(f"Checksum = {checksum:02X}")
