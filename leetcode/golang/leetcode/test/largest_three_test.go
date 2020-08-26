package test

import (
	"sort"
	"strconv"
	"testing"
)
func largestMultipleOfThree(digits []int) string {
	var zero []int
	var one []int
	var two []int
	for i := 0; i < len(digits); i++ {
		if (digits[i] % 3 == 0) {
			zero = append(zero, digits[i])
		} else if (digits[i] % 3 == 1) {
			one = append(one, digits[i])
		} else if (digits[i] % 3 == 2) {
			two = append(two, digits[i])
		}
	}
	for i := 0; i < len(one) && i < len(two); i++ {
		zero = append(zero, one[i])
		zero = append(zero, two[i])
	}
	if len(zero) == 0 {
		return ""
	}
	sort.Sort(sort.Reverse(sort.IntSlice(zero)))
	if zero[0] == 0 {
		return "0"
	}
	result := ""
	i := 0
	for ; i < len(zero); i++ {
		result += strconv.Itoa(zero[i])
	}

	return result
}

func TestLargestMultipleOfThree(t *testing.T) {

	t.Run("saying hello to people", func(t *testing.T) {
		got := largestMultipleOfThree([]int{8, 6, 7, 1, 0})
		want := "8760"

		if got != want {
			t.Errorf("got '%q' want '%q'", got, want)
		}
	})
}

