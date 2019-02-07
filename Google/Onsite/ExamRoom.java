package Leetcode.Google.Onsite;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ExamRoom {

    private int seats;
    private List<Integer> list;

    public ExamRoom(int N) {
        seats = N;
        list = new LinkedList<>();
    }

    public int seat() {
        if (list.size() == seats) return -1;
        else if (list.size() == 0) {
            list.add(0);
            return 0;
        } else {
            // corner case1: no student seats on 0
            int seat = 0;
            int dist = list.get(0);
            // normal case: calculate dist beteen two students
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    int left = list.get(i-1);
                    int right = list.get(i);
                    if ((right - left) / 2 > dist) {
                        // update dist and seat
                        seat = (right - left) / 2 + left;
                        dist = seat - left;
                    }
                }
            }
            // corner case2: no student seats on N-1
            if ((seats-1) - list.get(list.size()-1) > dist) seat = seats - 1;
            // add new seat to list and sort it to make sure seats number are increasing
            list.add(seat);
            Collections.sort(list);
            return seat;
        }
    }

    public void leave(int p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == p) {
                list.remove(i);
                break;
            }
        }
    }
}
