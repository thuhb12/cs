/*
559. Maximum Depth of N-ary Tree
 */
package main

type Node struct {
    Val int
    Children []*Node
}

func maxDepth(root *Node) int {
	if root == nil {
		return 0
	}
	var nums []int
	for _, child := range root.Children {
		nums = append(nums, maxDepth(child))
	}
	return max(nums) + 1
}

func max(nums []int) int {
	if nums == nil {
		return 0
	}
	m := nums[0]
	for _, num := range nums {
		if num > m {
			m = num
		}
	}
	return m
}