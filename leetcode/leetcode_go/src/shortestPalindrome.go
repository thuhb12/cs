package main

import "fmt"

func main()  {
	s := "a"
	fmt.Printf("result: %s", shortestPalindrome(s))
}

func shortestPalindrome(s string) string {
	result := s + s + s
	l := 0
	if len(s) % 2 == 0 {
		l = len(s) / 2 - 1
	} else {
		l = len(s) / 2
	}
	for i := 0; i <= l; i++ {
		str, ok := getShort(s, i)
		if ok && len(str) < len(result) {
			result = str
		}
		str, ok = getShortEven(s, i, i+1)
		if ok && len(str) < len(result) {
			result = str
		}
	}
	return result
}

func getShort(s string, p int) (string, bool) {
	left := p - 1
	right := p + 1
	for left >= 0  {
		if right >= len(s) || s[left] != s[right] {
			return "", false
		}
		left--
		right++
	}
	c := make([]byte, (len(s)-1-p)*2+1)
	mid := len(c) / 2
	for i := 0; mid + i < len(c); i++ {
		c[mid+i] = s[p+i]
		c[mid-i] = c[mid+i]
	}
	return string(c), true
}

func getShortEven(s string, left, right int) (string, bool) {
	m := left
	n := right
	for m >= 0  {
		if n >= len(s) || s[m] != s[n] {
			return "", false
		}
		m--
		n++
	}
	c := make([]byte, (len(s)-right)*2)
	i := len(c) / 2 - 1
	j := len(c) / 2
	for off := 0; j + off < len(c); off++ {
		c[j+off] = s[right+off]
		c[i-off] = c[j+off]
	}
	return string(c), true
}
