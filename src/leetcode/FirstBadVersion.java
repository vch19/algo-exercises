package leetcode;

public class FirstBadVersion {

  private static final boolean[] VERSIONS = new boolean[]{true, true, true, false, false};

  private static boolean isBadVersion(int version) {
    return !VERSIONS[version];
  }

  public static int firstBadVersion(int n) {
    int pivot;
    int left = 1;
    int right = n;

    while (left < right) {
      pivot = left + (right - left) / 2;
      if (isBadVersion(pivot)) {
        right = pivot;
      } else {
        left = pivot + 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    System.out.println(firstBadVersion(5));
  }

}
