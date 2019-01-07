package Leetcode;

import Leetcode.BFS.Medium.Perfect_Squares_279;
import Leetcode.BFS.Medium.Word_Ladder_127;
import Leetcode.Binary_Search.Easy.*;
import Leetcode.Binary_Search.Medium.*;
import Leetcode.Google.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        int res = Word_Ladder_127.ladderLength("hit", "cog", list);
        System.out.println((int)Math.pow(2,3));
    }
}
