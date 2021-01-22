package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/goldbach2

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/goldbach2/in")
	file, _ := os.Open(input)
	io := bufio.NewScanner(file)
	makePrimeMap()

	io.Scan()
	line := io.Text()
	cases, _ := strconv.Atoi(line)
	var sb strings.Builder

	for i := 0; i < cases; i++ {
		io.Scan()
		evenNum, _ := strconv.Atoi(io.Text())
		sumOfTwoPrimes(evenNum, &sb)
	}
	fmt.Print(sb.String())
}

func sumOfTwoPrimes(evenNum int, sb *strings.Builder) {
	var pairs []int
	if evenNum == 4 {
		sb.WriteString("4 has 1 representation(s)\n2+2\n\n")
		return
	}

	cnt := 0
	iter := 3
	for iter <= evenNum / 2 {
		if primes.Has(iter) {
			sum := evenNum - iter
			if primes.Has(sum) {
				pairs = append(pairs, iter, sum)
				cnt++
			}
		}
		iter += 2
	}

	sb.WriteString(fmt.Sprintf("%v has %v representation(s)\n", evenNum, cnt))

	for i := 0; i < len(pairs); i += 2 {
		sb.WriteString(fmt.Sprintf("%v+%v\n", pairs[i], pairs[i+1]))
	}
	sb.WriteString("\n")
}

func IsPrime(value int) bool {
	for i := 2; i <= int(math.Floor(math.Sqrt(float64(value)))); i++ {
		if value%i == 0 {
			return false
		}
	}
	return true
}

// https://www.thepolyglotdeveloper.com/2016/12/determine-number-prime-using-golang/
func SieveOfEratosthenes(value int) []bool {
	f := make([]bool, value)
	for i := 2; i <= int(math.Sqrt(float64(value))); i++ {
		if f[i] == false {
			for j := i * i; j < value; j += i {
				f[j] = true
			}
		}
	}
	for i := 2; i < value; i++ {
		if f[i] == false {
			fmt.Printf("%v,", i)
		}
	}
	return f
}
