package main
/*
144, 94, 145 binary tree travel
 */

import (
	"container/list"
	"fmt"
)

//type TreeNode struct {
//     Val int
//     Left *TreeNode
//     Right *TreeNode
//}

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

func main()  {
	one := &TreeNode{1, nil, nil}
	two := &TreeNode{2, nil, nil}
	three := &TreeNode{3, nil, nil}
	one.Right = two
	two.Left = three
	fmt.Printf("[]int: %v", postorderTraversal(one))
}

func preorderTraversal(root *TreeNode) []int {
	var result []int
	stack := list.New()
	current := root
	for current != nil || stack.Len() > 0 {
		if current == nil {
			current = stack.Front().Value.(*TreeNode)
			stack.Remove(stack.Front())
		}
		result = append(result, current.Val)
		if current.Right != nil {
			stack.PushFront(current.Right)
		}
		current = current.Left
	}
	return result
}

func inorderTraversal(root *TreeNode) []int {
	var result []int
	stack := list.New()
	visited := make(map[*TreeNode]int)
	current := root
	for current != nil || stack.Len() > 0 {
		if current != nil {
			_, ok := visited[current]
			if ok {
				result = append(result, current.Val)
				current = current.Right
			} else {
				stack.PushFront(current)
				visited[current] = 1
				current = current.Left
			}
		} else {
			current = stack.Front().Value.(*TreeNode)
			stack.Remove(stack.Front())
		}
	}
	return result
}

func postorderTraversal(root *TreeNode) []int {
	var result []int
	current := root
	visited := make(map[*TreeNode]int)
	stack := list.New()
	for current != nil || stack.Len() > 0 {
		if current != nil {
			_, ok := visited[current]
			if ok {
				result = append(result, current.Val)
			} else {
				stack.PushFront(current)
				visited[current] = 1
				if current.Right != nil {
					stack.PushFront(current.Right)
				}
				if current.Left != nil {
					stack.PushFront(current.Left)
				}
			}
			current = nil
		} else {
			current = stack.Front().Value.(*TreeNode)
			stack.Remove(stack.Front())
		}
	}
	return result
}
