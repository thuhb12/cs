package main


type count struct {
	num int
}

type point struct {
	x int
	y int
}

func uniquePathsIII(grid [][]int) int {
	var visited [][]int
	total := 0
	var start point
	for i := 0; i < len(grid); i++ {
		var current []int
		for j := 0; j < len(grid[i]); j++ {
			current = append(current, 0)
			if grid[i][j] == 0 {
				total++
			} else if grid[i][j] == 1 {
				start = point{i, j}
			}
		}
		visited = append(visited, current)
	}
	pathNum := &count{0}
	dfs_matrix(grid, visited, start.x, start.y, 0, total, pathNum)
	return pathNum.num
}

func dfs_matrix(grid [][]int, visited [][]int, i, j int, currentDepth int, targetDepth int, pathNum *count)  {
	visited[i][j] = 1
	if currentDepth == targetDepth {
		if i > 0 && grid[i-1][j] == 2 {
			pathNum.num++
		}
		if i < len(grid)-1 && grid[i+1][j] == 2 {
			pathNum.num++
		}
		if j > 0 && grid[i][j-1] == 2 {
			pathNum.num++
		}
		if j < len(grid[0])-1 && grid[i][j+1] == 2 {
			pathNum.num++
		}
	} else {
		if i > 0 && grid[i-1][j] == 0 && visited[i-1][j] == 0 {
			dfs_matrix(grid, visited, i-1, j, currentDepth+1, targetDepth, pathNum)
		}
		if i < len(grid)-1 && grid[i+1][j] == 0 && visited[i+1][j] == 0 {
			dfs_matrix(grid, visited, i+1, j, currentDepth+1, targetDepth, pathNum)
		}
		if j > 0 && grid[i][j-1] == 0 && visited[i][j-1] == 0 {
			dfs_matrix(grid, visited, i, j-1, currentDepth+1, targetDepth, pathNum)
		}
		if j < len(grid[0])-1 && grid[i][j+1] == 0 && visited[i][j+1] == 0 {
			dfs_matrix(grid, visited, i, j+1, currentDepth+1, targetDepth, pathNum)
		}
	}
	visited[i][j] = 0
}
