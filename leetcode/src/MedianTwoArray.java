/*
4. Median of Two Sorted Arrays
 */
public class MedianTwoArray {

    public static void main(String[] args) {
        MedianTwoArray medianTwoArray = new MedianTwoArray();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(medianTwoArray.findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            int a = len / 2;
            int b = a + 1;
            int first =
                findMedianSortedArrays(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, a);
            int second =
                findMedianSortedArrays(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, b);
            return (first + second + 0.0) / 2;
        }
        return
            findMedianSortedArrays(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2+1);
    }

    private int findMedianSortedArrays(int[] nums1, int low1, int high1, int[] nums2, int low2, int high2, int k) {
        if (low1 > high1) {
            return nums2[low2+k-1];
        }
        if (low2 > high2) {
            return nums1[low1+k-1];
        }
        int p = low1 + k / 2;
        p = Math.min(p, high1);
        int right = findInsertPosition(nums2, low2, high2, nums1[p]);
        int n = p - low1 + 1 + right - low2;
        if (n > k) {
            return findMedianSortedArrays(nums1, low1, p-1, nums2, low2, right-1, k);
        } else if (n == k) {
            return nums1[p];
        } else {
            return findMedianSortedArrays(nums1, p+1, high1, nums2, right, high2, k-n);
        }
    }

    private int findInsertPosition(int[] nums, int left, int right, int target) {
        int low = left;
        int high = right+1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }
}
