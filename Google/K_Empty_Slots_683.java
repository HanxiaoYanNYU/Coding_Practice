package Leetcode.Google;

public class K_Empty_Slots_683 {

    /**
     * Time Limit Exceed, O(n^2)
     *
     * Use char array to remember flower bloom position, e.g. ['0','1','0','0'], '1' is bloom flower
     * Use String.split("1", -1) to get '0' sections and use the size of each section to check if length satisfy k
     *
     * @param flowers
     * @param k
     * @return
     */
    public static int kEmptySlots_0(int[] flowers, int k) {

        char[] bloom_place = new char[flowers.length];
        for (int i = 0; i < bloom_place.length; i++) { bloom_place[i] = '0'; }

        for (int i = 0; i < flowers.length; i++) {
            bloom_place[flowers[i] - 1] = '1';
            String[] s = new String(bloom_place).split("1", -1);
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() == k && j != s.length - 1 && j!= 0) return i + 1;
            }
        }
        return -1;
    }

    /**
     * Since we need to check the length between two flowers, we came up with an idea of creating a new array
     * which index is the flower position, value is the blossom day
     *
     * O(n)
     *
     * @param flowers
     * @param k
     * @return
     */
    public static int kEmptySlots(int[] flowers, int k) {
        int res = Integer.MAX_VALUE;

        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }

        int left = 0;
        int right = left + k + 1;
        for (int i = left + 1; right < days.length; i++) {
            if (i == right) {
                res = Math.min(res, Math.max(days[left], days[right]));
                left = i;
                right = left + k + 1;
            } else if (days[i] < days[left] || days[i] < days[right]) {
                left = i;
                right = left + k + 1;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
