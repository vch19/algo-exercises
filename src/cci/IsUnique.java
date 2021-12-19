package cci;

import java.util.Arrays;

public class IsUnique {

  public static boolean isUnique(String s) {
    if (s.length() == 0) {
      return false;
    }

    char[] chars = s.toCharArray();
    Arrays.sort(chars);

    char prev = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (prev == chars[i]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isUnique("zzaaacbb"));
    System.out.println(isUnique("abc"));
  }

}
