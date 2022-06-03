package leetcode;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {

  public static int[] rearrangeArray(int[] nums) {
    int[] result = new int[nums.length];
    int a = 0;
    int b = 1;

    for (int num : nums) {
      if (num < 0) {
        result[b] = num;
        b += 2;
      }
      if (num > 0) {
        result[a] = num;
        a += 2;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(rearrangeArray(new int[] {3,1,-2,-5,2,-4}))); //[3,-2,1,-5,2,-4]
  }
}
