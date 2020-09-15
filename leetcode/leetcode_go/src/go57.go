package main

import "fmt"

func main()  {
	intervals := [][]int{
		//{1, 2},
		//{3, 5},
		//{6, 7},
		//{8, 10},
		//{12, 16},
	}
	interval := []int{4, 8}
	fmt.Printf("position %v", insert(intervals, interval))
}

func insert(intervals [][]int, newInterval []int) [][]int {
	var nums []int
	if (len(intervals) <= 0) {
		intervals = append(intervals, newInterval)
		return intervals
	}
	for i := 0; i < len(intervals); i++ {
		nums = append(nums, intervals[i][0])
	}
	start, end := newInterval[0], newInterval[1]
	left := find_insert_position(nums, start)
	right := find_insert_position(nums, end)
	if left > 0 {
		pre := intervals[left-1]
		if start <= pre[1] {
			left--
		}
	}
	if right == len(intervals)  {
		right--
	} else {
		next := intervals[right]
		if end < next[0] {
			right--
		}
	}
	var result [][]int
	for i := 0; i < left; i++ {
		result = append(result, intervals[i])
	}
	s := intervals[left][0]
	e := intervals[right][1]
	if start < s {
		s = start
	}
	if end > e {
		e = end
	}
	result = append(result, []int{s, e})
	for i := right+1; i < len(intervals); i++ {
		result = append(result, intervals[i])
	}
	return result
}

func find_insert_position(nums []int, target int) int {
	left, right := 0, len(nums)
	for left < right {
		mid := left + (right - left) / 2
		if nums[mid] == target {
			right = mid
		} else if nums[mid] > target {
			right = mid
		} else {
			left = mid + 1
		}
	}
	if left < len(nums) {
		if nums[right] >= target {
			return right
		} else {
			return right+1
		}
	} else {
		return left
	}
}