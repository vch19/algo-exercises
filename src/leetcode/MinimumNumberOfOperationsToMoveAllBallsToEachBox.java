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

  public static int[] minOperationsEffective(String boxes) {
    int a = 0;
    int b = 0;

    //How many iterations should we do to move all balls to the first position.
    int value = 0;
    //Contains how many balls we have.
    int counter = 0;
    //Contains how many balls are on the left side.
    int leftSide = 0;

    int[] result = new int[boxes.length()];

    while (a != boxes.length()) {
      if (b == boxes.length()) {
        //if this is the first position we set whole distance
        result[a++] = value;
      } else if (a > 0 && boxes.charAt(a - 1) == '1') {
        //If previous element is `1` we should count it
        counter--;
        leftSide++;
        value -= counter - leftSide;
        result[a++] = value;
      } else if (a > 0 && boxes.charAt(a - 1) != '1') {
        value -= counter - leftSide;
        result[a++] = value;
      }

      //There we calculate total iterations.
      if (b < boxes.length() && boxes.charAt(b) == '1') {
        value += b;
        counter++;
      }
      b++;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(minOperationsEffective("001011")));
  }
}
