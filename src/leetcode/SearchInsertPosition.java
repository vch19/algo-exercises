package leetcode;

public class SearchInsertPosition {

  public static int searchInsert(int[] nums, int target) {
    if (target < nums[0]) {
      return 0;
    } else if (target > nums[nums.length - 1]) {
      return nums.length;
    }
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    return nums[left] < target ? left + 1 : left;
  }

  public static void main(String[] args) {
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));//2
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));//1
    System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));//4
    System.out.println(searchInsert(new int[]{1}, 1));//4
  }

}
