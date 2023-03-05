package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialPositionsInBinaryMatrix {

  public static int numSpecial(int[][] mat) {
    int positions = 0;
    List<int[]> pos = new ArrayList<>();
    Map<Integer, Integer> col = new HashMap<>();
    Map<Integer, Integer> row = new HashMap<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        if (mat[i][j] == 1) {
          col.put(j, col.getOrDefault(j, 0) + 1);
          row.put(i, row.getOrDefault(i, 0) + 1);
          pos.add(new int[]{i, j});
        }
      }
    }

    for (int[] position : pos) {
      if (col.getOrDefault(position[1], 0) == 1 && row.getOrDefault(position[0], 0) == 1) {
        positions++;
      }
    }

    return positions;
  }

  public static void main(String[] args) {
    System.out.println(numSpecial(new int[][]{
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    }));
  }
}
