package main

func combine(n int, k int) [][]int {
	var result [][]int
	var path []int
	dfsCombine(1, k, n, path, &result)
	return result
}

func dfsCombine(start int, target int, n int, path []int, allPath *[][]int) {
	if len(path) == target {
		*allPath = append(*allPath, getIntPath(path))
	}
	if n - start + 1 + len(path) < target {
		return
	}
	for j := start; j <= n; j++ {
		dfsCombine(j+1, target, n, append(path, j), allPath)
	}
}

func getIntPath(path []int) []int {
	var cp []int
	for _, num := range path {
		cp = append(cp, num)
	}
	return cp
}
