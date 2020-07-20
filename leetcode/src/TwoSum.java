/*
167. Two Sum II - Input array is sorted
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] s = new int[2];
        for (int i = 0, j = numbers.length-1; i < j;) {
            if (numbers[i] + numbers[j] == target) {
                s[0] = i + 1;
                s[1] = j + 1;
                return s;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return s;
    }
}
