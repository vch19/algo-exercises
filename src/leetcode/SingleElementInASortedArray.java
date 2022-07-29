package leetcode;

public class SingleElementInASortedArray {

  public static int singleNonDuplicate(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (nums[middle] == nums[middle + 1]) {
        if ((middle - left + 1) % 2 != 0) {
          left = middle;
        } else {
          right = middle - 1;
        }
      } else if (nums[middle] == nums[middle - 1]) {
        if ((middle - left + 1) % 2 != 0) {
          right = middle;
        } else {
          left = middle + 1;
        }
      } else {
        return nums[middle];
      }
    }

    return nums[left];
  }

  public static void main(String[] args) {
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));
  }
}
