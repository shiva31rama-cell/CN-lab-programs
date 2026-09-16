# CN Lab Programs — Prashanti Ma'am

Computer Networks Lab programs from the Vishnu Institute of Technology lab list.

## Language structure

Each programming experiment is provided in:
- Python — simple, readable implementation
- Java — equivalent simple implementation

The code intentionally uses basic loops, arrays/lists, functions, and clear variable names. Comments are included near important variables, loops, and logic.

## Experiments

| No. | Experiment | Folder |
|---|---|---|
| 1 | Network devices | `01_network_devices` |
| 2(i) | Character stuffing | `02_framing_character_stuffing` |
| 2(ii) | Bit stuffing | `02_framing_bit_stuffing` |
| 3 | Checksum | `03_checksum` |
| 4 | Hamming code | `04_hamming_code` |
| 5 | CRC-12 / CRC-16 / CRC-CCITT | `05_crc` |
| 6 | Go-Back-N | `06_go_back_n` |
| 7 | Selective Repeat | `07_selective_repeat` |
| 8 | Stop-and-Wait | `08_stop_and_wait` |
| 9 | Leaky Bucket | `09_leaky_bucket` |
| 10 | Dijkstra | `10_dijkstra` |
| 11 | Distance Vector Routing | `11_distance_vector` |
| 12 | Broadcast Tree | `12_broadcast_tree` |
| 13 | Wireshark | `13_wireshark` |
| 14 | Nmap network discovery | `14_nmap_network_discovery` |
| 15 | Nmap OS detection | `15_nmap_os_detection` |
| 16 | NS-2 simulation and metrics | `16_ns2_simulation` |
| A1 | TCP client-server chat | `additional_01_tcp_chat` |
| A2 | TCP socket program | `additional_02_tcp_socket` |

## Running Python

```bash
python filename.py
```

## Running Java

```bash
javac FileName.java
java FileName
```

The Java file name and public class name are intentionally the same.

## Tool-based experiments

Experiments 13–16 depend on networking tools:
- Wireshark/TShark for packet capture
- Nmap for discovery and OS detection
- NS-2 for the actual network simulation

The repository includes simple Python/Java helpers where appropriate, plus the actual `ns2_simulation.tcl` file for NS-2.

## Lab note

Run Nmap only against systems/networks you are authorized to test. For Wireshark and NS-2, use the lab environment and instructor-provided setup.
