import java.util.ArrayList;
import java.util.List;

/*
78. Subsets
 */
public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    public List<List<Integer>> subsets(int[] nums, int p) {
        List<List<Integer>> result = new ArrayList<>();
        if (p == nums.length) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        List<List<Integer>> rest = subsets(nums, p + 1);
        List<List<Integer>> current = new ArrayList<>();
        for (List<Integer> list : rest) {
            List<Integer> copy = new ArrayList<>(list);
            copy.add(nums[p]);
            current.add(copy);
        }
        rest.addAll(current);
        return rest;
    }

}
