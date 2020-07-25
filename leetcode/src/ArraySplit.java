/*
410. Split Array Largest Sum
 */
public class ArraySplit {

    public static void main(String[] args) {
        ArraySplit arraySplit = new ArraySplit();
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(arraySplit.splitArray(nums, 2));
    }

    public int splitArray(int[] nums, int m) {
        int[][] cache = new int[nums.length][nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            cache[i][i] = max;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cache[0][i] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                boolean stop = false;
                boolean first = true;
                int left = i;
                int right = 0;
                for (int k = j; k >= left; k--) {
                    right += nums[k];
                    int s = Math.max(right, cache[i-1][k-1]);
                    if (first) {
                        cache[i][j] = s;
                        first = false;
                    } else {
                        cache[i][j] = Math.min(cache[i][j], s);
                        if (cache[i][j] == right) {
                            stop = true;
                            break;
                        }
                    }

                }
                if (stop) {
                    continue;
                }
            }
        }
        return cache[m-1][nums.length-1];
    }
}
