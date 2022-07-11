package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumConsecutiveCardsToPickUp {

  public static int minimumCardPickup(int[] cards) {
    Map<Integer, Integer> freq = new HashMap<>();
    int minLength = Integer.MAX_VALUE;

    int left = 0;
    for (int right = 0; right < cards.length; right++) {
      freq.put(cards[right], freq.getOrDefault(cards[right], 0) + 1);

      while (freq.get(cards[right]) == 2) {
        minLength = Math.min(minLength, right - left + 1);
        freq.put(cards[left], freq.get(cards[left]) - 1);
        if (freq.get(cards[left]) == 0) {
          freq.remove(cards[left]);
        }
        left++;
      }
    }

    return minLength == Integer.MAX_VALUE ? -1 : minLength;
  }

  public static void main(String[] args) {
    System.out.println(minimumCardPickup(
        new int[]{95, 11, 8, 65, 5, 86, 30, 27, 30, 73, 15, 91, 30, 7, 37, 26, 55, 76, 60, 43, 36,
            85, 47, 96, 6}));//3
  }

}
