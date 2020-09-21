package main

import "fmt"

func main()  {
	s := []int{8, 1, 5, 2, 6}
	fmt.Printf("max %d", maxScoreSightseeingPair(s))
}

func maxScoreSightseeingPair(A []int) int {
	var cache []int
	cache = append(cache, A[0])
	for i := 1; i < len(A); i++ {
		if A[i] + i > cache[i-1] {
			cache = append(cache, A[i] + i)
		} else {
			cache = append(cache, cache[i-1])
		}
	}
	m := A[0] + A[1] - 1
	for i := 1; i < len(A); i++ {
		if A[i] - i + cache[i-1] > m {
			m = A[i] - i + cache[i-1]
		}
	}
	return m
}
