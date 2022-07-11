package leetcode;

public class MaximumPointsYouCanObtainFromCards {

  public static int maxScore(int[] points, int k) {
    int lSum = 0;
    for (int i = 0; i < k; i++) {
      lSum += points[i];
    }

    int maxScore = 0;
    int rSum = 0;
    for (int i = 0; i < k; i++) {
      lSum -= points[k - i - 1];
      rSum += points[points.length - i - 1];
      maxScore = Math.max(maxScore, lSum + rSum);
    }
    return maxScore;
  }

  public static void main(String[] args) {
    System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));//12
    System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));//55
    System.out.println(maxScore(new int[]{100, 40, 17, 9, 73, 75}, 3));//248
  }
}
