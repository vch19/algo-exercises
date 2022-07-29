package leetcode;

public class FindMinimumInRotatedSortedArray {

  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    if (nums[left] < nums[right]) {
      return nums[left];
    }

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (middle + 1 < nums.length && nums[middle] > nums[middle + 1]) {
        return nums[middle + 1];
      }

      if (middle - 1 >= 0 && nums[middle - 1] > nums[middle]) {
        return nums[middle];
      }

      if (nums[middle] > nums[right]) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));//0
    System.out.println(findMin(new int[]{3, 1, 2}));//1
  }
}
