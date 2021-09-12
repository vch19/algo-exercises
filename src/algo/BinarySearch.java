package algo;

public class BinarySearch {

  public int binarySearch(int[] sortedArray, int target, int low, int high) {
    int middle = (low + high) / 2;

    if (high < low) {
      return -1;
    }

    if (target == sortedArray[middle]) {
      return middle;
    } else if (target < sortedArray[middle]) {
      return binarySearch(sortedArray, target, low, high - 1);
    } else {
      return binarySearch(sortedArray, target, low + 1, high);
    }
  }

  public static int search(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    int pivot;
    int left = 0;
    int right = nums.length;

    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (nums[pivot] == target) {
        return pivot;
      }
      if (target < nums[pivot]) {
        right = pivot - 1;
      } else {
        left = pivot + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(
        new BinarySearch().binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 100}, 100, 0, 8));
  }
}
