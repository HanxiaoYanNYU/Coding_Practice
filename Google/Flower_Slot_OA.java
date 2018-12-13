package Leetcode.Google;

public class Flower_Slot_OA {

    /**
     *
     * 笑宇的solution
     *
     * A[i] is the position, i+1 is the blossom day
     *
     * @param A
     * @param K
     * @param M
     * @return
     */
    public static int solution(int[] A, int K, int M){
        int[] flowers = new int[A.length + 2];
        int count = 0, res = -1;
        for (int i = 0; i < A.length; i++){
            boolean left = false, right = false, overleft = false, overright = false;
            int index = A[i];
            if (flowers[index - 1] + 1 > K) overleft = true;
            if (flowers[index + 1] + 1 > K) overright = true;
            if (flowers[index - 1] + 1 == K) left = true;
            if (flowers[index + 1] + 1 == K) right = true;
            if (flowers[index - 1] == 0 && flowers[index + 1] == 0) flowers[index]++;
            else if (flowers[index - 1] == 0){
                flowers[index] = flowers[index + flowers[index + 1]] + 1;
                flowers[index + flowers[index + 1]] = flowers[index];
            }
            else if (flowers[index + 1] == 0){
                flowers[index] = flowers[index - flowers[index - 1]] + 1;
                flowers[index - flowers[index - 1]] = flowers[index];
            }
            else {
                if (!left && !right && !overleft && !overright){
                    if (flowers[index - 1] + flowers[index + 1] + 1 >= K) count++;
                }
                int before = flowers[index - 1];
                flowers[index - flowers[index - 1]] += 1 + flowers[index + 1];
                flowers[index + flowers[index + 1]] += 1 + before;
            }
            if (left && right) count++;
            else if (left && !overright) count++;
            else if (right && !overleft) count++;
            if (overleft && overright) count--;
            if (count == M) res = i + 1;
        }
        return res;
    }
}
