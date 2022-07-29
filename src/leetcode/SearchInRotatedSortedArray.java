package leetcode;

public class SearchInRotatedSortedArray {

  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int middle = (left + right) / 2;

      if (nums[middle] > nums[right]) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }

    int l = binarySearch(nums, 0, left - 1, target);
    int r = binarySearch(nums, left, nums.length - 1, target);

    return Math.max(l, r);
  }

  private static int binarySearch(int[] nums, int low, int high, int target) {
    if (low > high) {
      return -1;
    }

    int middle = low + (high - low) / 2;

    if (nums[middle] == target) {
      return middle;
    } else if (nums[middle] > target) {
      return binarySearch(nums, low, middle - 1, target);
    } else {
      return binarySearch(nums, middle + 1, high, target);
    }
  }

  public static void main(String[] args) {
    System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    System.out.println(search(new int[]{1}, 1));
  }
}
