package main


func canVisitAllRooms(rooms [][]int) bool {
	var marked []int
	for i := 0; i < len(rooms); i++ {
		marked = append(marked, 0)
	}
	dfs(rooms, 0, marked)
	for i := 0; i < len(marked); i++ {
		if marked[i] == 0 {
			return false
		}
	}
	return true
}

func dfs(rooms [][]int, s int, marked []int)  {
	marked[s] = 1
	for _, u := range rooms[s] {
		if marked[u] == 0 {
			dfs(rooms, u, marked)
		}
	}
}