package Leetcode.Array;

public class Container_With_Most_Water_11 {

    // 如果想找到更大的area，最好的策略是每次都移动shorter bar.
    // 因为移动higher bar只可能让新的area比之前的更小。只有移动shorter bar才有可能让新的area更大
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, (right-left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
