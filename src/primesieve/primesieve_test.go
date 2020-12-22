package main

import (
	"math"
	"testing"
)

func Benchmark_main(b *testing.B) {
	for i := 0; i < b.N; i++ {
		count = 0
		main()
	}
}

func Benchmark_run(b *testing.B) {
	makePrimeArr()
	for i := 0; i < b.N; i++ {
		count = 0
		segmentedSieveOfEratosthenes(99999989)
	}
}

func Benchmark_sieveOfEratosthenes(b *testing.B) {
	for i := 0; i < b.N; i++ {
		sieveOfEratosthenes(100)
	}
}

func Benchmark_IsPrime(b *testing.B) {
	for i := 0; i < b.N; i++ {
		IsPrime(9999973)
		IsPrime(9999991)
		IsPrime(10000019)
		IsPrime(10000079)
	}
}

func Benchmark_IsPrimeSegmented(b *testing.B) {
	num1 := 9999973
	num2 := 9999991
	num3 := 10000019
	num4 := 10000079
	makePrimeArr()
	segSize := int(math.Sqrt(float64(num1)))	// same for all 4
	L1, R1 := getLowHighSegment(0, segSize)

	sieves := simpleSieve(segSize, L1, R1)
	L, R := getEntryRange(num1, segSize)		// same for all 4

	for i := 0; i < b.N; i++ {
		isPrimeSegmented(sieves, L, R, num1)
		isPrimeSegmented(sieves, L, R, num2)
		isPrimeSegmented(sieves, L, R, num3)
		isPrimeSegmented(sieves, L, R, num4)
	}
}
