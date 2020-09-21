package main

func minNumberOperations(target []int) int {
	return times(target, 0, len(target)-1)
}

func timesII(target[] int)  {

}

func times(target []int, left, right int) int {
	if left > right {
		return 0
	}
	if left == right {
		return target[left]
	}
	min := target[left]
	for i := left; i <= right; i++ {
		if target[i] < min {
			min = target[i]
		}
	}
	time := min
	for i := left; i <= right; i++ {
		target[i] -= min
	}
	low := -1
	high := -1
	find := false
	for i := left; i <= right; i++ {
		if target[i] != 0 {
			if find {
			} else {
				find = true
				low = i
			}
		} else {
			if find {
				high = i-1
				time += times(target, low, high)
				find = false
			} else {

			}
		}
	}
	if find {
		time += times(target, low, right)
	}
	return time
}
