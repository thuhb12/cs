package main

import "sort"

func maxSatisfaction(satisfaction []int) int {
	sort.Ints(satisfaction)
	negative := 0
	for i := 0; i < len(satisfaction); i++ {
		if satisfaction[i] < 0 {
			negative += satisfaction[i]
		} else {
			break
		}
	}
	positive := 0
	for i := len(satisfaction) - 1; i >= 0; i-- {
		if satisfaction[i] > 0 {
			positive += satisfaction[i]
		} else {
			break
		}
	}
	i := 0
	for i = 0; i < len(satisfaction); i++ {
		if negative > 0 {
			break
		}
		profit := -negative - positive
		if profit < 0 {
			break
		} else {
			negative -= satisfaction[i]
		}
	}
	depth := 1
	all := 0
	for j := i; j < len(satisfaction); j++ {
		all += depth * satisfaction[j]
		depth++
	}
	return all
}
