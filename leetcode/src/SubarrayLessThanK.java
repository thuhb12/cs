public class SubarrayLessThanK {
    public static void main(String[] args) {
        SubarrayLessThanK subarrayLessThanK = new SubarrayLessThanK();
        int[] s = {10,5,2,6};
        System.out.println(subarrayLessThanK.numSubarrayProductLessThanK(s, 100));
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                left = i;
                break;
            }
        }
        int i = left;
        int j = left;
        int product = 1;
        int count = 0;
        while (true) {

            if (i >= nums.length) {
                break;
            }
            while (j < nums.length) {
                product *= nums[j];
                if (product >= k) {
                    product /= nums[j];
                    break;
                }
                j++;
            }
            count += (j-i+1)*(j-i)/2;
            i++;
        }

        return 0;
    }
}
