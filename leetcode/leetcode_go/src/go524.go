package main

import (
	"fmt"
	"strings"
)

func main()  {
	s := "abpcplea"
	t := "apple"
	fmt.Printf("result %s", getByDelete(s, t))
}

func findLongestWord(s string, d []string) string {
	result := ""
	for _, t := range d {
		if getByDelete(s, t) {
			if len(t) > len(result) {
				result = t
			} else if len(t) == len(result) {
				if strings.Compare(t, result) == -1 {
					result = t
				}
			}
		}
	}
	return result
}

func getByDelete(s, t string) bool {
	p := 0
	for i := 0; i < len(t); i++ {
		ch := t[i]
		c, ok := getChar(s, ch, p)
		if ok {
			p = c + 1
		} else {
			return false
		}
	}
	return true
}

func getChar(s string, t uint8, p int) (int, bool){
	for j := p; j < len(s); j++ {
		if s[j] == t {
			return j, true
		}
	}
	return 0, false
}