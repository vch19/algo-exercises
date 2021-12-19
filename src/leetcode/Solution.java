package leetcode;

public class Solution {

  public static int findMaxContainer(int[] arr) {
    int result = 0;

    int a = 0;
    int b = arr.length - 1;

    while (a <= b) {
      result = Math.max(result, Math.min(arr[a], arr[b]) * (b - a));
      if (arr[a] > arr[b]) {
        b--;
      } else {
        a++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(findMaxContainer(new int[]{1,8,6,2,5,4,8,3,7}));
  }
}
