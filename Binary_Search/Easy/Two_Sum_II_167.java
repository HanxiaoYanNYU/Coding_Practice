package Leetcode.Binary_Search.Easy;

public class Two_Sum_II_167 {

    /***
     * Solution 1:
     * Use recursive binary search, time-complexity O(nlogn)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(i + 1, numbers.length - 1, numbers, target - numbers[i]);
            if (j != -1) {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }

    private static int binarySearch(int left, int right, int[] numbers, int target) {
        if (left > right) return -1;

        int middle = (left + right) / 2;

        if (numbers[middle] < target) return binarySearch(middle + 1, right, numbers, target);
        else if (numbers[middle] > target) return binarySearch(left, middle - 1, numbers, target);
        else return middle;
    }

    /***
     * Solution 2:
     * Two pointer, time-complexity O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            if (numbers[left] + numbers[right] < target) {
                left++;
                continue;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
