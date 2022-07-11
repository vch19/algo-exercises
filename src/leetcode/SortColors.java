package leetcode;

public class SortColors {

  public void sortColors(int[] nums) {
    if (nums.length < 2) {
      return;
    }
    int fp = 0;
    int sp = nums.length - 1;
    int i = 0;

    while (i <= sp) {
      if (nums[i] == 0) {
        nums[i] = 1;
        nums[fp] = 0;
        fp++;
        i++;
      } else if (nums[i] == 2) {
        nums[i] = nums[sp];
        nums[sp] = 2;
        sp--;
      } else {
        i++;
      }
    }
  }

  public static void main(String[] args) {
    new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 0});

    new SortColors().sortColors(new int[]{2, 0, 1});
  }
}
