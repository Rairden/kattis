package main

import (
	"strings"
	"testing"
)

func Benchmark_main(b *testing.B) {
	for i := 0; i < b.N; i++ {
		main()
	}
}

func Benchmark_sumOfTwoPrimes(b *testing.B) {
	var sb strings.Builder
	makePrimeMap()
	for i := 0; i < b.N; i++ {
		sumOfTwoPrimes(32000, &sb)
	}
}
