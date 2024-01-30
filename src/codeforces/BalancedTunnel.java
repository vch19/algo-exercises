package codeforces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BalancedTunnel {

  public static int foo(int[] in, int[] out) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = in.length - 1; i >= 0; i--) {
      map.put(in[i], in.length - i);
    }

    for (int i = 0; i < out.length; i++) {
      out[i] = map.get(out[i]);
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < out.length; i++) {

      set.add(out[i]);
    }

    int totalFines = 0;

    for (int i = out.length - 1; i >= 0; i--) {

    }

    return totalFines;
  }

  public static void main(String[] args) {
    System.out.println(foo(new int[]{4, 1, 2, 5, 3}, new int[]{1, 5, 2, 3, 4}));//2
//    System.out.println(foo(new int[]{3, 5, 2, 1, 4}, new int[]{4, 3, 2, 5, 1}));//2
  }
}
