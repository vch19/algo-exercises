package leetcode;

public class RemoveDuplicatesFromSortedArray2 {

  public static int removeDuplicates(int[] nums) {
    int insertPosition = 0;
    int currentUnique = 0;

    int a = 0;
    int b = 0;

    while (b <= nums.length) {
      if (b < nums.length && nums[a] == nums[b]) {
        currentUnique++;
        b++;
      } else {
        currentUnique = Math.min(currentUnique, 2);
        while (currentUnique != 0) {
          nums[insertPosition] = nums[a];
          insertPosition++;
          currentUnique--;
        }
        a = b;
        if (b == nums.length) {
          break;
        }
      }
    }

    return insertPosition;
  }

  public static int removeDuplicate2(int[] nums) {
    int i = 0;
    for (int num : nums) {
      if (i < 2 || nums[i - 2] < num) {
        nums[i++] = num;
      }
    }
    return i;
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));//5
    System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));//7
  }
}
