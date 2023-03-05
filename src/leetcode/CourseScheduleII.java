package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

  private static final int WHITE = 1;
  private static final int GREY = 2;
  private static final int BLACK = 3;

  private boolean hasCycle;
  private Map<Integer, Integer> colors = new HashMap<>();
  private Map<Integer, List<Integer>> graph = new HashMap<>();

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    for (int i = 0; i < numCourses; i++) {
      colors.put(i, WHITE);
    }

    for (int[] vertex : prerequisites) {
      if (!graph.containsKey(vertex[1])) {
        graph.put(vertex[1], new ArrayList<>());
      }
      graph.get(vertex[1]).add(vertex[0]);
    }

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      if (colors.get(i) == WHITE) {
        dfs(i, result);
      }
    }

    int[] order;
    if (!hasCycle) {
      order = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
        order[i] = result.get(numCourses - i - 1);
      }
    } else {
      order = new int[0];
    }

    return order;
  }

  public void dfs(int vertex, List<Integer> result) {
    if (hasCycle) {
      return;
    }

    colors.put(vertex, GREY);

    for (Integer adjustedVertex : graph.getOrDefault(vertex, new ArrayList<>())) {
      if (colors.get(adjustedVertex) == WHITE) {
        dfs(adjustedVertex, result);
      } else if (colors.get(adjustedVertex) == GREY) {
        hasCycle = true;
      }
    }

    colors.put(vertex, BLACK);
    result.add(vertex);
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new CourseScheduleII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1},
            {3, 2}})));
  }
}
