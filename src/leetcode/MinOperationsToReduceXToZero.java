package leetcode;

public class MinOperationsToReduceXToZero {

  public static int minOperations(int[] nums, int x) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }

    int minLength = -1;
    int currentSum = 0;
    int left = 0;
    int right = 0;

    while (right < nums.length) {
      currentSum += nums[right];

      while (left <= right && currentSum > sum - x) {
        currentSum -= nums[left++];
      }

      if (currentSum == sum - x) {
        minLength = Math.max(minLength, right - left + 1);
      }
      right++;
    }

    return minLength == -1 ? -1 : nums.length - minLength;
  }

  public static void main(String[] args) {
    System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5)); //2
    System.out.println(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));//5
    System.out.println(minOperations(new int[]{8, 7, 200, 1, 1, 1, 1, 1, 1, 2}, 7));//6
    System.out.println(minOperations(new int[]{7, 8, 200, 1, 1, 1, 1, 1, 1, 2}, 7));//1
    System.out.println(minOperations(new int[]{1}, 2));//-1
    System.out.println(minOperations(new int[]{1, 1}, 2));//2
    System.out.println(minOperations(new int[]{1, 1, 2}, 2));//1
    System.out.println(minOperations(new int[]{1, 1, 2}, 1));//1
  }

}
