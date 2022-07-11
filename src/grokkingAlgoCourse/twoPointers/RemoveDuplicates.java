package grokkingAlgoCourse.twoPointers;

public class RemoveDuplicates {

  public static int remove(int[] nums) {
    int nextNonDuplicate = 1; // index of the next non-duplicate element
    for (int i = 0; i < nums.length; i++) {
      if (nums[nextNonDuplicate - 1] != nums[i]) {
        nums[nextNonDuplicate] = nums[i];
        nextNonDuplicate++;
      }
    }

    return nextNonDuplicate;
  }

  public static void main(String[] args) {
    System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
  }
}
