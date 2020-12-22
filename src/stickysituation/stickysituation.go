package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/stickysituation

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/stickysituation/in")
	file, _ := os.Open(input)
	io := bufio.NewScanner(file)
	io.Scan()
	io.Scan()

	line := strings.Fields(io.Text())
	combos := GetCombos(line, 3)

	for i := 0; i < len(combos); i++ {
		triangle := strings.Fields(combos[i])
		if isTriangle(triangle) {
			fmt.Println("possible")
			os.Exit(0)
		}
	}
	fmt.Println("impossible")
}

func isTriangle(tri []string) bool {
	a, _ := strconv.Atoi(tri[0])
	b, _ := strconv.Atoi(tri[1])
	c, _ := strconv.Atoi(tri[2])

	if a+b > c && a+c > b && b+c > a {
		return true
	}
	return false
}

func GetCombos(set []string, depth int) []string {
	return GetCombosHelper(set, depth, 0, "", []string{})
}

func GetCombosHelper(set []string, depth int, start int, prefix string, accum []string) []string {
	if depth == 0 {
		return append(accum, prefix)
	} else {
		for i := start; i <= len(set) - depth; i++ {
			accum = GetCombosHelper(set, depth - 1, i + 1, prefix + set[i] + " ", accum)
		}
		return accum
	}
}
