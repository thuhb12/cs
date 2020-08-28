package main

import "fmt"

func main()  {
	s := "abcdef"

	var sl []int32
	charMap :=  make(map[int32]int)
	for  _, ch := range s {
		charMap[ch] = charMap[ch]+1
		sl = append(sl, ch)
	}
	for k, v := range charMap {
		fmt.Printf("key %c, value : %d\n", k, v)
	}
	fmt.Printf("sl type %T value %v", 'A', sl[0])

}
