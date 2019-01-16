package Leetcode.Binary_Search.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Heaters_475 {

    /***
     * Note: my binary search will return correct index if it find target in array or the index that this target
     * should be placed if target not found in array.
     *
     * If it's the second case, then arr[index - 1] is the largest number that less than target, and arr[index] is
     * the smallest number that larger than target. [..., arr[index-1], array[index], ...]
     *                                                                       ^     "target should be placed here"
     *                                                                      target
     *
     * so the new array after placing target is:    [..., arr[index-1], target, arr[index], ...]
     *
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        List<Integer> list = new ArrayList<Integer>();

        for (Integer h : houses) {
            int left = 0;
            int right = heaters.length - 1;
            int minR = -1;

            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (heaters[middle] == h) {
                    minR = 0;
                    break;
                } else if (heaters[middle] < h) left = middle + 1;
                else right = middle - 1;
            }

            if (minR == -1) {
                int index = left;

                int dist1 = index >= 1 ? h - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - h : Integer.MAX_VALUE;

                minR = Math.min(dist1, dist2);

            }
            list.add(minR);
        }

        return Collections.max(list);
    }
}
