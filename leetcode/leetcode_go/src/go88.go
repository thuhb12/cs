package main

func merge(nums1 []int, m int, nums2 []int, n int)  {
	for i := m-1; i >= 0; i-- {
		nums1[i+n] = nums1[i]
	}
	start := 0
	i := n
	j := 0
	for i < m + n && j < n {
		if nums1[i] <= nums2[j] {
			nums1[start] = nums1[i];
			i++
			start++
		} else {
			nums1[start] = nums2[j];
			j++
			start++
		}
	}
	if i < m + n {
		for i < m + n {
			nums1[start] = nums1[i];
			start++
			i++
		}
	} else {
		for j < n {
			nums1[start] = nums2[j];
			j++
			start++
		}
	}
}