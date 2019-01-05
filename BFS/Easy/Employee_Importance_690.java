package Leetcode.BFS.Easy;

import java.util.*;

public class Employee_Importance_690 {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        int importance = 0;

        while (!q.isEmpty()) {
            Employee e = q.poll();
            importance += e.importance;
            for (Integer i : e.subordinates) {
                q.add(map.get(i));
            }
        }
        return importance;
    }

    public class Employee {
        int id;
        int importance;
        List<Integer> subordinates;
    }
}
