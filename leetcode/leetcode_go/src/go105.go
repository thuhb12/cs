package main

func buildTree(preorder []int, inorder []int) *TreeNode {
	return getTree(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
}

func getTree(preorder []int, a, b int, inorder []int, c, d int)  *TreeNode {
	if a > b {
		return nil
	}
	current := preorder[a]
	p := position(current, inorder, c, d)
	root := &TreeNode{current, nil, nil}
	root.Left = getTree(preorder, a+1, p-c+a, inorder, c, p-1)
	root.Right = getTree(preorder, p-c+a+1, b, inorder, p+1, d)
	return root
}

func position(target int, inorder []int, c, d int) int {
	for i := c; i <= d; i++ {
		if inorder[i] == target {
			return i
		}
	}
	return 0;
}
