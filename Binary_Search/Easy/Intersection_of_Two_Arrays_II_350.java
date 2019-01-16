package Leetcode.Binary_Search.Easy;

import java.util.*;

public class Intersection_of_Two_Arrays_II_350 {

    public int[] intersect_sort(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();

        int i = 0; int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] res = new int[list.size()];
        for (int itr = 0; itr < res.length; itr++) {
            res[itr] = list.get(itr);
        }
        return res;
    }

    public int[] intersect_hashmap(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n1 : nums1) {
            map.put(n1, 1 + map.getOrDefault(n1,0));
        }
        for (Integer n2 : nums2) {
            if (map.containsKey(n2) && map.get(n2) > 0) {
                list.add(n2);
                map.put(n2, map.get(n2) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int itr = 0; itr < res.length; itr++) {
            res[itr] = list.get(itr);
        }
        return res;
    }
}
