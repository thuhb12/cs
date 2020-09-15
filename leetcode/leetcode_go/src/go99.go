package main

import (
	"container/list"
	"fmt"
)

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func main()  {
	one := &TreeNode{1, nil, nil}
	two := &TreeNode{2, nil, nil}
	three := &TreeNode{3, nil, nil}
	one.Right = three
	three.Right = two
	recoverTree(one)
	fmt.Printf("[]int: %v", inorder_traversal(one))
}

func recoverTree(root *TreeNode)  {
	recover(root)
}

func recover(root *TreeNode) bool {
	if root == nil {
		return false
	}
	small := get_small(root.Right, root)
	big := get_big(root.Left, root)
	if small != nil && big != nil {
		small.Val, big.Val = big.Val, small.Val
		return true
	} else if small == nil && big == nil {
		if recover(root.Left) {
			return true
		}
		if recover(root.Right) {
			return true
		}
	} else if small != nil {
		big = root
		small.Val, big.Val = big.Val, small.Val
		return true
	} else if big != nil {
		small = root
		small.Val, big.Val = big.Val, small.Val
		return true
	}
	return false
}

func get_small(root *TreeNode, target *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	var small *TreeNode
	if root.Val < target.Val {
		small = get_small(root.Right, root)
		if small != nil {
			return small
		}
		return root
	}
	small = get_small(root.Left, target)
	if small != nil {
		return small
	}
	return get_small(root.Right, target)
}

func get_big(root *TreeNode, target *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	var big *TreeNode
	if root.Val > target.Val {
		big = get_big(root.Left, root)
		if big != nil {
			return big
		}
		return root
	}
	big = get_big(root.Left, target)
	if big != nil {
		return big
	}
	return get_big(root.Right, target)
}

func inorder_traversal(root *TreeNode) []int {
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