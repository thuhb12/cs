public class ThreeParts {
    public boolean canThreePartsEqualSum(int[] A) {
        int[] pre = new int[A.length+1];
        pre[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            pre[i] = pre[i-1] + A[i];
        }
        if (pre[A.length] % 3 != 0) {
            return false;
        }
    }

    private int get(int[] pre, int i, int j) {
        return pre[j+1] - pre[i];
    }
}
