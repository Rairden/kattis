package main

import (
	"bufio"
	"fmt"
	"math"
	"math/big"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/primesieve

var count int
var N int
var sieves []bool

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/primesieve/in")
	file, _ := os.Open(input)
	io := bufio.NewScanner(file)
	io.Scan()
	line := io.Text()
	split := strings.Fields(line)

	sieve, _ := strconv.Atoi(split[0])
	cases, _ := strconv.Atoi(split[1])

	// makePrimeMap()
	makePrimeArr()
	var result strings.Builder

	if sieve >= 100 {
		segmentedSieveOfEratosthenes(sieve)
		fmt.Println(count)
	} else {
		sieveOfEratosthenes(sieve)
		fmt.Println(count)
	}

	for i := 0; i < cases; i++ {
		io.Scan()
		line := io.Text()
		num, _ := strconv.ParseInt(line, 0, 64)

		if IsPrime(num) {
			result.WriteString("1\n")
		} else {
			result.WriteString("0\n")
		}
	}

	fmt.Print(result.String())
}

func isPrimeSegmented(sieves *[]bool, L int, R int, num int) bool {
	// reset only a small range, not entire array
	for i := 0; i <= R - L; i++ {
		(*sieves)[i] = false
	}

	for i := 0; primes[i] * primes[i] <= num; i++ {
		for m := getStartMultiple(primes[i], L); m <= num; m += primes[i] {
			k := m - L
			(*sieves)[k] = true
		}
	}

	k := num - L
	return !(*sieves)[k]
}

func segmentedSieveOfEratosthenes(n int) {
	N = n
	segSize := int(math.Sqrt(float64(n)))
	L, R := getLowHighSegment(0, segSize)
	sieves := simpleSieve(segSize, L, R)
	loops := n / segSize

	for i := 1; i < loops; i++ {
		L, R := getLowHighSegment(i, segSize)
		segmentedSieve(sieves, L, R)
	}

	L1, R1 := getLowHighSegment(loops, segSize)
	lastSegment(sieves, L1, R1)
}

func segmentedSieve(sieves *[]bool, L int, R int) {
	for i := 0; i <= R - L; i++ {
		(*sieves)[i] = false
	}

	// for every multiple m of p in range L to R, mark index m - L as true
	// 10, 12, 14, ...	Ex: L = 10, R = 19, m = 12.  m - L = 2.  Mark index 2 as true (composite)
	for i := 0; primes[i] * primes[i] <= R; i++ {
		for m := getStartMultiple(primes[i], L); m <= R; m += primes[i] {
			k := m - L
			(*sieves)[k] = true
		}
	}

	for i := 0; i <= R - L; i++ {
		if !(*sieves)[i] {
			count++
			// fmt.Printf("%v\n", i + L)
		}
	}
}

func lastSegment(sieves *[]bool, L int, R int) {
	for i := 0; i <= R - L; i++ {
		(*sieves)[i] = false
	}

	for i := 0; primes[i] * primes[i] <= R; i++ {
		for m := getStartMultiple(primes[i], L); m <= R; m += primes[i] {
			k := m - L
			(*sieves)[k] = true
		}
	}

	for i := 0; L <= N; i++ {
		if !(*sieves)[i] {
			count++
		}
		L++
		// fmt.Printf("%v\n", i + L)
	}
}

func getStartMultiple(m int, L int) int {
	firstMultiple := math.Ceil(float64(L) / float64(m))
	return m * int(firstMultiple)
}

func getLowHighSegment(i int, segSize int) (int, int) {
	L := segSize * i
	R := L + segSize - 1
	return L, R
}

func getEntryRange(num int, segSize int) (int, int) {
	i := num / segSize
	L := segSize * i
	R := L + segSize - 1
	return L, R
}

func simpleSieve(segSize int, L int, R int) *[]bool {
	sieves = make([]bool, 10001)
	
	for i := 0; primes[i] * primes[i] <= R; i++ {
		for m := primes[i] * 2; m <= R; m += primes[i] {
			k := m - L
			sieves[k] = true
		}
	}

	for i := 2; i < segSize; i++ {
		if !sieves[i] {
			count++
			// fmt.Printf("%v\n", i)
		}
	}
	return &sieves
}

func sieveOfEratosthenes(n int) {
	f := make([]bool, n + 1)

	for i := 0; primes[i] * primes[i] <= n; i++ {
		for m := primes[i] * 2; m <= n; m += primes[i] {
			f[m] = true
		}
	}

	for i := 2; i < n; i++ {
		if !f[i] {
			count++
			// fmt.Printf("%v\n", i)
		}
	}
}

func IsPrime(num int64) bool {
	x := big.NewInt(num)
	return x.ProbablyPrime(0)
}
