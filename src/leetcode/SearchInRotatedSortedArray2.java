package leetcode;

public class SearchInRotatedSortedArray2 {

  public static boolean search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (nums[middle] == target) {
        return true;
      }

      if (nums[middle] > nums[left] || nums[middle] > nums[right]) {
        if (nums[middle] > nums[middle]) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      } else if (nums[middle] < nums[left] || nums[middle] < nums[right]) {
        if (nums[middle] < nums[left]) {
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      } else {
        right--;
      }
    }

    return false;
  }

  public static void main(String[] args) {
//    System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)); //TRUE
//    System.out.println(search(new int[]{1, 0, 1, 1, 1}, 0)); //TRUE
//    System.out.println(search(new int[]{1}, 0)); //FALSE
//    System.out.println(search(new int[]{1}, 1)); //TRUE
    System.out.println(
        search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}, 2)); //TRUE
  }
}
