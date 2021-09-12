package leetcode;

public class HouseRobberII {

  public static int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(rob1(nums), rob2(nums));
  }

  private static int rob1(int[] nums) {
    int rob = 0;
    int notRob = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      int current = notRob + nums[i];
      notRob = Math.max(rob, notRob);
      rob = current;
    }

    return Math.max(rob, notRob);
  }

  private static int rob2(int[] nums) {
    int rob = 0;
    int notRob = 0;

    for (int i = 1; i < nums.length; i++) {
      int current = notRob + nums[i];
      notRob = Math.max(rob, notRob);
      rob = current;
    }

    return Math.max(rob, notRob);
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[]{1, 2, 3})); //3
    System.out.println(rob(new int[]{1, 2, 3, 1})); //4
  }
}
