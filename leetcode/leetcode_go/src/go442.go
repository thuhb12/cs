package main

func findDuplicates(nums []int) []int {
	var result []int
	for i := 0; i < len(nums); i++ {
		p := nums[i]
		if p < 0 {
			p = -p
		}

		if nums[p-1] < 0 {
			result = append(result, p)
		} else {
			nums[p-1] = -nums[p-1]
		}
	}
	return result
}
