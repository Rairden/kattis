package main

import (
	"bufio"
	"fmt"
	"math/bits"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/bits

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/bits/in")
	file, _ := os.Open(input)
	io := bufio.NewScanner(file)
	io.Scan()

	cases, _ := strconv.Atoi(io.Text())

	for i := 0; i < cases; i++ {
		io.Scan()
		num := io.Text()
		split := strings.Split(num, "")

		var sb strings.Builder
		onesCnt := 0
		for _, Digit := range split {
			sb.WriteString(Digit)
			digit, _ := strconv.Atoi(sb.String())
			ones := bits.OnesCount32(uint32(digit))
			if ones > onesCnt {
				onesCnt = ones
			}
		}
		fmt.Println(onesCnt)
	}
}
