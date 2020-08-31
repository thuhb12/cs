package main

import "fmt"

func main()  {
	wordlist := []string{"ted","tex","red","tax","tad","den","rex","pee"}
	fmt.Printf("distance: %d", ladderLength("red", "tax", wordlist))
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	graph := make(map[string][]string)
	var next []string
	for j := 0; j < len(wordList); j++ {
		if distance(beginWord, wordList[j]) {
			next = append(next, wordList[j])
		}
	}
	graph[beginWord] = next
	for i := 0; i < len(wordList); i++ {
		var arrive []string
		current := wordList[i]
		for j := 0; j < len(wordList); j++ {
			if (i == j) {
				continue
			}
			if distance(current, wordList[j]) {
				arrive = append(arrive, wordList[j])
			}
		}
		graph[current] = arrive
	}
	dis := bfs(beginWord, endWord, graph)
	if dis != 0 {
		return dis + 1
	}
	return 0
}

func bfs(s, t string, graph map[string][]string) int {
	var queue []string
	var next []string
	marked := make(map[string]int)
	for k, _ := range graph {
		marked[k] = 0
	}
	dis := 0
	queue = append(queue, s)
	marked[s] = 1
	for len(queue) > 0 {
		dis++
		for _, current := range queue {
			for _, u := range graph[current] {
				if u == t {
					return dis
				} else if marked[u] == 0 {
					marked[u] = 1
					next = append(next, u)
				}
			}
		}
		queue = next
		next = make([]string, 0)
	}
	return 0
}

func distance(a, b string) bool {
	count := 0
	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			count++
			if count > 1 {
				return false
			}
		}
	}
	return count == 1
}