# CN Lab Experiment 4: Hamming Code Generation and Error Correction
# This implementation uses even parity.

def is_power_of_two(number):
    return number != 0 and (number & (number - 1)) == 0

data = input("Enter binary data: ").strip()
m = len(data)                           # Number of data bits.
r = 0                                    # Number of parity bits.

while 2 ** r < m + r + 1:               # Find enough parity positions.
    r += 1

n = m + r
code = ["0"] * (n + 1)                  # Position 0 is unused.

data_index = 0
for position in range(1, n + 1):         # Fill non-parity positions.
    if not is_power_of_two(position):
        code[position] = data[data_index]
        data_index += 1

for parity in range(r):                  # Calculate each parity bit.
    p = 2 ** parity
    parity_value = 0
    for position in range(1, n + 1):     # Check positions covered by this parity bit.
        if position & p:
            parity_value ^= int(code[position])
    code[p] = str(parity_value)

encoded = "".join(code[1:])
print("Hamming code:", encoded)

received = input("Enter received code (or press Enter to use generated code): ").strip()
if not received:
    received = encoded

received = "0" + received                # Make positions 1-based.
error_position = 0

for parity in range(r):                  # Recalculate every parity check.
    p = 2 ** parity
    parity_value = 0
    for position in range(1, len(received)):  # Check positions covered by this parity.
        if position & p:
            parity_value ^= int(received[position])
    if parity_value:
        error_position += p              # Add this parity position to the error index.

if error_position == 0:
    print("No single-bit error detected.")
else:
    print("Error position:", error_position)
    corrected = list(received)
    corrected[error_position] = "1" if corrected[error_position] == "0" else "0"
    print("Corrected code:", "".join(corrected[1:]))
