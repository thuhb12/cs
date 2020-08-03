import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
523. Continuous Subarray Sum
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] s = {0, 0};
        System.out.println(subarraySum.checkSubarraySum(s, -1));
        System.out.println(0 % -1);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = -1; j <= i-2; j++) {
                    if (sum[i] - get(sum, j) == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> start = new ArrayList<>();
        start.add(-1);
        map.put(0, start);
        for (int i = 0; i < sum.length; i++) {
            int m = sum[i] % k;
            List<Integer> list = map.get(m);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                map.put(m, list);
            } else {
                int left = list.get(0);
                if (i - left > 1) {
                    return true;
                }
            }
        }
        return false;
    }
    private int get(int[] s, int p) {
        if (p >= 0 && p < s.length) {
            return s[p];
        }
        return 0;
    }
}
