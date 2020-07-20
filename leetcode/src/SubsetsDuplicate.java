import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
90. Subsets II
 */
public class SubsetsDuplicate {
    public static void main(String[] args) {
        SubsetsDuplicate subsets = new SubsetsDuplicate();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsets.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int current : map.keySet()) {
            result = product(result, getList(current, map.get(current)));
        }
        return result;
    }

    private List<List<Integer>> product(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> left : a) {
            for (List<Integer> right : b) {
                List<Integer> copyLeft = new ArrayList(left);
                List<Integer> copyRight = new ArrayList<>(right);
                copyLeft.addAll(copyRight);
                result.add(copyLeft);
            }
        }
        return result;
    }

    private List<List<Integer>> getList(int a, int times) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= times; i++) {
            result.add(get(a, i));
        }
        return result;
    }

    private List<Integer> get(int a, int times) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            list.add(a);
        }
        return list;
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
