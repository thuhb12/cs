/*
17. Letter Combinations of a Phone Number
 */
package main

import "fmt"

func main()  {
	digits := "3"
	fmt.Printf("result: %v", letterCombinations(digits))
}

func letterCombinations(digits string) []string {
	if digits == "" {
		return nil;
	}
	var result []string
	if len(digits) == 1 {
		result = get(digits)
	} else {
		current := get(digits[0:1])
		rest := letterCombinations(digits[1:])
		for i := 0; i < len(current); i++ {
			pre := current[i]
			for _, s := range rest {
				result = append(result, pre + s)
			}
		}
	}
	return result
}

func get(key string) []string {
	if key == "2" {
		return []string{"a", "b", "c"}
	} else if key == "3" {
		return []string{"d", "e", "f"}
	} else if key == "4" {
		return []string{"g", "h", "i"}
	} else if key == "5" {
		return []string{"j", "k", "l"}
	} else if key == "6" {
		return []string{"m", "n", "o"}
	} else if key == "7" {
		return []string{"p", "q", "r", "s"}
	} else if key == "8" {
		return []string{"t", "u", "v"}
	} else if key == "9" {
		return []string{"w", "x", "y", "z"}
	}
	return nil
}

