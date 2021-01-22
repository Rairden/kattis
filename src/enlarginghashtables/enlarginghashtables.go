package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/enlarginghashtables

var sb strings.Builder

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/enlarginghashtables/in")
	file, _ := os.Open(input)
	io := bufio.NewScanner(file)

	for io.Scan(); io.Text() != "0"; {
		resizeHashTable(io.Text())
		io.Scan()
	}

	fmt.Print(sb.String())
}

func resizeHashTable(tablesize string) {
	tableSize, _ := strconv.ParseInt(tablesize, 10, 64)
	doubled := tableSize * 2 + 1

	for {
		if IsPrime(doubled) {
			doubled1 := strconv.Itoa(int(doubled))
			if !IsPrime(tableSize) {
				sb.WriteString(doubled1 + " (" + tablesize + " is not prime)\n")
			} else {
				sb.WriteString(doubled1 + "\n")
			}
			return
		} else {
			doubled += 2
		}
	}
}

func IsPrime(num int64) bool {
	x := big.NewInt(num)
	return x.ProbablyPrime(0)
}
