package main

import (
	"container/list"
)

type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
}

func largestValues(root *TreeNode) []int {
	var result []int
	s := list.New()
	t := list.New()
	if (root == nil) {
		return result
	}
	s.PushFront(root)
	for s.Len() > 0 {
		m := s.Front().Value.(*TreeNode).Val
		for i := s.Front(); i != nil; i = i.Next() {
			current := i.Value.(*TreeNode)
			if current.Left != nil {
				t.PushBack(current.Left)
			}
			if current.Right != nil {
				t.PushBack(current.Right)
			}
			if (current.Val > m) {
				m = current.Val
			}
		}
		result = append(result, m)
		s = t
		t = list.New()
	}
	return result
}
