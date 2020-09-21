package main

import "fmt"

func main()  {
	edges := [][]int{
		{1, 5},
		{2, 5},
		{1, 2},
		{2, 4},
		{2, 3},
	}
	fmt.Printf("delete %v", edges)
}
//
//type circle struct {
//	path *[]int
//	find bool
//}
//
//func findRedundantConnection(edges [][]int) []int {
//	graph := make(map[int][]int)
//	for i := 0; i < len(edges); i++ {
//		u := edges[i][0]
//		v := edges[i][1]
//		graph[u] = append(graph[u], v)
//		graph[v] = append(graph[v], u)
//	}
//	var path []int
//	marked := make(map[int]int)
//	c := &circle{nil, false}
//	graph_dfs(graph, marked, c, 1, 1, path)
//	index := 0
//	circle_path := *c.path
//	for i := 0; i < len(circle_path)-1; i++ {
//		p := get_edge_position(edges, circle_path[i], circle_path[i+1])
//		if p > index {
//			index = p
//		}
//	}
//	return edges[index]
//}
//
//func graph_dfs(graph map[int][]int, marked map[int]int, c *circle, s int, t int, path []int)  {
//	marked[t] = 1
//	path = append(path, t)
//	if c.find {
//		return
//	}
//	for _, u := range graph[t] {
//		if marked[u] == 0 {
//			graph_dfs(graph, marked, c, t, u, path)
//		} else if u != s {
//			if c.find {
//				return
//			}
//			c.find = true
//			cp := get_circle(path, u)
//			c.path = &cp
//		}
//	}
//}
//
//func get_circle(path []int, s int) []int {
//	var cp []int
//	start := 0
//	for i := 0; i < len(path); i++ {
//		if path[i] == s {
//			start = i
//			break
//		}
//	}
//	for start < len(path) {
//		cp = append(cp, path[start])
//		start++
//	}
//	cp = append(cp, s)
//	return cp
//}
//
//func get_edge_position(edges [][]int, s, u int) int {
//	for i := 0; i < len(edges); i++ {
//		if s == edges[i][0] && u == edges[i][1] {
//			return i
//		}
//		if u == edges[i][0] && s == edges[i][1] {
//			return i
//		}
//	}
//	return -1
//}