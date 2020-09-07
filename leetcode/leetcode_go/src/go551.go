package main

func checkRecord(s string) bool {
	absent := 0
	late := false
	for index, ch := range s {
		if ch == 'A' {
			absent++
		} else if ch == 'L' {
			if index > 1 && s[index-1] == 'L' && s[index-2] == 'L'{
				late = true
			}
		}
		if absent >= 2 && late {
			return false
		}
	}
	return true
}