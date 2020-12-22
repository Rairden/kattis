package main

type ItemPQ struct {
	Value    interface{}
	Priority int
}

func NewItem(value interface{}, priority int) (i *ItemPQ) {
	return &ItemPQ{
		Value:    value,
		Priority: priority,
	}
}

func (x ItemPQ) Less(than Item) bool {
	return x.Priority < than.(ItemPQ).Priority
}

type PQ struct {
	data Heap
}

func NewMaxPQ() (q *PQ) {
	return &PQ{
		data: *NewMaxHeap(),
	}
}

func NewMinPQ() (q *PQ) {
	return &PQ{
		data: *NewMinHeap(),
	}
}

func (pq *PQ) Len() int {
	return pq.data.Len()
}

func (pq *PQ) Insert(el ItemPQ) {
	pq.data.Insert(Item(el))
}

func (pq *PQ) Extract() (el ItemPQ) {
	return pq.data.Extract().(ItemPQ)
}
