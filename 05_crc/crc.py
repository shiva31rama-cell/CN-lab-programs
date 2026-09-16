# CN Lab Experiment 5: CRC-12, CRC-16 and CRC-CCITT
# The user enters a binary data string and selects a polynomial.

POLYNOMIALS = {
    "CRC-12": "1100000001111",
    "CRC-16": "11000000000000101",
    "CRC-CCITT": "10001000000100001"
}

name = input("Choose CRC (CRC-12 / CRC-16 / CRC-CCITT): ").strip().upper()
key = next((k for k in POLYNOMIALS if k.upper() == name), None)

if key is None:
    print("Invalid CRC choice.")
else:
    data = input("Enter binary data: ").strip()
    polynomial = POLYNOMIALS[key]
    working = list(data + "0" * (len(polynomial) - 1))

    for i in range(len(data)):                 # Move the polynomial across the data.
        if working[i] == "1":                  # Divide only when the current bit is 1.
            for j in range(len(polynomial)):  # XOR each polynomial bit.
                working[i + j] = str(
                    int(working[i + j]) ^ int(polynomial[j])
                )

    remainder = "".join(working[-(len(polynomial) - 1):])
    print("CRC remainder:", remainder)
    print("Transmitted frame:", data + remainder)
