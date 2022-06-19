package algo;

import java.util.Random;

public class GenerateMaze {

  private final int height;
  private final int width;
  private final Random random;

  public GenerateMaze(int height, int width) {
    this.height = height;
    this.width = width;
    this.random = new Random();
  }

  public int[][] sidewinder() {
    int[][] maze = new int[height][width];

    for (int i = 1; i < height; i++) {
      int set = getMaxSet(width);
      for (int j = 0; j < width; j++) {
//        maze[i][j] =
      }
    }

    return maze;
  }

  private int getMaxSet(int existingWidth) {
    return (int) Math.floor(Math.log1p(width));
  }
}
