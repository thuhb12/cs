/*
540. Single Element in a Sorted Array
 */

public class SingleDuplicate {
    public static void main(String[] args) {
        int[] s = {1, 2, 2, 3, 3, 4, 4, 8, 8};
        SingleDuplicate singleDuplicate = new SingleDuplicate();
        System.out.println(singleDuplicate.singleNonDuplicate(s));
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 != 0) {
                if (nums[mid] == nums[mid-1]) {
                    left = mid + 1;
                } else if (nums[mid] == nums[mid+1]) {
                    right = mid - 1;
                } else {
                    return nums[mid];
                }
            } else {
                if (nums[mid] == nums[mid-1]) {
                    right = mid - 2;
                } else if (nums[mid] == nums[mid+1]) {
                    left = mid+2;
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[left];
    }
}
