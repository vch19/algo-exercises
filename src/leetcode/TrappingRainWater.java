package leetcode;

public class TrappingRainWater {

  public static int trap(int[] height) {
    int water = 0;
    int left = 0;
    int right = height.length - 1;

    int maxLeft = height[left];
    int maxRight = height[right];

    while (left < right) {
      if (height[left] <= height[right]) {
        maxLeft = Math.max(maxLeft, height[left]);
        water += maxLeft > height[left] ? maxLeft - height[left] : 0;
        left++;
      } else {
        maxRight = Math.max(maxRight, height[right]);
        water += maxRight > height[right] ? maxRight - height[right] : 0;
        right--;
      }
    }
    return water;
  }

  public static void main(String[] args) {
    System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }
}
