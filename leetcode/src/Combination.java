import java.util.ArrayList;
import java.util.List;

/*
77. Combinations
 */
public class Combination {
    public static void main(String[] args) {
        Combination combination = new Combination();
        System.out.println(combination.combine(4, 2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] cache = new int[n+1];
        List<Integer> list = new ArrayList<>();
        combine(k, cache, 1, list, result);
        return result;
    }

    public void combine(int k, int[] cache, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= cache.length-1; i++) {
            if (cache[i] == 0) {
                cache[i] = 1;
                current.add(i);
                combine(k, cache, i+1, current, result);
                cache[i] = 0;
                current.remove(current.size()-1);
            }
        }
    }
}
