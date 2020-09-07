package main

func findRestaurant(list1 []string, list2 []string) []string {
	restaurantIndexMap := make(map[string]int)
	for index, str := range list1 {
		restaurantIndexMap[str] = index
	}
	m := len(list1) + len(list2)
	for index, str := range list2 {
		p, ok := restaurantIndexMap[str]
		if ok {
			m = min(m, p + index)
		}
	}
	var result []string
	for index, str := range list2 {
		p, ok := restaurantIndexMap[str]
		if ok && p + index == m {
			result = append(result, str)
		}
	}
	return result
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}