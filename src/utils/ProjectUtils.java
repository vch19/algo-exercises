package utils;

import java.util.Arrays;
import java.util.stream.Stream;

public final class ProjectUtils {

  private ProjectUtils() {
  }

  public static void printNdArray(int[][] arr) {
    for (int[] ints : arr) {
      System.out.println(Arrays.toString(ints));
    }
    System.out.print("\n");
  }

  public static int[] createArrayWithCustomDefaultValue(int size, int defaultValue) {
    return Stream.generate(() -> defaultValue).limit(size).mapToInt(Integer::intValue).toArray();
  }
}
