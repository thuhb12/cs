package main

import (
	"fmt"
	"strconv"
)

func main()  {
	s := []int{3, 1, 5, 8}
	fmt.Printf("coins: %d", maxCoins(s))
}

func maxCoins(nums []int) int {
	cache := make(map[string]int)
	maxCoin(nums, cache)
	key := getStringFromArray(nums)
	return cache[key]
}

func maxCoin(nums []int, cache map[string]int) int {
	key := getStringFromArray(nums)
	value, ok := cache[key]
	if ok {
		return value
	}
	max := 0
	for i := 0; i < len(nums); i++ {
		subarray := getSubArray(nums, i)
		currentCoin := getCoin(nums, i)
		rest := maxCoin(subarray, cache)
		if currentCoin + rest > max {
			max = currentCoin + rest
		}
	}
	cache[key] = max
	return max
}

func getCoin(nums []int, p int) int {
	left := p - 1
	right := p + 1
	a := 1
	b := 1
	if left >= 0 {
		a = nums[left]
	}
	if right < len(nums) {
		b = nums[right]
	}
	return a * b * nums[p]
}

func getStringFromArray(nums []int) string {
	var s = ""
	for i, v := range nums {
		if i < len(nums) - 1 {
			s += strconv.Itoa(v)
			s += ","
		} else {
			s += strconv.Itoa(v)
		}
	}
	return s
}

func getSubArray(s []int, p int) []int {
	var subarray []int
	for i := 0; i < len(s); i++ {
		if i == p {
		} else {
			subarray = append(subarray, s[i])
		}
	}
	return subarray
}