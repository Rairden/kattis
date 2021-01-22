package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"sort"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/conversationlog

type user struct {
	name  string
	words []string
	set   map[string]bool
}

type Word struct {
	word string
	cnt  int
}

var db = make(map[string]*user)
var keyWords = make(map[string]bool)
var skipWords = make(map[string]bool)

func main() {
	io, _ := ioutil.ReadAll(os.Stdin)
	io = io[:len(io)-1] 	// remove newline at end

	file := strings.Split(string(io), "\n")
	cases, _ := strconv.Atoi(file[0])

	var sb strings.Builder

	// populate a map of users -> words
	for i := 1; i <= cases; i++ {
		line := strings.Fields(file[i])

		if val, ok := db[line[0]]; ok {
			val.words = append(val.words, line[1:]...)
		} else {
			db[line[0]] = &user{
				name:  line[0],
				words: line[1:],
			}
		}
	}

	// create a set of words for each user
	for _, usr := range db {
		usr.set = make(map[string]bool)
		for _, word := range usr.words {
			usr.set[word] = true
		}
	}

	if cases == 1 {
		for _, usr := range db {
			for word, _ := range usr.set {
				sb.WriteString(word)
			}
		}
		fmt.Print(sb.String())
		return
	}

	for _, usr := range db {
		for word, _ := range usr.set {
			if canSkipWord(word) || isKeyWord(word) {
				continue
			}

			// if all users share common word, add it to a set 'keyWords'
			if allSetsContainWord(word) {
				keyWords[word] = true
			}
		}
	}

	if len(keyWords) == 0 {
		fmt.Println("ALL CLEAR")
		return
	}

	// count the # of times the keywords are used across all users
	var solution []Word

	i := 0
	for word, _ := range keyWords {
		key := &Word{word: word, cnt: 0}
		solution = append(solution, *key)

		for _, usr := range db {
			for _, wrd := range usr.words {
				if key.word == wrd {
					solution[i].cnt++
				}
			}
		}
		i++
	}

	// sort descending (sort by number first, then alphabetical on tie)
	sort.Slice(solution, func(i, j int) bool {
		if solution[i].cnt == solution[j].cnt {
			return solution[i].word < solution[j].word
		}
		return solution[i].cnt > solution[j].cnt
	})

	for _, word := range solution {
		sb.WriteString(word.word + "\n")
	}

	fmt.Print(sb.String())
}

func allSetsContainWord(word string) bool {
	for _, usr := range db {
		if !usr.set[word] {
			skipWords[word] = true
			return false
		}
	}
	return true
}

func canSkipWord(word string) bool {
	return skipWords[word]
}

func isKeyWord(word string) bool {
	return keyWords[word]
}
