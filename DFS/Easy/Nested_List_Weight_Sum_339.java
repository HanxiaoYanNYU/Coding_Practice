package Leetcode.DFS.Easy;

import java.util.List;

public class Nested_List_Weight_Sum_339 {

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return Dfs(nestedList, 1);
    }

    public int Dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            NestedInteger ni = list.get(i);
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += Dfs(ni.getList(), depth + 1);
            }
        }
        return sum;
    }

    public interface NestedInteger {
        boolean isInteger();
        int getInteger();
        List<NestedInteger> getList();
    }
}
