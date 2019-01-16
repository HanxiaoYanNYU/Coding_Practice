package Leetcode.BFS.Medium;

import java.util.*;

public class Course_Schedule_II_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> firToSec = new HashMap<>();
        int[] numPrerequests = new int[numCourses];
        Queue<Integer> readyTake = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int first = prerequisites[i][1];
            int second = prerequisites[i][0];
            if (!firToSec.containsKey(first)) firToSec.put(first, new ArrayList<>());
            firToSec.get(first).add(second);
            numPrerequests[second]++;
        }

        for (int i = 0; i < numPrerequests.length; i++) {
            if (numPrerequests[i] == 0) readyTake.add(i);
        }

        int count = 0;
        int[] courseOrder = new int[numCourses];
        while (!readyTake.isEmpty()) {
            int course = readyTake.poll();
            courseOrder[count] = course;
            count++;

            if (!firToSec.containsKey(course)) continue;
            for (Integer second : firToSec.get(course)) {
                int pres = --numPrerequests[second];
                if (pres == 0) readyTake.add(second);
            }
        }

        if (count == numCourses) return courseOrder;
        return new int[0];
    }
}
