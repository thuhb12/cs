package main

func constructFromPrePost(pre []int, post []int) *TreeNode {
	return getTree(pre, 0, len(pre)-1, post, 0, len(post)-1)
}

func getTree889(pre []int, a, b int, post []int, c, d int)  *TreeNode {
	if a > b {
		return nil
	}
	current := pre[a]
	root := &TreeNode{current, nil, nil}
	if a == b {
		return root
	}
	next := pre[a+1]
	p := position(next, post, c, d)
	root.Left = getTree(pre, a+1, p-c+a+1, post, c, p)
	root.Right = getTree(pre, p-c+a+2, b, post, p+1, d-1)
	return root
}

func position889(target int, inorder []int, c, d int) int {
	for i := c; i <= d; i++ {
		if inorder[i] == target {
			return i
		}
	}
	return 0;
}