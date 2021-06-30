package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/variablearithmetic

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/variablearithmetic/in")
	file, _ := os.Open(input)
	io, _ := ioutil.ReadAll(file)

	allLines := strings.Split(string(io), "\n")
	allLines = allLines[:len(allLines) - 2]				// remove linefeed and zero from tail

	var vars  = make(map[string]int)
	var sb strings.Builder
	var result []string
	var sum int64
	var hasNumbers bool

	for _, lines := range allLines {
		line := strings.Fields(lines)
		result = result[:0]
		sum = 0
		hasNumbers = false

		// if assignment (length = 3)
		if len(line) > 1 {
			if line[1] == "=" {
				num, _ := strconv.Atoi(line[2])
				vars[line[0]] = num
				continue
			}
		}

		// each line is a combo of 4 things: word, number, +, =
		// go thru line, and if digit sum it. Else check map. And trim concat words, trim
		for i := 0; i < len(line); i += 2 {
			word := line[i]
			if x, err := strconv.ParseInt(word, 0, 64); err == nil {
				sum += x
				hasNumbers = true
			} else {
				// Is a variable, check if it exists
				if val, ok := vars[word]; ok {
					sum += int64(val)
				} else {
					result = append(result, word)
				}
			}
		}

		// process the line
		num := strconv.Itoa(int(sum))
		if len(result) == 0 {
			sb.WriteString(num + "\n")
			continue
		}

		if hasNumbers {
			sb.WriteString(num + " + ")
		}
		for i := 0; i < len(result) - 1; i++ {
			sb.WriteString(result[i] + " + ")
		}
		sb.WriteString(result[len(result) - 1] + "\n")

	}
	fmt.Print(sb.String())
}
