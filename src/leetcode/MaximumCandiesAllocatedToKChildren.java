package leetcode;

public class MaximumCandiesAllocatedToKChildren {

  public static int maximumCandies(int[] candies, long k) {
    int left = 0;
    int right = 10_000_000;

    while (left < right) {
      int middle = (left + right + 1) / 2;
      long sum = 0;

      for (int pile : candies) {
        sum += pile / middle;
      }

      if (k > sum) {
        right = middle - 1;
      } else {
        left = middle;
      }
    }

    return left;
  }

  public static void main(String[] args) {
//    System.out.println(maximumCandies(new int[]{5, 8, 6}, 3));//5
//    System.out.println(maximumCandies(new int[]{2, 5}, 11));//0
    System.out.println(maximumCandies(new int[]{1, 2, 3, 4, 10}, 11));//3
  }
}
