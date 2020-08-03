import java.util.HashMap;
import java.util.Map;

/*
1218. Longest Arithmetic Subsequence of Given Difference
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        int[] arr = {1,5,7,8,5,3,4,2,1};
        System.out.println(longestSubsequence.longestSubsequence(arr, -2));
    }
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int pre = map.getOrDefault(current-difference, 0);
            map.put(current, pre+1);
            max = Math.max(max, pre+1);
        }
        return max;
    }
}
