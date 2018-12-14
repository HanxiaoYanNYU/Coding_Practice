package Leetcode.Google;

import java.util.HashMap;
import java.util.Map;

public class Coupons {

    public static int solution(int[] coupons) {
        if (coupons.length <= 1) return -1;

        Map<Integer, Integer> couponPosition = new HashMap<>();
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < coupons.length; i++) {
            if (!couponPosition.containsKey(coupons[i])) couponPosition.put(coupons[i], i);
            else {
                int nearestPosition = couponPosition.get(coupons[i]);
                len = (i - nearestPosition + 1) < len ? (i - nearestPosition + 1) : len;
                couponPosition.put(coupons[i], i);
            }
        }

        return len == Integer.MAX_VALUE ? -1 : len;
    }
}
