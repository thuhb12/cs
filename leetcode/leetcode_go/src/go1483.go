package main

type TreeAncestor struct {
	nums *[]int
	cache map[int]map[int]int
}


func Constructor(n int, parent []int) TreeAncestor {
	cache := make(map[int]map[int]int)
	return TreeAncestor{&parent, cache}
}


func (this *TreeAncestor) GetKthAncestor(node int, k int) int {
	if node == -1 {
		return -1
	}
	parent, ok := this.cache[node][k]
	if ok {
		return parent
	}
	if k == 0 {
		return node
	}
	if k == 1 {
		return (*this.nums)[node]
	}
	mid := k / 2
	midParent := this.GetKthAncestor(node, mid)
	if this.cache[node] == nil {
		this.cache[node] = make(map[int]int)
	}
	this.cache[node][mid] = midParent
	return this.GetKthAncestor(midParent, k - mid)
}
