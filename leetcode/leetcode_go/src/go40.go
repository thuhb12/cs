package main

func combinationSum2(candidates []int, target int) [][]int  {
	numMap := make(map[int]int, 0)
	for _, num := range candidates {
		numMap[num]++
	}
	var nums []int
	var count []int
	for k, v := range numMap {
		nums = append(nums, k)
		count = append(count, v)
	}
	return combinationSum(nums, target, count)
}

func combinationSum(candidates []int, target int, count []int) [][]int {
	cache := make([][][][]int, target+1)
	var current [][][]int
	for i := 0; i <= target; i++ {
		current = make([][][]int, len(candidates)+1)
		cache[i] = current
	}
	for j := 0; j < len(candidates)+1; j++ {
		e := make([]int, 0)
		var l [][]int
		l = append(l, e)
		cache[0][j] = l
	}
	for i := 1; i <= target; i++ {
		l := make([][]int, 0);
		cache[i][0] = l
	}
	for i := 1; i <= target; i++ {
		for j := 1; j <= len(candidates); j++ {
			num := i / candidates[j-1]
			var result [][]int
			for used := 0; used <= num && used <= count[j-1]; used++ {
				cp := copyList(&cache[i-candidates[j-1]*used][j-1])
				for start := 0; start < len(cp); start++ {
					addTimes(&cp[start], candidates[j-1], used)
					result = append(result, cp[start])
				}
			}
			cache[i][j] = result
		}
	}
	return cache[target][len(candidates)]
}

func addTimes(l *[]int, a, times int)  {
	for i := 0; i < times; i++ {
		*l = append(*l, a)
	}
}

func copyList(s *[][]int) [][]int {
	var result [][]int
	for _, l := range *s {
		var c []int
		for _, num := range l {
			c = append(c, num)
		}
		result = append(result, c)
	}
	return result
}