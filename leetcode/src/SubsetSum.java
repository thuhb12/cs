/*
416. Partition Equal Subset Sum
 */
public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int[] s = {1, 2, 3, 5};
        System.out.println(subsetSum.canPartition(s));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return getTarget(nums, target);
    }

    private boolean getTarget(int[] nums, int target) {
        int[][] cache = new int[target+1][nums.length+1];
        for (int j = 0; j <= nums.length; j++) {
            cache[0][j] = 1;
        }
        for (int i = 1; i <= target; i++) {
            cache[i][0] = 0;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                int f = 0;
                if (nums[j-1] <= i) {
                    f += cache[i - nums[j-1]][j-1];
                }
                f += cache[i][j-1];
                if (f > 0) {
                    cache[i][j] = 1;
                }
            }
        }
        return cache[target][nums.length] == 1;
    }
}
