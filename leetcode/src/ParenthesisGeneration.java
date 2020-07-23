import java.util.ArrayList;
import java.util.List;

/*
class Solution {
     public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List[][] cache = (List<List<Integer>>[][]) new List[candidates.length+1][target+1];
        for (int i = 0; i <= candidates.length; i++) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();
            list.add(result);
            cache[i][0] = list;
        }
        for (int j = 1; j <= target; j++) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            cache[0][j] = list;
        }
        for (int i = 1; i <= candidates.length; i++) {
            for (int j = 1; j <= target; j++) {
                ArrayList<List<Integer>> list = new ArrayList<>();
                List<List<Integer>> pre;
                if (j - candidates[i-1] >= 0) {
                    pre = copy(cache[i][j - candidates[i-1]]);
                    for (List<Integer> lowList: pre) {
                        lowList.add(candidates[i-1]);
                        list.add(lowList);
                    }
                }
                pre = copy(cache[i-1][j]);
                for (List<Integer> lowList: pre) {
                    list.add(lowList);
                }
                cache[i][j] = list;
            }
        }
        return cache[candidates.length][target];
    }

}
22. Generate Parentheses
 */
public class ParenthesisGeneration {

    public static void main(String[] args) {
        ParenthesisGeneration parenthesisGeneration = new ParenthesisGeneration();
        System.out.println(parenthesisGeneration.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String>[] cache = new List[n+1];
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        cache[0] = list;
        list = new ArrayList<>();
        list.add("()");
        cache[1] = list;
        for (int i = 2; i <= n; i++) {
            list = new ArrayList<>();
            for (int j = 0; j <= i-1; j++) {
                List<String> left = addParent(deepCopy(cache[j]));
                List<String> right = deepCopy(cache[i-1-j]);
                for (String l : left) {
                    for (String r : right) {
                        list.add(l+r);
                    }
                }
            }
            cache[i] = list;
        }
        return cache[n];
    }

    private List<String> addParent(List<String> list) {
        List<String> generateList = new ArrayList<>();
        for (String s : list) {
            generateList.add(String.format("(%s)", s));
        }
        return generateList;
    }

    private List<String> deepCopy(List<String> list) {
        List<String> copyList = new ArrayList<>();
        for (String s : list) {
            copyList.add(new String(s));
        }
        return  copyList;
    }

}
