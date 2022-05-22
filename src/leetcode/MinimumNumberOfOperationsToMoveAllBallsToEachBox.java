package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

  public static int[] minOperations(String boxes) {
    List<Integer> positions = new ArrayList<>();

    for (int i = 0; i < boxes.length(); i++) {
      if (boxes.charAt(i) == '1') {
        positions.add(i);
      }
    }

    int[] result = new int[boxes.length()];

    for (int i = 0; i < result.length; i++) {
      for (int position : positions) {
        result[i] += Math.abs(position - i);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(minOperations("001011")));
  }
}
