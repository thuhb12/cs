package main

import (
	"container/list"
	"fmt"
)

func main()  {
	s := []int{1, 2, 3, 4, 3}
	fmt.Printf("result: %v", nextGreaterElements(s))
}

func nextGreaterElements(nums []int) []int {
	l := list.New()
	for i := len(nums)-1; i >= 0; i-- {
		add(l, nums[i])
	}
	result := make([]int, len(nums))
	for i := len(nums)-1; i >= 0; i-- {
		next, ok := add(l, nums[i])
		if ok {
			result[i] = next
		} else {
			result[i] = -1
		}
	}
	return result
}

func add(l *list.List, e int) (int, bool){
	if l.Len() == 0 {
		l.PushFront(e)
		return 0, false
	}
	first := l.Front().Value.(int)
	if first > e {
		l.PushFront(e)
		return first, true
	} else {
		l.Remove(l.Front())
		return add(l, e)
	}
}

func print(l *list.List)  {
	for i := l.Front(); i != nil; i = i.Next() {
		fmt.Print(i.Value)
		fmt.Print(" ")
	}
	fmt.Println()
}