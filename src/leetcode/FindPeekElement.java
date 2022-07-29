package leetcode;

public class FindPeekElement {

  public static int findPeakElement(int[] nums) {
    return binarySearch(nums, 0, nums.length - 1);
  }

  private static int binarySearch(int[] nums, int low, int high) {
    if (low == high) {
      return low;
    }

    int middle = low + (high - low) / 2;

    if (nums[middle] > nums[middle + 1]) {
      return binarySearch(nums, low, middle);
    }
    return binarySearch(nums, middle + 1, high);
  }

  public static void main(String[] args) {
//    System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));//5 -> N[5] => 6
    System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));//2
//    System.out.println(findPeakElement(new int[]{1}));//0
//    System.out.println(findPeakElement(new int[]{1, 2}));//1
//    System.out.println(findPeakElement(new int[]{1, 1}));//0
//    System.out.println(findPeakElement(new int[]{1, 1, 1}));//1
//    System.out.println(findPeakElement(new int[]{1, 2, 1}));//1
//    System.out.println(findPeakElement(new int[]{1, 1, 2}));//2
  }

}
