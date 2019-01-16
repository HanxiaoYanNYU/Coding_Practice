package Leetcode.BFS.Medium;

import java.util.*;

public class Course_Schedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> firstToSecond = new HashMap<>();
        int[] numOfPrerequests = new int[numCourses];

        for (int row = 0; row < prerequisites.length; row++) {
            int first = prerequisites[row][1];
            int second = prerequisites[row][0];
            if (firstToSecond.containsKey(first)) {
                firstToSecond.get(first).add(second);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(second);
                firstToSecond.put(first, list);
            }
            numOfPrerequests[second] = numOfPrerequests[second] + 1;
        }

        Queue<Integer> coursesCanTake = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numOfPrerequests[i] == 0) coursesCanTake.add(i);
        }

        int courseTaken = 0;
        while (!coursesCanTake.isEmpty()) {
            int course = coursesCanTake.poll();
            courseTaken++;

            if (firstToSecond.get(course) == null) continue;

            for (Integer second : firstToSecond.get(course)) {
                numOfPrerequests[second] = numOfPrerequests[second] - 1;
                if (numOfPrerequests[second] == 0) coursesCanTake.add(second);
            }
        }

        return courseTaken == numCourses;
    }
}
