package main



type NestedInteger struct {
	Flag bool
	Value int
	Rest []*NestedInteger
}

// Return true if this NestedInteger holds a single integer, rather than a nested list.
func (this NestedInteger) IsInteger() bool {
	return this.Flag
}
// Return the single integer that this NestedInteger holds, if it holds a single integer
// The result is undefined if this NestedInteger holds a nested list
// So before calling this method, you should have a check
func (this NestedInteger) GetInteger() int {
	return this.Value
}
// Set this NestedInteger to hold a single integer.
func (n *NestedInteger) SetInteger(value int) {
	n.Flag = true
	n.Value = value
}
// Set this NestedInteger to hold a nested list and adds a nested integer to it.
func (this *NestedInteger) Add(elem NestedInteger) {
	this.Rest = append(this.Rest, &elem)
}
// Return the nested list that this NestedInteger holds, if it holds a nested list
// The list length is zero if this NestedInteger holds a single integer
// You can access NestedInteger's List element directly if you want to modify it
func (this NestedInteger) GetList() []*NestedInteger {
	return this.Rest
}

type NestedIterator struct {
	index int
	nums []int
}

func Constructor(nestedList []*NestedInteger) *NestedIterator {
	var nums []int
	flat(nestedList, &nums)
	return &NestedIterator{0, nums}
}

func flat(nestedList []*NestedInteger, nums *[]int) {
	for _, nestedInteger := range nestedList {
		if (*nestedInteger).IsInteger() {
			*nums = append(*nums, (*nestedInteger).GetInteger())
		} else {
			flat(nestedInteger.GetList(), nums)
		}
	}
}

func (this *NestedIterator) Next() int {
	tmp := this.nums[this.index]
	this.index++
	return tmp
}

func (this *NestedIterator) HasNext() bool {
	return this.index < len(this.nums)
}