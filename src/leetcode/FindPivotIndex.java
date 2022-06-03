package leetcode;

public class FindPivotIndex {

  public static int pivotIndex(int[] nums) {
    int sum = 0;

    for (int num : nums) {
      sum += num;
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sum - leftSum - nums[i] == leftSum) {
        return i;
      }
      leftSum += nums[i];
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    System.out.println(pivotIndex(new int[]{1, 2, 3}));
  }

}
