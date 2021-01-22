package main

import (
	"io/ioutil"
	"os"
	"path/filepath"
	"testing"
)

func Test_backspace(t *testing.T) {
	tests := []struct {
		in   string
		want string
	}{
		{"a<bc<", "b"},
		{"foss<<rritun", "forritun"},
		{"ab<<<a", "a"},
		{"<<<<<<abc<<", "a"},
		{"erika<<krairden<<<<<<<", "erik"},
		{"abc", "abc"},
		{"c<def<ghi<<<<", "d"},
		{"<abc<", "ab"},
		{"<ab<cde<<", "ac"},
		{"", ""},
		{"<<<<<a", "a"},
		{"a<<<<<", ""},
		{"a<a<a<aa<<", ""},
	}

	for _, test := range tests {
		line := []byte(test.in)
		if got := backspace(line); got.String() != test.want {
			t.Errorf(" got: %v", got)
			t.Errorf("want: %v", test.want)
		}
	}
}

func Benchmark_main(b *testing.B) {
	for i := 0; i < b.N; i++ {
		main()
	}
}

func Benchmark_backspace(b *testing.B) {
	file := os.Getenv("GOPATH") + filepath.Join("/src/code/backspace/inLong")
	io, _ := ioutil.ReadFile(file)
	for i := 0; i < b.N; i++ {
		backspace(io)
	}
}
