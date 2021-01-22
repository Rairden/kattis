package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"
)

// https://open.kattis.com/problems/backspace

func main() {
	file := os.Getenv("GOPATH") + filepath.Join("/src/code/backspace/in")
	io, _ := ioutil.ReadFile(file)
	line := io[:len(io) - 1]	// remove newline at end

	result := backspace(line)
	if result.Len() > 0 {
		fmt.Println(result.String())
	}
}

func backspace(str []byte) strings.Builder {
	stack := &Stack{}

	for i := 0; i < len(str); i++ {
		if str[i] == 60 {
			stack.Pop()
		} else {
			stack.Push(str[i])
		}
	}

	out := stack.Get()
	var result strings.Builder

	for i := len(out) - 1; i >= 0; i-- {
		result.WriteByte(out[i]) 				// kattis 0.39 sec
		// result += fmt.Sprintf("%c", out[i])	// exceeded 1 sec time limit!
	}

	return result
}
