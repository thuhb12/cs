package main

func findMaxConsecutiveOnes(nums []int) int {
	find := false
	length := 0
	maxLen := 0
	for _, num := range nums {
		if num == 1 {
			if find {
				length++
			} else {
				find = true
				length++
			}
		} else {
			if length > maxLen {
				maxLen = length
			}
			length = 0
			find = false
		}
	}
	if length > maxLen {
		return length
	}
	return maxLen
}