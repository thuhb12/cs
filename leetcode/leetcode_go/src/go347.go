package main

import "fmt"

//todo: there are some bugs
func main()  {
	nums := []int{4,1,-1,2,-1,2,3}
	fmt.Printf("result %v", topKFrequent(nums, 2))
}

type FrequencyNode struct {
	num int;
	count int;
}

func topKFrequent(nums []int, k int) []int {
	numFrequencyMap := make(map[int]int)
	for _, num := range nums {
		numFrequencyMap[num]++
	}
	var nodes []*FrequencyNode
	for k, v := range numFrequencyMap {
		nodes = append(nodes, &FrequencyNode{k, v})
	}
	t := len(nodes) - k;
	topK(nodes, t)
	var result []int
	for i := t; i < len(nodes); i++ {
		result = append(result, nodes[i].num)
	}
	return result
}

func topK(nodes []*FrequencyNode, k int) {
	left, right := 0, len(nodes)-1
	p := partition(nodes, left, right)
	for true {
		if (p == k) {
			return
		} else if (p < k) {
			p = partition(nodes, p+1, right)
		} else {
			p = partition(nodes, left, p-1)
		}
	}
}

func partition(nodes []*FrequencyNode, left, right int) int {
	fmt.Printf("\n left %d, right %d", left, right)
	fmt.Printf("nodes %v %v %v %v %v", nodes[0], nodes[1], nodes[2], nodes[3], nodes[4])

	i, j := left, right
	pivot := nodes[i].count
	for i < j {
		for i <= j && nodes[i].count <= pivot {
			i++
		}
		for j >= i && nodes[j].count >= pivot {
			j--
		}
		if i >= j {
			break
		}
		nodes[i], nodes[j] = nodes[j], nodes[i]
	}
	nodes[left], nodes[j] = nodes[j], nodes[left]
	fmt.Printf("pivot: %d\n", j)
	return j

}
