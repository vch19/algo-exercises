package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfIslands {

//  public static int numIslands(char[][] grid) {
//    int count = 0;
//    int dummy = 0;
//
//    for (int i = 0; i < grid.length; i++) {
//      for (int j = 0; j < grid[0].length; j++) {
//        if (grid[i][j] == '1'
//            && (((i > 0 && j > 0 && (grid[i][j - 1] == '1' || grid[i - 1][j] == '1'))) || (i == 0
//            && j > 0 && grid[i][j - 1] == '1') || (j == 0 && i > 0 && grid[i - 1][j] == '1'))) {
//          dummy++;
//        } else if (grid[i][j] == '1') {
//          count++;
//        }
//      }
//    }
//    return count;
//  }

  public static int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          fillDfs(grid, i, j);
          count++;
        }
      }
    }

    return count;
  }

  private static void fillDfs(char[][] grid, int i, int j) {
    if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
      grid[i][j] = '0';
      fillDfs(grid, i + 1, j);
      fillDfs(grid, i - 1, j);
      fillDfs(grid, i, j + 1);
      fillDfs(grid, i, j - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(numIslands(new char[][]{
        {'1'},
        {'1'}
    }));
    System.out.println(numIslands(new char[][]{
        {'1', '1', '0', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'0', '0', '0', '0', '0'},
        {'1', '0', '1', '0', '1'}
    })); //4
    System.out.println(numIslands(new char[][]{
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    })); //3
    System.out.println(numIslands(new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    })); //1
    System.out.println(numIslands(new char[][]{
        {'1', '1', '1'},
        {'0', '1', '0'},
        {'1', '1', '1'}
    })); //1
  }

}
