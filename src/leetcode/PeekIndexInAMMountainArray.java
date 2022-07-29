package leetcode;

public class PeekIndexInAMMountainArray {

  public static int peakIndexInMountainArray(int[] nums) {
    return binarySearch(nums, 0, nums.length - 1);
  }

  private static int binarySearch(int[] nums, int left, int right) {
    if (left == right) {
      return left;
    }

    int middle = left + (right - left) / 2;

    if (nums[middle] > nums[middle + 1]) {
      return binarySearch(nums, left, middle);
    }

    return binarySearch(nums, middle + 1, right);
  }

  public static void main(String[] args) {
    System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
  }
}
