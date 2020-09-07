package main

import "strconv"

//type TreeNode struct {
//  Val int
//  Left *TreeNode
//  Right *TreeNode
//}

func binaryTreePaths(root *TreeNode) []string {
	var result []string
	var path []int
	getPath(root, &path, &result)
	return result
}

func getPath(root *TreeNode, path *[]int, allPath *[]string) {
	if root == nil {
		return
	}
	*path = append(*path, root.Val)
	if root.Left == nil && root.Right == nil {
		*allPath = append(*allPath, generatePath(path))
	} else if root.Left != nil && root.Right == nil {
		getPath(root.Left, path, allPath)
	} else if root.Left == nil && root.Right != nil {
		getPath(root.Right, path, allPath)
	} else {
		leftPath := path
		rightPah := copy(path)
		getPath(root.Left, leftPath, allPath)
		getPath(root.Right, rightPah, allPath)
	}
}


func copy(path *[]int) *[]int {
	var slice []int
	for _, num := range *path {
		slice = append(slice, num)
	}
	return &slice
}

func generatePath(path *[]int) string {
	var str string
	for i := 0; i < len(*path); i++ {
		if (i < len(*path) - 1) {
			str += strconv.Itoa((*path)[i]) + "->"
		} else {
			str += strconv.Itoa((*path)[i])
		}
	}
	return str
}