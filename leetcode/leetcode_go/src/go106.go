package main

func buildTree106(inorder []int, postorder []int) *TreeNode {
	return getTree(inorder, 0, len(inorder)-1, postorder, 0, len(postorder)-1)
}

func getTree106(inorder []int, a, b int, postorder []int, c, d int)  *TreeNode {
	if a > b {
		return nil
	}
	current := postorder[d]
	p := position(current, inorder, a, b)
	root := &TreeNode{current, nil, nil}
	root.Left = getTree(inorder, a, p-1, postorder, c, p-1-a+c)
	root.Right = getTree(inorder, p+1, b, postorder, p-a+c, d-1)
	return root
}

func position106(target int, inorder []int, c, d int) int {
	for i := c; i <= d; i++ {
		if inorder[i] == target {
			return i
		}
	}
	return 0;
}
