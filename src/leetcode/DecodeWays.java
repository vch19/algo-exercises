package leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 91. Decode Ways
 */
public class DecodeWays {

  private int totalDecodes = 0;

  private Map<String, Integer> numbers = Stream.iterate(1, n -> n + 1)
      .limit(26)
      .collect(Collectors.toMap(String::valueOf, Function.identity()));

  public int numDecodingBruteForce(String s) {
    recursion(s, "" + s.charAt(0), 1);
    return totalDecodes;
  }

  private void recursion(String s, String current, int i) {
    if (!numbers.containsKey(current)) {
      return;
    } else if (i == s.length()) {
      totalDecodes++;
      return;
    }
    recursion(s, current + s.charAt(i), i + 1);
    recursion(s, "" + s.charAt(i), i + 1);
  }

  public int numDecoding(String s) {
    if (s.charAt(0) == '0') {
      return 0;
    } else if (s.length() == 1) {
      return 1;
    }

    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < dp.length; i++) {
      dp[i] = 0;
      if (numbers.containsKey(s.substring(i - 1, i))) {
        dp[i] += dp[i - 1];
      }
      if (numbers.containsKey(s.substring(i - 2, i))) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    System.out.println(new DecodeWays().numDecoding("226"));//3
    System.out.println(new DecodeWays().numDecoding("12"));//2
    System.out.println(new DecodeWays().numDecoding("06"));//0
    System.out.println(new DecodeWays().numDecoding("1206"));//1
    System.out.println(new DecodeWays().numDecoding("154608"));//0
    System.out.println(new DecodeWays().numDecoding("22222"));//8
    System.out.println(new DecodeWays().numDecodingBruteForce("154208"));//6
  }
}
