package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class BankRobbers {

  private static final FastScanner FAST_SCANNER = new FastScanner();

  public static void maxRob(int distance, int[] prices) {
    int[] dp = new int[prices.length];
    dp[0] = 0;
    int max = prices[0];

    for (int i = 1; i < dp.length; i++) {
      if (prices[i] > max) {
        dp[i] = i;
        max = prices[i];
      } else {
        dp[i] = dp[i - 1];
      }
    }

    long maxProfit = 0;

    int left = 0;
    int right = 0;

    for (int i = distance + 1; i < prices.length; i++) {
      if ((long) prices[dp[i - distance]] + prices[i] > maxProfit) {
        maxProfit = Math.max(maxProfit, ((long) prices[dp[i - distance]]) + prices[i]);
        left = dp[i - distance] + 1;
        right = i + 1;
      }
    }

    System.out.println(left + " " + right);
  }

  public static void main(String[] args) {
    int[] arr1 = FAST_SCANNER.nextIntArr();
    int[] prices = FAST_SCANNER.nextIntArr();

    maxRob(arr1[1], prices); //2 5
  }

  static class FastScanner {

    private final Scanner sc = new Scanner(System.in);

    int nextInt() {
      return Integer.parseInt(sc.next());
    }

    long nextLong() {
      return Long.parseLong(sc.next());
    }

    int[] nextIntArr() {
      return Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
  }
}
