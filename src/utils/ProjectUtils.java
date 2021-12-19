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

  public static int[] concatArray(int[] first, int[] second) {
    int[] newArr = new int[first.length + second.length];
    System.arraycopy(first, 0, newArr, 0, first.length);
    System.arraycopy(second, 0, newArr, first.length, second.length);
    return newArr;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(concatArray(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
  }
}
