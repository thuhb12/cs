import java.util.HashMap;
import java.util.Map;

/*
594. Longest Harmonious Subsequence
 */
public class FindLhs {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int m = 0;
        for (int left : map.keySet()) {
            int a = map.get(left);
            int b = map.getOrDefault(left + 1, 0);
            if (b == 0) {
                continue;
            } else {
                m = Math.max(m, a+b);
            }
        }
        return m;
    }
}
