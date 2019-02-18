package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {

    public List<Integer> grayCode(int n) {
        // formula: GrayCode(i) = i ^ (i/2), ^ is XOR
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
