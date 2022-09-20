package leetcode;

public class FindMinimumInRotatedSortedArray {

  public static int findMin(int[] nums) {
    if (nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }

    int left = 0;
    int right = nums.length - 1;

    while (right - left != 1) {
      int middle = left + (right - left) / 2;
      if (nums[middle] < nums[left]) {
        right = middle;
      } else {
        left = middle;
      }
    }

    return nums[right];
  }

  public static void main(String[] args) {
    System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));//0
    System.out.println(findMin(new int[]{3, 1, 2}));//1
  }
}
