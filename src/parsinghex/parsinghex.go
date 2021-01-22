package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"regexp"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/parsinghex

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/parsinghex/in")
	file, _ := os.Open(input)
	io := bufio.NewScanner(file)
	var sb strings.Builder

	for io.Scan() {
		line := io.Text()
		regex, _ := regexp.Compile("0[xX][0-9a-fA-F]{1,8}")
		match := regex.FindAllString(line, -1)

		for _, hex := range match {
			decimal, _ := strconv.ParseInt(hex[2:], 16, 64)
			num := strconv.Itoa(int(decimal))
			sb.WriteString(hex + " " + num + " \n")
		}
	}

	fmt.Print(sb.String())
}
