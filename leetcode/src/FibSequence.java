import java.util.HashMap;
import java.util.Map;

public class FibSequence {
    public static void main(String[] args) {
        FibSequence fibSequence = new FibSequence();
        int[] arr = {2,3,4,5};
        System.out.println(fibSequence.lenLongestFibSubseq(arr));
    }
    public int lenLongestFibSubseq(int[] A) {
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] cache = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            cache[i][i] = 1;
        }
        for (int i = 0; i < A.length-1; i++) {
            map.put(A[i], 1);
            for (int j = i + 1; j < A.length; j++) {
                int diff = A[j] - A[i];
                int pre = map.getOrDefault(A[i] - diff, 0);
                if (pre > 0) {
                    map.put(A[j], pre+2);
                    max = Math.max(max, pre+2);
                }
            }
        }
        return max;
    }
}
