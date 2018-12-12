package Leetcode.Google;

import java.util.HashSet;
import java.util.Set;

public class Fruit_into_Baskets_904 {

    /**
     * Brute Force
     * Time Limit Exceed, O(n^2)
     *
     * @param tree
     * @return
     */
    public int totalFruit_0(int[] tree) {
        int amount = -1;
        Set<Integer> fruits = new HashSet<>();
        int i; int j;

        for (i = 0; i < tree.length; i++) {
            fruits.add(tree[i]);
            for (j = i + 1; j < tree.length; j++) {
                fruits.add(tree[j]);
                if (fruits.size() > 2) break;
            }
            amount = j - i > amount ? j - i : amount;
            fruits.clear();
        }
        return amount;
    }

    /**
     * Sliding Window, and use Set to store fruits
     * Accepted, O(n)
     *
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        int left = 0;
        int right = -1;
        int amount = -1;
        Set<Integer> fruits = new HashSet<>();

        while (right < tree.length - 1) {
            right++;
            fruits.add(tree[right]);

            if (fruits.size() > 2) {
                amount = right - left > amount ? right - left : amount;
                int new_left = right - 1;
                int fruit = tree[new_left];
                while (left < new_left) {
                    if (tree[new_left] == fruit) new_left--;
                    else break;
                }
                fruits.remove(tree[new_left]);
                left = new_left + 1;
            }
        }
        amount = right - left + 1 > amount ? right - left + 1: amount;
        return amount;
    }
}
