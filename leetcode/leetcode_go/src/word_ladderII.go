package main

import (
	"container/list"
	"fmt"
)

func main()  {
	wordlist := []string{"ted","rex", "tex"}
	fmt.Printf("distance: %v", findLadders("red", "tex", wordlist))
}

func findLadders(beginWord string, endWord string, wordList []string) [][]string {
	graph := make(map[string][]string)
	var next []string
	for j := 0; j < len(wordList); j++ {
		if distance_ii(beginWord, wordList[j]) {
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
			if distance_ii(current, wordList[j]) {
				arrive = append(arrive, wordList[j])
			}
		}
		graph[current] = arrive
	}
	dis := bfs_ii(beginWord, endWord, graph)
	var all_path [][]string
	marked := make(map[string]int)
	for k, _ := range graph {
		marked[k] = 0
	}
	dfs_ii(beginWord, endWord, graph, &all_path, 0, dis, marked, list.New())

	return all_path
}

func dfs_ii(s, t string, graph map[string][]string, all_path *[][]string, depth, total int, marked map[string]int, path *list.List)  {
	if depth > total {
		return
	}
	marked[s] = 1
	path.PushBack(s)
	if s == t {
		*all_path = append(*all_path, list_to_slice(path))
		marked[s] = 0
		path.Remove(path.Back())
		return
	}
	for _, u := range graph[s] {
		if marked[u] == 0 {
			dfs_ii(u, t, graph, all_path, depth+1, total, marked, path)
		}
	}
	marked[s] = 0
	path.Remove(path.Back())
}

func list_to_slice(path *list.List) []string {
	var result []string
	for i := path.Front(); i != nil; i = i.Next() {
		s := i.Value.(string)
		result = append(result, s)
	}
	return result
}

func bfs_ii(s, t string, graph map[string][]string) int {
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

func distance_ii(a, b string) bool {
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
