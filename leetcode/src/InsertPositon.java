public class InsertPositon {
    public static void main(String[] args) {
        InsertPositon insertPositon = new InsertPositon();
        int[] s = {1};
        System.out.println(insertPositon.findRight(s, 0, s.length, 1));
    }
    public int[] searchRange(int[] nums, int target) {
        int a = findLeft(nums, 0, nums.length, target);
        int b = findRight(nums, 0, nums.length, target);
        return new int[]{a, b};
    }

    private int findLeft(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findRight(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left-1 >= 0 && left-1 < nums.length && nums[left-1] == target) {
            return left - 1;
        }
        return -1;
    }
}
