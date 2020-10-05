package main

import (
    "bufio"
    "fmt"
    "os"
    "strconv"
    "strings"
)

func main() {
    io := bufio.NewScanner(os.Stdin)

    io.Scan()
    cases, _ := strconv.Atoi(io.Text())

    for i := 0; i < cases; i++ {
        io.Scan()
        line := strings.Fields(io.Text())
        beats, _ := strconv.ParseFloat(line[0], 10)
        secs, _ := strconv.ParseFloat(line[1], 10)

        BPM := 60 * beats / secs
        diff := 60 / secs

        fmt.Printf("%0.4f %0.4f %0.4f\n", BPM - diff, BPM, BPM + diff)
    }
}
