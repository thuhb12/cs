package main


func levelOrder(root *Node) [][]int {
	var result [][]int
	if root == nil {
		return result
	}
	var s []*Node
	var t []*Node
	s = append(s, root)
	for len(s) > 0 {
		var current []int
		for _, node := range s {
			current = append(current, node.Val)
			if len(node.Children) > 0 {
				for _, child := range node.Children {
					t = append(t, child)
				}
			}
		}
		result = append(result, current)
		s = t
		t = make([]*Node, 0)
	}
	return result
}
