package Leetcode.Binary_Search.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection_of_Two_Arrays_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
       List<Integer> list = new ArrayList<>();
       Set<Integer> set = new HashSet<>();

       for (Integer n : nums1) {
           set.add(n);
       }
       for (Integer n : nums2) {
           if (set.contains(n)) {
               list.add(n);
               set.remove(n);
           }
       }

       int[] result = new int[list.size()];
       for (int i = 0; i < list.size(); i++) { result[i] = list.get(i); }

       return result;
    }

}
