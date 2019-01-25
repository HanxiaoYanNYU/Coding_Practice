package Leetcode.DFS.Medium;

import Leetcode.DFS.Easy.Nested_List_Weight_Sum_339;

import java.util.List;

public class Nested_List_Weight_Sum_II_364 {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int maxDepth = findDepth(nestedList);
        return depthSum(nestedList, maxDepth);
    }

    public int findDepth(List<NestedInteger> nestedList) {
        int depth = 0;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) depth = Math.max(depth, findDepth(ni.getList()) + 1);
            else depth = Math.max(depth, 1);
        }
        return depth;
    }

    public int depthSum(List<NestedInteger> nestedList, int currDepth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) sum += ni.getInteger() * currDepth;
            else sum += depthSum(ni.getList(), currDepth - 1);
        }
        return sum;
    }

    public interface NestedInteger {
        boolean isInteger();
        int getInteger();
        List<NestedInteger> getList();
    }
}
