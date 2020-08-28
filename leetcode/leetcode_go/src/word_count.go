package main

func countSegments(s string) int {
	find := false
	length := 0
	count := 0
	for _, ch := range s {
		if ch != ' ' {
			if find {
				length++
			} else {
				find = true
				length++
			}
		} else {
			if find {
				find = false
				length = 0
				count++
			} else {

			}
		}
	}
	if length > 0 {
		count++
	}
	return count
}