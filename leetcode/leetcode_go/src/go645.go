package main

func findErrorNums(nums []int) []int {
	numMap := make(map[int]int)
	for _, num := range nums {
		numMap[num]++
	}
	duplicate := 0
	missNum := 0
	for i := 1; i <= len(nums); i++ {
		count, ok := numMap[i]
		if ok && count == 2 {
			duplicate = i
		}
		if !ok {
			missNum = i
		}
	}
	return []int{duplicate, missNum}
}
