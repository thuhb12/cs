package main

import "sort"

func findUnsortedSubarray(nums []int) int {
	var cp []int
	for _, num := range nums {
		cp = append(cp, num)
	}
	sort.Ints(cp)
	i := 0
	for i < len(nums) {
		if nums[i] != cp[i] {
			break
		} else {
			i++
		}
	}
	j := len(nums) - 1
	for j >= 0 {
		if nums[j] != cp[j] {
			break
		} else {
			j--
		}
	}
	if j < i {
		return 0
	}
	return j - i + 1
}