package main

func judgeCircle(moves string) bool {
	u := 0
	d := 0
	l := 0
	r := 0
	for _, ch := range moves {
		switch ch {
		case 'U':
			u++
		case 'D':
			d++
		case 'L':
			l++
		case 'R':
			r++
		}
	}
	return u == d && l == r
}