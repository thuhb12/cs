/*
14. Third Maximum Number
 */

public class ThirdLargeNum {
    public static void main(String[] args) {
        ThirdLargeNum thirdLargeNum = new ThirdLargeNum();
        int[] s = {3, 2, 1};
        System.out.println(thirdLargeNum.thirdMax(s));
    }

    public int thirdMax(int[] nums) {
        int current = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < nums.length; i++) {
            if (current == 0) {
                first = nums[i];
                current++;
            } else if (current == 1) {
                if (nums[i] > first) {
                    second = nums[i];
                    current++;
                } else if (nums[i] < first) {
                    second = first;
                    first = nums[i];
                    current++;
                }
            } else if (current == 2) {
                if (nums[i] < first) {
                    third = second;
                    second =first;
                    first = nums[i];
                    current++;
                } else if (first < nums[i] && nums[i] < second) {
                    third = second;
                    second = nums[i];
                    current++;
                } else if (nums[i] > second) {
                    third = nums[i];
                    current++;
                }
            } else if (current == 3) {
                if (nums[i] < first) {
                } else if (first < nums[i] && nums[i] < second) {
                    first = nums[i];
                } else if (second < nums[i] && nums[i] < third) {
                    first = second;
                    second = nums[i];
                } else if (nums[i] > third) {
                    first = second;
                    second = third;
                    third = nums[i];
                }
            }
        }
        if (current == 1) {
            return first;
        } else if (current == 2) {
            return second;
        } else if (current == 3) {
            return first;
        }
        return 0;
    }
}
