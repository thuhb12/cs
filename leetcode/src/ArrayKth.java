/*
215. Kth Largest Element in an Array
 */
public class ArrayKth {

    public static void main(String[] args) {
        ArrayKth arrayKth = new ArrayKth();
        int[] s = {3,2,3,1,2,4,5,5,6};
        System.out.println(arrayKth.findKthLargest(s, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        int t = nums.length - k;
        int left = 0;
        int right = nums.length-1;
        int p = partition(nums, left, right);
        while (true) {
            if (p == t) {
                return nums[p];
            } else if (p < t) {
                p = partition(nums, p+1, right);
            } else {
                p = partition(nums, left, p-1);
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }

            int a = nums[i];
            nums[i] = nums[j];
            nums[j] = a;
        }
        nums[left] = nums[j];
        nums[j] = pivot;
        return j;
    }
}
