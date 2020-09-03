/*
506. Relative Ranks
 */
package main

import (
	"sort"
	"strconv"
)

func findRelativeRanks(nums []int) []string {
	var copy []int
	for _, num := range nums {
		copy = append(copy, num)
	}
	sort.Ints(copy)
	indexMap := make(map[int]int)
	for index, value := range copy {
		indexMap[value] = index
	}
	result := make([]string, len(nums))
	for i, num := range nums {
		index := len(nums) - indexMap[num]
		if index == 1 {
			result[i] = "Gold Medal"
		} else if index == 2 {
			result[i] = "Silver Medal"
		} else if index == 3 {
			result[i] = "Bronze Medal"
		} else {
			result[i] = strconv.Itoa(index)
		}
	}
	return result
}