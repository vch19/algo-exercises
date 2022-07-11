package leetcode;

import java.util.Arrays;

public class SuccessfulPairsOfSpellAndPotions {

  public static int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int[] result = new int[spells.length];

    for (int i = 0; i < spells.length; i++) {
      int pivot = (int) (success + spells[i] - 1) / spells[i];
      result[i] = binarySearch(potions, pivot, 0, potions.length);
    }

    return result;
  }

  private static int binarySearch(int[] nums, int target, int low, int high) {
    int middle = (low + high) / 2;

    if (low >= high) {
      return 0;
    }

    if (nums[middle] == target) {
      return nums.length - middle;
    }

    if (nums[middle] > target) {
      return binarySearch(nums, target, low, middle);
    } else {
      return binarySearch(nums, target, middle + 1, high);
    }
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));

    System.out.println(
        Arrays.toString(successfulPairs(new int[]{3, 1, 2}, new int[]{8,5,8}, 16)));

//    System.out.println(binarySearch(new int[] {1, 2, 3, 4, 5}, 5, 7, 5 / 2));
//    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 1, 7L, 0, 5)); //-1
//    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 5, 7L, 0, 5)); //4
//    System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 3, 7L, 0, 5)); //3
  }

}
