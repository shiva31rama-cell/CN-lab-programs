# CN Lab Experiment 2(i): Character Stuffing
# FLAG marks the beginning/end of a frame.
# ESC is inserted before FLAG or ESC when it appears inside data.

FLAG = "F"
ESC = "E"

data = input("Enter data: ")  # Store the original data entered by the user.
stuffed = ""                  # Store the framed and stuffed data.

for ch in data:               # Check every character in the input.
    if ch == FLAG or ch == ESC:  # Special characters need an ESC before them.
        stuffed += ESC            # Insert the escape character.
    stuffed += ch                  # Add the original character.

frame = FLAG + stuffed + FLAG     # Add FLAG at the beginning and end.
print("Stuffed frame:", frame)
