package main

import (
	"fmt"
	"strconv"
)

func main()  {
	fmt.Printf("bits %v", readBinaryWatch(7))
}
func readBinaryWatch(num int) []string {
	var result []string

	hours := initHour()
	minutes := initMinute()
	for i := 0; i <= num && i <= 4; i++ {
		if num - i > 6 {
			continue
		}
		for _, hour := range hours[i] {
			for _, minute := range minutes[num-i] {
				hourString := strconv.Itoa(hour)
				minuteString := ""
				if (minute < 10) {
					minuteString = "0" + strconv.Itoa(minute)
				} else {
					minuteString = strconv.Itoa(minute)
				}
				result = append(result, hourString+":"+minuteString)
			}
		}
	}
	return result
}

func initHour() [][]int {
	var result [][]int
	for i := 0; i < 5; i++ {
		var sl []int
		result = append(result, sl)
	}
	for i := 0; i < 12; i++ {
		bits := getBit(i)
		result[bits] = append(result[bits], i)
	}
	return result
}

func initMinute() [][]int {
	var result [][]int
	for i := 0; i < 7; i++ {
		var sl []int
		result = append(result, sl)
	}
	for i := 0; i < 60; i++ {
		bits := getBit(i)
		result[bits] = append(result[bits], i)
	}
	return result
}

func getBit(num int) int {
	count := 0
	for num > 0 {
		if (num % 2 != 0) {
			count++
		}
		num /= 2
	}
	return count
}
