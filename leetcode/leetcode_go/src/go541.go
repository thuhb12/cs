package main

import "fmt"

func main()  {
	fmt.Printf("s %s", reverseStr("abcdefg", 2))
}

func reverseStr(s string, k int) string {
	c := []byte(s)
	start := 0
	for start < len(s) {
		reverse(c, start, start+k-1)
		start += 2 * k
	}
	return string(c)
}

func reverse(c []byte, start, end int) {
	for start < end {
		c[start], c[end] = c[end], c[start]
		start++
		end--
	}
}
