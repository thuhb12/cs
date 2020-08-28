package main

func judgeSquareSum(c int) bool {
	i := 0
	j := c
	for i <= j  {
		sum := i * i + j * j
		if sum == c {
			return true
		} else if sum > c {
			j--
		} else {
			i++
		}
	}
	return false
}
