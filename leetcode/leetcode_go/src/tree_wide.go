package main

import (
	"container/list"
)
/**
 * Definition for a binary tree node.
 */

func widthOfBinaryTree(root *TreeNode) int {
	if root == nil {
		return 0
	}
	s := list.New()
	t := list.New()
	wide := 0
	root.Val = 0
	s.PushFront(root)
	for s.Len() > 0 {
		first := s.Front().Value.(*TreeNode)
		last := s.Back().Value.(*TreeNode)
		if last.Val - first.Val + 1 > wide {
			wide = last.Val - first.Val + 1
		}
		for e := s.Front(); e != nil; e = e.Next() {
			current := e.Value.(*TreeNode)
			if current.Left != nil {
				current.Left.Val = current.Val * 2
				t.PushBack(current.Left)
			}
			if current.Right != nil {
				current.Right.Val = current.Val * 2 + 1
				t.PushBack(current.Right)
			}
		}
		s = t
		t = list.New()
	}
	return wide
}
