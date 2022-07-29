package leetcode;

public class FindTheSmallestDivisorGivenAThreshold {

  public static int smallestDivisor(int[] nums, int threshold) {
    int left = 1;
    int right = 0;

    for (int num : nums) {
      right = Math.max(right, num);
    }

    while (left <= right) {
      int middle = left + (right - left) / 2;

      long sum = 0;
      for (int num : nums) {
        sum += (long) Math.ceil((double) num / middle);
      }

      if (sum > threshold) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    return left;
  }

  public static void main(String[] args) {
    System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));
  }
}
