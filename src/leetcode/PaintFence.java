package leetcode;

public class PaintFence {

  public static int numWays(int n, int k) {
    if (n == 1) {
      return k;
    } else if (k == 1 && n > 2) {
      return 0;
    }

    int[] ways = new int[n];
    ways[0] = 1;
    ways[1] = k;
    for (int i = 2; i < ways.length; i++) {
      ways[i] = (ways[i - 2] + ways[i - 1]) * (k - 1);
    }

    return ways[n - 1] * k;
  }


  public static void main(String[] args) {
    System.out.println(numWays(3, 2));//6
    System.out.println(numWays(1, 1));//1
    System.out.println(numWays(7, 2));//42
    System.out.println(numWays(3, 1));//1
  }
}
