package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

type depthNode struct {
	depth int
	val int
}

func main()  {
	s := "1-2-5"
	fmt.Printf("s: %s, tree %v", s, recoverFromPreorder(s))
}

func recoverFromPreorder(S string) *TreeNode {
	var nodes []depthNode
	start := 0
	depth := 0
	index := 0
	value := 0
	for start < len(S) {
		if S[start] == '-' {
			depth, index = getDepth(S, start)
			start = index+1
		} else {
			value, index = getNumber(S, start)
			start = index+1
			nodes = append(nodes, depthNode{depth, value})
		}
	}
	return build_tree(nodes, 0, len(nodes)-1)
}

func build_tree(nodes []depthNode, a, b int) *TreeNode {
	if a > b {
		return nil
	}
	currentNode := nodes[a]
	root := &TreeNode{currentNode.val, nil, nil}
	if a == b {
		return root
	}
	p, ok := get_position(nodes, a, b)
	if ok {
		root.Left = build_tree(nodes, a+1, p-1)
		root.Right = build_tree(nodes, p, b)
	} else {
		root.Left = build_tree(nodes, a+1, b)
	}
	return root
}

func get_position(nodes []depthNode, a, b int) (int, bool) {
	for i := b; i > a+1; i-- {
		if nodes[i].depth == nodes[a+1].depth {
			return i, true
		}
	}
	return 0, false
}

func getNumber(s string, p int) (int, int) {
	n := 0
	for i := p; i < len(s); i++ {
		if s[i] == '-' {
			return n, i-1
		} else {
			current := s[i] - '0'
			n = n * 10 + int(current)
		}
	}
	return n, len(s)-1
}

func getDepth(s string, p int) (int, int) {
	count := 0
	for i := p; i < len(s); i++ {
		if s[i] == '-' {
			count++
		} else {
			return count, i-1
		}
	}
	return count, len(s)-1
}
