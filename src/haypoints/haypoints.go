package main

import (
    "bufio"
    "fmt"
    "os"
    "path/filepath"
    "strconv"
    "strings"
)

var dict = make(map[string]int)

func main() {
    input := os.Getenv("GOPATH") + filepath.Join("/src/code/haypoints/in")

    file, err := os.Open(input)
    io := bufio.NewScanner(file)

    if err != nil {
        fmt.Printf("File not found: '%v'", input)
        return
    }

    io.Scan()
    firstLine := io.Text()
    split := strings.Fields(firstLine)

    words, _ := strconv.Atoi(split[0])

    for i := 0; i < words; i++ {
        io.Scan()
        line := io.Text()
        title, salary := splitLine(line)
        dict[title] = int(salary)
    }

    var sum int
    for io.Scan() {
        line := io.Text()

        if line == "." {
            fmt.Println(sum)
            sum = 0
            continue
        }
        sum += calcSalary(line)
    }
}

func calcSalary(line string) int {
    var sum int
    sum += sumLine(line)
    return sum
}

// take a line, split it delimited by white space
func sumLine(line string) int {
    word := strings.Fields(line)
    var sum int

    for _, s := range word {
        if val, ok := dict[s]; ok {
            sum += val
        }
    }
    return sum
}

func splitLine(line string) (title string, salary int64) {
    split := strings.Fields(line)
    title = split[0]
    salary, _ = strconv.ParseInt(split[1], 0, 64)
    return title, salary
}
