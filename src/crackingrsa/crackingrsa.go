package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

var primes []int

func main() {
	primes = makePrimeArr()
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/crackingrsa/in")
	file, _ := os.Open(input)
	io, _ := ioutil.ReadAll(file)

	lines := strings.Split(string(io), "\n")
	lines = lines[1:len(lines) - 1] 	// remove linefeed from tail

	for _, line := range lines {
		num := strings.Fields(line)
		num1, _ := strconv.Atoi(num[0])
		e, _ := strconv.Atoi(num[1])
		p, q := primeFactors(num1)

		r := (p - 1) * (q - 1)
		privateKey := findCandidate(e, r)
		fmt.Println(privateKey)
	}
}

// It is important for RSA that the value of the φ function (r) is coprime to e (the greatest common divisor must be 1).
// e and d should be different to be strong.  k <= e    ed = k * r
func findCandidate(e, r int) int {
	candidate := 0
	for k := 1; k <= e; k++ {
		candidate = r * k + 1
		if candidate % e == 0 {
			return candidate / e
		}
	}
	return -1
}

func primeFactors(num int) (int, int) {
	for _, p := range primes {
		if num % p == 0 {
			return num/p, p
		}
	}
	return -1, -1
}

// the requirements for this problem only need a product of two primes (p, q) < 1000. So max n val could be 997^2 = 994009.
func makePrimeArr() []int {
	primes = []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
		139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307,
		311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487,
		491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677,
		683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883,
		887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997}
	return primes
}
