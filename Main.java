package Leetcode;

import Leetcode.BFS.Medium.*;
import Leetcode.Binary_Search.Easy.*;
import Leetcode.Binary_Search.Medium.*;
import Leetcode.DFS.Easy.Flood_Fill_733;
import Leetcode.DFS.Medium.Decode_String_394;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        String res = Decode_String_394.decodeString("3[a]2[b4[F]c]");

        Stack<Character> s = new Stack<>();

        String re = "a";
        for (int i = 0; i < 3; i++) {
            re += re;
        }
        System.out.println(res);
    }

}
