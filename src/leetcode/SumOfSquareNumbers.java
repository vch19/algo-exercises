package leetcode;

public class SumOfSquareNumbers {

  public static boolean judgeSquareSum(int c) {
    for (int i = 0; i <= c; i++) {
      int target = c - (i * i);
      if (binarySearch(target, 0, c)) {
        return true;
      }
    }
    return false;
  }

  public static boolean judgeSquareSumTwoPointers(int c) {
    int a = 0;
    int b = c;

    while (a <= b) {
      long result = ((long) b * b) + ((long) a * a);
      if (result == c) {
        return true;
      } else if (result > c) {
        b--;
      } else {
        a++;
      }
    }

    return false;
  }

  private static boolean binarySearch(int target, int min, int max) {
    if (min > max) {
      return false;
    }

    int middle = min + (max - min) / 2;

    if (middle * middle == target) {
      return true;
    } else if (middle * middle > target) {
      return binarySearch(target, min, middle - 1);
    } else {
      return binarySearch(target, middle + 1, max);
    }
  }

  public static void main(String[] args) {
    System.out.println(judgeSquareSumTwoPointers(5));//true
    System.out.println(judgeSquareSumTwoPointers(3));//false
    System.out.println(judgeSquareSumTwoPointers(9));//true
    System.out.println(judgeSquareSumTwoPointers(2));//true
    System.out.println(judgeSquareSumTwoPointers(1000000));//true
  }
}
