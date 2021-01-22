package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"
)

// https://open.kattis.com/problems/backspace

const BACKSPACE = '<'
const DELETED_CHAR = '8'

func main() {
	file := os.Getenv("GOPATH") + filepath.Join("/src/code/backspace/stack/in")
	io, _ := ioutil.ReadFile(file)
	line := io[:len(io) - 1]	// remove newline at end

	bs := backspace(line)
	result := cleanResult(bs)
	if result.Len() > 0 {
		fmt.Println(result.String())
	}
}

func backspace(str []byte) []byte {
	for i := 0; i < len(str); i++ {
		if str[i] == BACKSPACE {
			backspaces := countRepeatedBackspaces(str, i)

			if backspaces >= 1 && i == 0 {
				i = backspaces - 1
			} else {
				deleteChar(str, i, backspaces)
				i += backspaces
			}
		}
	}
	return str
}

func countRepeatedBackspaces(str []byte, i int) int {
	backspaces := 1

	for k := i + 1; k < len(str); k++ {
		if str[k] == BACKSPACE {
			backspaces++
		} else {
			if backspaces > 1 {
				return backspaces
			}
			return 1
		}
	}
	return backspaces
}

func deleteChar(str []byte, i int, backspaces int) {
	deleted := 0
	offset := 1

	for backspaces > deleted {
		if str[i - offset] != DELETED_CHAR && str[i - offset] != BACKSPACE {
			str[i - offset] = DELETED_CHAR
			deleted++
		}
		offset++

		if i - offset < 0 {
			return
		}
	}
}

func cleanResult(str []byte) strings.Builder {
	var sb strings.Builder

	for i := 0; i < len(str); i++ {
		if str[i] == DELETED_CHAR || str[i] == BACKSPACE {
			continue
		}
		sb.WriteByte(str[i])
	}
	return sb
}
