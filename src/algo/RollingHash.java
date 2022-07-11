package algo;

public class RollingHash {

  private static final int BASE = 15;

  public static long hash(String s) {
    long hash = 0;
    int length = s.length();
    for (int i = 0; i < s.length(); i++) {
      hash += s.charAt(i) * Math.pow(BASE, length);
    }
    return hash;
  }

  public static void main(String[] args) {
    System.out.println(hash("ashb"));
    System.out.println(hash("bash"));

    long res = (long) Math.pow(10, 4);
    System.out.println(res * Math.pow(10, 5));
  }

}
