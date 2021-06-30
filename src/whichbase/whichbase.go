package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/whichbase

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/whichbase/in")
	file, _ := os.Open(input)
	io := bufio.NewScanner(file)
	io.Scan()

	for io.Scan() {
		line := io.Text()
		nums := strings.Fields(line)
		oct, _ := strconv.ParseInt(nums[1], 8, 64)
		dec, _ := strconv.ParseInt(nums[1], 10, 64)
		hex, _ := strconv.ParseInt(nums[1], 16, 64)

		fmt.Println(nums[0], oct, dec, hex)
	}
}
