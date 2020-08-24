package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public int totalFruit(int[] tree) {
        int left = 0;
        int right = 0;
        int total = 0;
        int count = 0;
        Map<Integer, Integer> current = new HashMap<>();
        for (; right < tree.length; right++) {
            int treeType = tree[right];
            current.put(treeType, current.getOrDefault(treeType, 0) + 1);
            count++;
            if (current.keySet().size() > 2) {
                total = Math.max(total, count-1);
                for (; left <= right;) {
                    int treeTypeLeft = tree[left];
                    current.put(treeTypeLeft, current.get(treeTypeLeft)-1);
                    count--;
                    left++;
                    if (current.get(treeTypeLeft) == 0) {
                        current.remove(treeTypeLeft);
                        break;
                    }
                }
            } else {
                total = Math.max(total, count);
            }
        }
        return total;
    }
}
