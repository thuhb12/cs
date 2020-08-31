package main

import "fmt"

func main()  {
	fmt.Printf("result: %d", firstMissingPositive([]int{1, 1}))
}

func firstMissingPositive(nums []int) int {

	for i := 0; i < len(nums); i++ {
		if nums[i] <= 0 {
			nums[i] = len(nums) + 2
		}
	}

	for i := 0; i < len(nums); i++ {
		p := nums[i]
		if p < 0 {
			p = -p
		}
		if p > len(nums) {
			continue
		}
		if nums[p-1] > 0 {
			nums[p-1] = - nums[p-1]
		}
	}

	for i := 0; i < len(nums); i++ {
		if nums[i] > 0 {
			return i + 1
		}
	}
	return len(nums) + 1
}
