package grokkingAlgoCourse.twoPointers;

public class RemoveKey {

  public static int remove(int[] nums, int key) {
    int removed = 0;

    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] == key) {
        while (nums[i] != key) {
          i++;
        }
        swap(i, j, nums);
      }
    }

    return removed;
  }

  private static void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
