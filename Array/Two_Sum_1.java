package Leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return new int[]{map.get(nums[i]), i};
            map.put(target-nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Two_Sum_1 t = new Two_Sum_1();
        int[] res = t.twoSum(new int[]{1,2,3,4}, 7);
        System.out.println(res);


    }
}

