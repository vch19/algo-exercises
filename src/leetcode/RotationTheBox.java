package leetcode;

import java.util.Arrays;

public class RotationTheBox {

  public static char[][] rotateTheBox(char[][] box) {
    char[][] result = new char[box[0].length][box.length];

    for (int i = 0; i < box.length; i++) {
      Integer insertPosition = null;
      for (int j = box[0].length - 1; j >= 0; j--) {
        if (insertPosition == null && box[i][j] == '.') {
          insertPosition = j;
        } else if (insertPosition != null && box[i][j] == '#') {
          box[i][j] = '.';
          box[i][insertPosition--] = '#';
        } else if (box[i][j] == '*') {
          insertPosition = null;
        }
      }
    }

    for (int i = 0; i < box.length; i++) {
      for (int j = 0; j < box[0].length; j++) {
        result[j][box.length - i - 1] = box[i][j];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    var arr = rotateTheBox(
        new char[][]{
            {'#', '#', '*', '.', '*', '.'},
            {'#', '#', '#', '*', '.', '.'},
            {'#', '#', '#', '.', '#', '.'}
        });

    var arr1 = rotateTheBox(
        new char[][]{
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        }
    );

    for (char[] row : arr1) {
      System.out.println(Arrays.toString(row));
    }
  }
}
