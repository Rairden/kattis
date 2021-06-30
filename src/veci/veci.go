package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	io := bufio.NewScanner(os.Stdin)
	io.Scan()

	line := io.Text()
	split := strings.Split(line, "")
	var num []int
	for _, s := range split {
		digit, _ := strconv.Atoi(s)
		num = append(num, digit)
	}

	ok := NextPermutation(sort.IntSlice(num))
	if ok {
		for _, i := range num {
			fmt.Print(i)
		}
	} else {
		fmt.Print(0)
	}
	fmt.Println()
}

// NextPermutation generates the next permutation of the
// sortable collection x in lexical order.  It returns false if the permutations are exhausted.
//
// Knuth, Donald (2011), "Section 7.2.1.2: Generating All Permutations". The Art of Computer Programming, volume 4A.
func NextPermutation(x sort.Interface) bool {
	n := x.Len() - 1
	if n < 1 {
		return false
	}
	j := n - 1
	for ; !x.Less(j, j+1); j-- {
		if j == 0 {
			return false
		}
	}
	l := n
	for !x.Less(j, l) {
		l--
	}
	x.Swap(j, l)
	for k, l := j+1, n; k < l; {
		x.Swap(k, l)
		k++
		l--
	}
	return true
}
