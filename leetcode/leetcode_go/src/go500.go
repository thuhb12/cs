package main

func findWords(words []string) []string {
	one := "zxcvbnmZXCVBNM"
	two := "asdfghjklASDFGHJKL"
	three := "qwertyuiopQWERTYUIOP"
	charMap := make(map[int32]int)
	for _, char := range one {
		charMap[char] = 1
	}
	for _, char := range two {
		charMap[char] = 2
	}
	for _, char := range three {
		charMap[char] = 3
	}
	var result []string
	for _, str := range words {
		level := charMap[int32(str[0])]
		flag := true
		for _, char := range str {
			if charMap[char] != level {
				flag = false
				break
			}
		}
		if flag {
			result = append(result, str)
		}
	}
	return result
}