package main

import "fmt"

func main()  {
	fmt.Printf("steps %d", minSteps(6))
}

func minSteps(n int) int {
	if n == 1 {
		return 0
	}
	var cache [][]int
	for i := 0; i <= n / 2; i++ {
		var current []int
		for j := 0; j <= n; j++ {
			current = append(current, -2)
		}
		cache = append(cache, current)
	}
	cache[0][0] = 0
	cache[0][1] = 1
	for j := 2; j <= n; j++ {
		cache[0][j] = -1
	}
	for i := 1; i <= n / 2; i++ {
		cache[i][0] = -1
	}
	m := n
	for i := 0; i <= n / 2; i++ {
		t := times_AA(cache, i, n)
		if t == -1 {
			continue
		}
		if t < m {
			m = t
		}
	}
	return m
}

func times_AA(cache [][]int, i, j int) int {

	if i < 0 || j < 0 {
		return -1
	}
	if i > j {
		cache[i][j] = -1
		return -1
	}
	if i == j {
		t := j
		for k := 1; k < i; k++ {
			c := times_AA(cache, k, j)
			if c != -1 && c < t {
				t = c
			}
		}
		cache[i][j] = t + 1
		return t + 1
	}
	if cache[i][j] != -2 {
		return cache[i][j]
	}
	t := times_AA(cache, i, j-i)
	if t == -1 {
		cache[i][j] = -1
	} else {
		cache[i][j] = t + 1
	}
	return cache[i][j]
}