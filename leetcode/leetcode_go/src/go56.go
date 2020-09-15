package main

import (
	"sort"
)

type Interval struct {
	start int
	end int
}

type Intervals []Interval

func (intervals Intervals) Len() int {
	return len(intervals)
}

func (intervals Intervals) Less(i, j int) bool {
	return intervals[i].start < intervals[j].start
}

func (intervals Intervals) Swap(i, j int)  {
	intervals[i], intervals[j] = intervals[j], intervals[i]
}

func merge56(intervals [][]int) [][]int {
	var intervalList Intervals
	for i := 0; i < len(intervals); i++ {
		start, end := intervals[i][0], intervals[i][1]
		intervalList = append(intervalList, Interval{start, end})
	}
	sort.Sort(intervalList)
	var result [][]int
	i := 0
	for i < len(intervalList) {
		interval := intervalList[i]
		start, end := interval.start, interval.end
		j := i + 1
		for j < len(intervalList) {
			next := intervalList[j]
			nextStart, nextEnd := next.start, next.end
			if nextStart <= end {
				end = max_int(end, nextEnd)
				j++
			} else {
				break
			}
		}
		s := []int{start, end}
		result = append(result, s)
		i = j
	}
	return result
}

func max_int(a, b int) int {
	if a < b {
		return b
	}
	return a
}
