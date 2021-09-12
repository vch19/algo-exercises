package leetcode;

public class HouseRobber {

  /*
    Time complexity: O(n)
    Space complexity: O(1)
   */
  public static int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }

    nums[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
    }

    return nums[nums.length - 1];
  }

  public static int robSecondApproach(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }

    int rob = 0;
    int notRob = 0;

    for (int num : nums) {
      int currentRob = notRob + num; //to rob current house we must be sure that we didn't rob previous
      notRob = Math.max(rob, notRob);
      rob = currentRob;
    }

    return Math.max(rob, notRob);
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[]{2, 7, 9, 3, 1})); //12
  }

}
