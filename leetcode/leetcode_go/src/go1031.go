package main

type KthLen struct {
	left int
	right int
	value int
}

func maxSumTwoNoOverlap(A []int, L int, M int) int {
	s := 0
	for i := 0; i < L+M; i++ {
		s += A[i]
	}
	l := getKthLen(A, L)
	m := getKthLen(A, M)
	for _, first := range l {
		for _, second := range m {
			if exist(first, second) && first.value + second.value > s {
				s = first.value + second.value
			}
		}
	}
	return s
}

func exist(a, b KthLen)  bool {
	return b.left > a.right || a.left > b.right
}


func getKthLen(nums []int, k int) []KthLen {
	var result []KthLen
	sum := 0
	for i := 0; i < k; i++ {
		sum += nums[i]
	}
	result = append(result, KthLen{0, k-1, sum})
	for i := 1; i + k - 1 < len(nums); i++ {
		sum -= nums[i-1]
		sum += nums[i+k-1]
		result = append(result, KthLen{i, i+k-1, sum})
	}
	return result
}