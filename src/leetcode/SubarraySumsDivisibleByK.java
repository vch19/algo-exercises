package leetcode;

public class SubarraySumsDivisibleByK {

  public static int subarraysDivByK(int[] nums, int k) {
    int subarrays = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];//put sum into the map and after that manipulate somehow with it

        if (sum % k == 0) {
          subarrays++;
        }
      }
    }

    return subarrays;
  }

  public static void main(String[] args) {
    System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    //4 => 4; 4, 5; 4, 5, 0; 4, 5, 0, -2; 4, 5, 0, -2, -3; 4, 5, 0, -2, 1;
    //5 => 5; 5, 0; 5, 0, -2; 5, 0, -2, -3; 5, 0, -2, -3, 1;

    //4, 5, 0, -2, -3, 1
  }
}
