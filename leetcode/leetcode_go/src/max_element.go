package main

func findFrequentTreeSum(root *TreeNode) []int {
	sumMap := make(map[int]int)
	var result []int
	if root == nil {
		return result
	}
	calculate(root, sumMap)
	m := 0
	for _, v := range sumMap {
		if v > m {
			m = v
		}
	}
	for k, v := range sumMap {
		if v == m {
			result = append(result, k)
		}
	}
	return result
}

func calculate(root *TreeNode, sumMap map[int]int) int {
	left := 0
	if root.Left != nil {
		left = calculate(root.Left, sumMap)
	}
	right := 0
	if root.Right != nil {
		right = calculate(root.Right, sumMap)
	}
	sum := left + right + root.Val
	sumMap[sum] = sumMap[sum]+1
	return sum
}


