/*
33 & 81 & 153 & 154 Find Minimum in Rotated Sorted Array
 */
public class RotateMin {
    public static void main(String[] args) {
        RotateMin rotateMin = new RotateMin();
        int[] s = {1, 3, 1, 1, 1};
        System.out.println(rotateMin.findMin(s));
    }

    public int search(int[] nums, int target) {
        int mid = findMin(nums);
        int a = find(nums, mid, nums.length-1, target);
        int b = find(nums, 0, mid-1, target);
        if (a == -1 && b == -1) {
            return -1;
        }
        return a == -1 ? b : a;
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[left]) {
                right = mid - 1;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                int m = nums[left];
                int p = left;
                for (int i = left; i <= right; i++) {
                    if (nums[i] < m) {
                        m = nums[i];
                        p = i;
                    }
                }
                return p;
            }
        }
        return left;
    }

    private int find(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
