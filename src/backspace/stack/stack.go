package main

type Node struct {
	data byte
	next *Node
}

type Stack struct {
	top *Node
}

func (list *Stack) Push(i byte) {
	data := &Node{data: i}
	if list.top != nil {
		data.next = list.top
	}
	list.top = data
}

func (list *Stack) Pop() (byte, bool) {
	if list.top == nil {
		return 0, false
	}
	i := list.top.data
	list.top = list.top.next
	return i, true
}

func (list *Stack) Peek() (byte, bool) {
	if list.top == nil {
		return 0, false
	}
	return list.top.data, true
}

func (list *Stack) Get() []byte {

	var items []byte

	current := list.top
	for current != nil {
		items = append(items, current.data)
		current = current.next
	}
	return items
}

func (list *Stack) IsEmpty() bool {
	return list.top == nil
}

func (list *Stack) Empty() {
	list.top = nil
}
