package main

import (
	"bufio"
	"fmt"
	"os"
	"regexp"
	"strconv"
)

func main() {
	io := bufio.NewScanner(os.Stdin)

	var cases int16
	fmt.Scanf("%v", &cases)

	for ; cases > 0; cases-- {
		io.Scan()
		line := io.Text()

		if line == "P=NP" {
			fmt.Println("skipped")
			continue
		}

		split := regexp.MustCompile("[+=]").Split(line, 2)
		numbers := addNumbers(split)

		fmt.Println(numbers)
	}
}

func addNumbers(split []string) int {
	num1, _ := strconv.Atoi(split[0])
	num2, _ := strconv.Atoi(split[1])
	return num1 + num2
}
