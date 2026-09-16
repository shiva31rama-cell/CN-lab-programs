# CN Lab Experiment 16: Basic NS-2 simulation
# Creates UDP traffic through a DropTail link and writes trace data.
# Run with: ns ns2_simulation.tcl
# The trace file can be analyzed for sent, received and dropped packets.

set ns [new Simulator]

set tracefile [open "cn_lab_trace.tr" w]
$ns trace-all $tracefile

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

$ns duplex-link $n0 $n2 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n2 $n3 512Kb 20ms DropTail

set udp [new Agent/UDP]
$ns attach-agent $n0 $udp

set null [new Agent/Null]
$ns attach-agent $n3 $null

$ns connect $udp $null

set cbr [new Application/Traffic/CBR]
$cbr set packetSize_ 1000
$cbr set interval_ 0.005
$cbr attach-agent $udp

$ns at 0.5 "$cbr start"
$ns at 9.5 "$cbr stop"
$ns at 10.0 "finish"

proc finish {} {
    global ns tracefile
    $ns flush-trace
    close $tracefile
    puts "NS-2 simulation completed."
    puts "Trace file: cn_lab_trace.tr"
    exit 0
}

$ns run
