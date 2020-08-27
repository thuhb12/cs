/*
1363. Largest Multiple of Three
 */
package main

import (
	"sort"
	"strconv"
)
func LargestMultipleOfThree(digits []int) string {
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
	sort.Ints(zero)
	if zero[0] == 0 {
		return "0"
	}
	result := ""
	for i := 0; i < len(zero); i++ {
		result += strconv.Itoa(zero[i])
	}
	return result
}

