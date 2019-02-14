package Leetcode.Google.Onsite;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

    private int preSum = 0;
    private List<Integer> chosenCard = new ArrayList<>(); // elements are the index of the card

    public List<String> play(String[] cards) {
        int[] array1 = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].compareTo("2") >= 0 && cards[i].compareTo("9") <= 0) {
                array1[i] = Integer.parseInt(cards[i]);
            } else if (cards[i].equals("A")) {
                array1[i] = 1;
            } else {
                array1[i] = 10;
            }
        }

        find(array1, new ArrayList<>(), 0, 0);

        List<String> res = new ArrayList<>();
        for (Integer i : chosenCard) {
            res.add(cards[i]);
        }
        return res;
    }

    private void find(int[] array, List<Integer> track ,int currSum, int start) {
        if (currSum > preSum && currSum <= 21) {
            chosenCard = new ArrayList<>(track);
            preSum = currSum;
        }
        if (currSum > 21) return;

        for (int i = start; i < array.length; i++) {
            track.add(i);
            find(array, track, currSum + array[i], i+1);
            if (array[i] == i) find(array, track, currSum + 11, i+1);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        String[] cards = {"A","A","10","5","J","K"};
        List<String> res = blackJack.play(cards);
        for (String r : res) {
            System.out.println(r);
        }
    }

}
