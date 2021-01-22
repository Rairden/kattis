package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

// https://open.kattis.com/problems/guessthedatastructure

const (
	PUSH = iota + 1
	POP
)

const (
	IS_STACK = uint8(iota)
	IS_QUEUE
	IS_PRIO_Q
	NOT_SURE
	IMPOSSIBLE
)

func main() {
	input := os.Getenv("GOPATH") + filepath.Join("/src/code/guessthedatastructure/in")

	file, _ := os.Open(input)
	io := bufio.NewScanner(file)

	var sb strings.Builder

	for io.Scan() {
		line := io.Text()
		cases, _ := strconv.Atoi(line)

		ops := getOperations(io, cases)
		structure := calcStructure(ops)

		// Only the 2nd test is NOT_SURE (stack + pq)
		switch structure {
		case IS_STACK:
			sb.WriteString("stack\n")
		case IS_QUEUE:
			sb.WriteString("queue\n")
		case IS_PRIO_Q:
			sb.WriteString("priority queue\n")
		case NOT_SURE:
			sb.WriteString("not sure\n")
		default:
			sb.WriteString("impossible\n")
		}
	}
	fmt.Print(sb.String())
}

func calcStructure(ops []int) uint8 {
	if stackTest(ops) {
		if queueTest(ops) || prioQTest(ops) {
			return NOT_SURE
		}
		return IS_STACK
	}
	if queueTest(ops) {
		if prioQTest(ops) {
			return NOT_SURE
		}
		return IS_QUEUE
	}
	if prioQTest(ops) {
		return IS_PRIO_Q
	}
	return IMPOSSIBLE
}

func getOperations(io *bufio.Scanner, operations int) []int {
	var cmds []int
	for i := 0; i < operations; i++ {
		io.Scan()
		line := strings.Fields(io.Text())
		num1, _ := strconv.Atoi(line[0])
		num2, _ := strconv.Atoi(line[1])
		cmds = append(cmds, num1, num2)
	}
	return cmds
}

func stackTest(ops []int) bool {
	s := &Stack{}
	for i := 0; i < len(ops); i += 2 {
		if ops[i] == PUSH {
			s.Push(ops[i+1])
		} else {
			if s.IsEmpty() {
				return false
			}
			top := ops[i+1]
			peek, _ := s.Peek()
			if peek == top {
				s.Pop()
			} else {
				return false
			}
		}
	}
	return true
}

func queueTest(ops []int) bool {
	q := &Queue{}
	for i := 0; i < len(ops); i += 2 {
		if ops[i] == PUSH {
			q.Enqueue(ops[i+1])
		} else {
			if q.IsEmpty() {
				return false
			}
			next := ops[i+1]
			peek, _ := q.Dequeue()
			if peek != next {
				return false
			}
		}
	}
	return true
}

func prioQTest(ops []int) bool {
	pq := NewMaxPQ()
	for i := 0; i < len(ops); i += 2 {
		if ops[i] == PUSH {
			pq.Insert(*NewItem(ops[i+1], ops[i+1]))
		} else {
			if pq.Len() == 0 {
				return false
			}
			next := ops[i+1]
			if pq.Extract().Priority != next {
				return false
			}
		}
	}
	return true
}
