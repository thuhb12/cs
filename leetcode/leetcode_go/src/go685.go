package main

import "fmt"

func main()  {
	edges := [][]int{
		{1, 2},
		{1, 3},
		{2, 3},
	}
	fmt.Printf("delete %v",findRedundantDirectedConnection(edges))
}

func findRedundantDirectedConnection(edges [][]int) []int {
	graph := make(map[int][]int)
	for i := 0; i < len(edges); i++ {
		u := edges[i][0]
		v := edges[i][1]
		graph[v] = append(graph[v], u)
	}
	path := findRedundantConnection(edges)
	visited := make(map[int]int)
	for _, num := range path {
		visited[num] = 1
	}
	fmt.Printf("circle %v", path)
	current := -1
	for i := 0; i < len(path)-1; i++ {
		if len(graph[path[i]]) > 1 {
			current = path[i]
			break
		}
	}
	if current != -1 {
		index := -1
		for _, s := range graph[current] {
			if visited[s] == 0 {
				continue
			}
			p := get_edge_position(edges, s, current)
			if p > index {
				index = p
			}
		}
		return edges[index]
	}
	index := 0
	for i := 0; i < len(path)-1; i++ {
		p := get_edge_position(edges, path[i], path[i+1])
		if p > index {
			index = p
		}
	}
	return edges[index]
}


type circle struct {
	path *[]int
	find bool
}

func findRedundantConnection(edges [][]int) []int {
	graph := make(map[int][]int)
	for i := 0; i < len(edges); i++ {
		u := edges[i][0]
		v := edges[i][1]
		graph[u] = append(graph[u], v)
		graph[v] = append(graph[v], u)
	}
	var path []int
	marked := make(map[int]int)
	c := &circle{nil, false}
	graph_dfs(graph, marked, c, 1, 1, path)
	circle_path := *c.path
	return circle_path
}

func graph_dfs(graph map[int][]int, marked map[int]int, c *circle, s int, t int, path []int)  {
	marked[t] = 1
	path = append(path, t)
	if c.find {
		return
	}
	for _, u := range graph[t] {
		if marked[u] == 0 {
			graph_dfs(graph, marked, c, t, u, path)
		} else if u != s {
			if c.find {
				return
			}
			c.find = true
			cp := get_circle(path, u)
			c.path = &cp
		}
	}
}

func get_circle(path []int, s int) []int {
	var cp []int
	start := 0
	for i := 0; i < len(path); i++ {
		if path[i] == s {
			start = i
			break
		}
	}
	for start < len(path) {
		cp = append(cp, path[start])
		start++
	}
	cp = append(cp, s)
	return cp
}

func get_edge_position(edges [][]int, s, u int) int {
	for i := 0; i < len(edges); i++ {
		if s == edges[i][0] && u == edges[i][1] {
			return i
		}
	}
	return -1
}