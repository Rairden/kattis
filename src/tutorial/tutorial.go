package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"path/filepath"
	"strconv"
)

// https://open.kattis.com/problems/tutorial

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/tutorial/in")
	file, _ := os.Open(input)
	io := bufio.NewReader(file)

	var mm, nn, tt string
	fmt.Fscanln(io, &mm, &nn, &tt)

	m, _ := strconv.ParseInt(mm, 10, 64)
	n, _ := strconv.ParseFloat(nn, 64)
	t, _ := strconv.ParseFloat(tt, 64)

	switch t {
	case 1:
		fmt.Println(factorial(m, n))	// O(n!)
	case 2:
		fmt.Println(exponential(m, n))	// O(2ⁿ)
	case 3:
		fmt.Println(quartic(m, n))		// O(n⁴)
	case 4:
		fmt.Println(cubic(m, n))		// O(n³)
	case 5:
		fmt.Println(quadratic(m, n))	// O(n²)
	case 6:
		fmt.Println(linearithmic(m, n))	// O(n log₂(n))
	case 7:
		fmt.Println(linear(m, n))		// O(n)
	}
}

func factorial(m int64, n float64) string {
	// 13! is > 1e9
	if n >= 13 {
		return "TLE"
	}

	fact := 2
	for i := 3; i <= int(n); i++ {
		fact *= i
	}

	if int64(fact) <= m {
		return "AC"
	}
	return "TLE"
}

func exponential(m int64, n float64) string {
	// 2^30 is > 1e9
	if n >= 30 {
		return "TLE"
	}

	res := math.Pow(2, n)

	if int64(res) <= m {
		return "AC"
	}
	return "TLE"
}

func quartic(m int64, n float64) string {
	// 178^4 is > 1e9
	if n >= 178 {
		return "TLE"
	}
	return checkBound(m, n, 4)
}

func cubic(m int64, n float64) string {
	// 1000^3 is = 1e9
	if n >= 1001 {
		return "TLE"
	}
	return checkBound(m, n, 3)
}

func quadratic(m int64, n float64) string {
	// 31623^2 > 1e9
	if n >= 31623 {
		return "TLE"
	}
	return checkBound(m, n, 2)
}

func linearithmic(m int64, n float64) string {
	x := math.Log2(n)
	res := n * x // n log₂(n)

	if res <= float64(m) {
		return "AC"
	}
	return "TLE"
}

func linear(m int64, n float64) string {
	if n <= float64(m) {
		return "AC"
	}
	return "TLE"
}

func checkBound(m int64, n float64, degree float64) string {
	res := math.Pow(n, degree)

	if int64(res) <= m {
		return "AC"
	}
	return "TLE"
}
