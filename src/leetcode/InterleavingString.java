package leetcode;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

  public boolean isInterleave(String s1, String s2, String s3) {
    Map<String, String> memo = new HashMap<>();
    return false;
  }

  public boolean helper(String current, int i, int j, String s1, String s2, String s3, Map<String, String> memo) {
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
  }
}
