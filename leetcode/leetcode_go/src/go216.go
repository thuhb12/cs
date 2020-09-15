package main

func combinationSum3(k int, n int) [][]int {
	var result [][]int
	var path []int
	dfs_conbine(1, k, path, &result, n)
	return result
}

func dfs_conbine(start int, target int, path []int, allPath *[][]int, sumAll int)  {
	if len(path) == target && sum(path) == sumAll {
		*allPath = append(*allPath, copy_num(path))
	} else {
		for i := start; i <= 9; i++ {
			dfs_conbine(i+1, target, append(path, i), allPath, sumAll)
		}
	}
}

func copy_num(s []int) []int {
	var cp []int
	for _, num := range s {
		cp = append(cp, num)
	}
	return cp
}

func sum(s []int) int {
	sum_all := 0
	for _, num := range s {
		sum_all += num
	}
	return sum_all
}
