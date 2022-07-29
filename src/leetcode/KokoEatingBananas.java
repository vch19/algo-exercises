package leetcode;

public class KokoEatingBananas {

  public static int minEatingSpeed(int[] piles, int h) {
    int minEatingSpeed = Integer.MAX_VALUE;
    int maxPile = 0;

    for (int pile : piles) {
      maxPile = Math.max(maxPile, pile);
    }

    int left = 1;
    int right = maxPile;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      long spentTime = 0;

      for (int pile : piles) {
        spentTime += (long) Math.ceil((double) pile / middle);
      }

      if (spentTime <= h) {
        minEatingSpeed = Math.min(minEatingSpeed, middle);
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return minEatingSpeed;
  }

  public static void main(String[] args) {
    System.out.println(minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));

    int counter = 0;
    for (int i = 1; i < 100; i++) {
      counter = i % 2 == 1 ? counter + 1 : counter;
    }

    System.out.println(counter);
  }
}
