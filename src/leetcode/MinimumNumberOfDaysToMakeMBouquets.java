package leetcode;

public class MinimumNumberOfDaysToMakeMBouquets {

  public static int minDays(int[] bloomDays, int m, int k) {
    if (m * k > bloomDays.length) {
      return -1;
    }

    int minDays = Integer.MAX_VALUE;

    int left = 1;
    int right = 0;
    for (int bloomDay : bloomDays) {
      right = Math.max(right, bloomDay);
    }

    while (left <= right) {
      int middle = left + (right - left) / 2;

      int bouquets = m;
      int flowers = k;
      for (int bloomDay : bloomDays) {
        if (bouquets == 0) {
          break;
        }
        if (bloomDay <= middle) {
          flowers--;
        } else {
          flowers = k;
        }
        if (flowers == 0) {
          bouquets--;
          flowers = k;
        }
      }

      if (bouquets == 0) {
        minDays = Math.min(minDays, middle);
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return minDays == Integer.MAX_VALUE ? -1 : minDays;
  }

  public static void main(String[] args) {
    System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
  }
}
