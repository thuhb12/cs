package main

func replaceElements(arr []int) []int {
	result := make([]int, len(arr))
	if len(arr) == 0 {
		return result
	}
	max := arr[len(arr)-1]
	result[len(arr)-1] = -1
	for i := len(arr)-2; i >= 0; i-- {
		result[i] = max
		if arr[i] > max {
			max = arr[i]
		}
	}
	return result
}