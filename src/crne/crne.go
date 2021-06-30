package main

import (
	"fmt"
)

// https://open.kattis.com/problems/crne

func main() {
	var cuts int
	fmt.Scanln(&cuts)

	cutHoriz := cuts / 2
	cutVert := cuts - cutHoriz

	fmt.Println((cutHoriz+1) * (cutVert+1))
}
