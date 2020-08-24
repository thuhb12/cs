package dp;
/*
1563. Stone Game V
 */
public class StoneGame {
    public int stoneGameV(int[] stoneValue) {
        int[] pre = new int[stoneValue.length+1];
        pre[0] = 0;
        for (int i = 1; i <= stoneValue.length; i++) {
            pre[i] = pre[i-1] + stoneValue[i-1];
        }
        int[][] cache = new int[stoneValue.length][stoneValue.length];
        for (int i = 0; i < stoneValue.length; i++) {
            for (int j = 0; j < stoneValue.length; j++) {
                cache[i][j] = -1;
            }
        }
        getStoneValue(cache, pre, 0, stoneValue.length-1);
        return cache[0][stoneValue.length-1];
    }

    private int getStoneValue(int[][] cache, int[] pre, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            cache[left][right] = 0;
            return 0;
        }
        if (cache[left][right] != -1) {
            return cache[left][right];
        }
        int m = 0;
        int circle = 0;
        for (int i = left; i <= right; i++) {
            int leftSum = pre[i+1] - pre[left];
            int rightSum = pre[right+1] - pre[i+1];
            if (leftSum == rightSum) {
                circle = Math.max(getStoneValue(cache, pre, left, i), getStoneValue(cache, pre, i+1, right))
                    + leftSum;
            } else if (leftSum > rightSum) {
                circle = rightSum + getStoneValue(cache, pre, i+1, right);
            } else {
                circle = leftSum + getStoneValue(cache, pre, left, i);
            }
            m = Math.max(m, circle);
        }
        cache[left][right] = m;
        return m;
    }

}
