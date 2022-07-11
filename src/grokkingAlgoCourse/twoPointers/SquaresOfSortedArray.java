package grokkingAlgoCourse.twoPointers;

public class SquaresOfSortedArray {

  public int[] sortedSquares(int[] nums) {
    int[] squared = new int[nums.length];
    int idx = nums.length - 1;

    int left = 0;
    int right = nums.length - 1;

    while (right >= left) {
      if ((nums[left] * nums[left]) > (nums[right] * nums[right])) {
        squared[idx--] = nums[left] * nums[left];
        left++;
      } else {
        squared[idx--] = nums[right] * nums[right];
        right--;
      }
    }

    return squared;
  }
}
