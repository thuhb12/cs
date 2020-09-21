package main

func convertBST(root *TreeNode) *TreeNode {
	if (root == nil) {
		return root
	}
	convert(root, 0)
	return root
}

func convert(root *TreeNode, val int) int {
	if (root.Left == nil && root.Right == nil) {
		root.Val += val
		return root.Val
	} else if (root.Left != nil && root.Right != nil) {
		right := convert(root.Right, val)
		root.Val += right
		left := convert(root.Left, root.Val)
		return left
	} else if (root.Left != nil) {
		root.Val += val
		left := convert(root.Left, root.Val)
		return left
	} else {
		right := convert(root.Right, val)
		root.Val += right
		return root.Val
	}
}
