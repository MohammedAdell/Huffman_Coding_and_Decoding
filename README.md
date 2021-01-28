# Huffman_Coding_and_Decoding

This was a project for the algorithms course CSC311 in April 2020.

Huffman Coding:
This is an implementation of Huffman coding for digital compression.
It is named after David Huffman, who invented the technique as a graduate student at MIT in 1950.
Both JPEG and MP3 encoders use Huffman coding as part of their algorithms.

Usage:
Encoding: this program can compress/encode a text file conatining a decoded message.
The compressed/encoded file will be opened and saved as a text file.

Decoding: this program can decompress/decode a text file.
The decompressed/decoded file will be saved as a text file.

To use this program, you can do the following:

1. Click Browse and choose the text file you wish to encode or decode.
2. You can encode the text file by clicking on
"Encode", a text file containing the encoded message, a huffman tree (as text) and the size measured by byte will be saved and opened.
3. You can build the tree by clicking on “Build”, only after encoding the decoded message (step #2).
4. You can decode the message by choosing the previously saved encoded file,
or you can choose any file, however it must be the same layout as the previously saved encoded file.
you can change only the encoded message itself, the tree code, the size before and after.
all other texts remain the same.

The Huffman tree as a text (Tree Code):
We start from the root, all 0s are internal nodes and all 1s are leaf nodes followed by a character.

Example:

Tree:
        7
  -------------
  3           4
-----     ---------
A   B     2       2
2   1   -----   -----
        C   D   E   F
        1   1   1   1

Paths:

A: 00
B: 01
C: 100
D: 101
E: 110
F: 111

Tree: 001A1B001C1D01E1F = 59 bits
Data: 000001100101110111 = 18 bits
Sum: 59 + 18 = 77 bits = 10 bytes
AABCDEF
