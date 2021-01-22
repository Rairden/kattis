package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"sort"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/stickysituation

var sticks []int

func main() {
	io, _ := ioutil.ReadAll(os.Stdin)
	line := strings.Fields(string(io))
	line = line[1:]

	sticks = make([]int, len(line))
	for i, s := range line {
		sticks[i], _ = strconv.Atoi(s)
	}

	sort.Slice(sticks, func(i, j int) bool {
		return sticks[i] < sticks[j]
	})

	// eliminate small sticks (impossible triangle). Only possible if sorted.
	start := 0
	for i := 0; i < len(sticks) - 2; i++ {
		if sticks[i] + sticks[i+1] <= sticks[i+2] {
			start++
		} else {
			break
		}
	}

	sticks = sticks[start:]
	if len(sticks) >= 3 {
		if sticks[0] + sticks[1] > sticks[2] {
			fmt.Println("possible")
		} else {
			fmt.Println("impossible")
		}
	} else {
		fmt.Println("impossible")
	}
}
