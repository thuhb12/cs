package main

import (
	"fmt"
	"strconv"
)

type path struct {
	step int
}

type start struct {
	x int
	y int
}

func main()  {
	board := [][]int{{1, 2, 3}, {5, 4, 0}}
	fmt.Printf("steps %d", slidingPuzzle(board))
}

func slidingPuzzle(board [][]int) int {
	p := &path{1000}
	cache := make(map[string]int)
	s := start{0, 0}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if board[i][j] == 0 {
				s.x = i
				s.y = j
			}
		}
	}
	dfs_puzzle(board, cache, p, s, 0)
	if p.step == 1000 {
		return -1
	}
	return p.step
}

func dfs_puzzle(board [][]int, cache map[string]int, p *path, s start, step int)  {
	key := get_string(board)
	if key == "123450" {
		p.step = min_int(p.step, step)
		//fmt.Printf("current step : %d", p.step)
		return
	}
	if step > p.step {
		return
	}
	cache[key] = 1
	x := s.x
	y := s.y
	if x > 0 {
		cp := copy_puzzle(board)
		cp[x][y] = cp[x-1][y]
		cp[x-1][y] = 0
		t := get_string(cp)
		if cache[t] != 1 {
			dfs_puzzle(cp, cache, p, start{x-1, y}, step+1)
		}
	}
	if y > 0 {
		cp := copy_puzzle(board)
		cp[x][y] = cp[x][y-1]
		cp[x][y-1] = 0
		t := get_string(cp)
		if cache[t] != 1 {
			dfs_puzzle(cp, cache, p, start{x, y-1}, step+1)
		}
	}
	if x < len(board) - 1 {
		cp := copy_puzzle(board)
		cp[x][y] = cp[x+1][y]
		cp[x+1][y] = 0
		t := get_string(cp)
		if cache[t] != 1 {
			dfs_puzzle(cp, cache, p, start{x+1, y}, step+1)
		}
	}
	if y < len(board[0]) - 1 {
		cp := copy_puzzle(board)
		cp[x][y] = cp[x][y+1]
		cp[x][y+1] = 0
		t := get_string(cp)
		if cache[t] != 1 {
			dfs_puzzle(cp, cache, p, start{x, y+1}, step+1)
		}
	}
}

func copy_puzzle(board [][]int) [][]int {
	var cp [][]int
	for i := 0; i < len(board); i++ {
		var current []int
		for j := 0; j < len(board[0]); j++ {
			current = append(current, board[i][j])
		}
		cp = append(cp, current)
	}
	return cp
}

func get_string(board [][]int) string {
	str := ""
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			str += strconv.Itoa(board[i][j])
		}
	}
	return str
}

func min_int(a, b int) int {
	if a < b {
		return a
	}
	return b
}
