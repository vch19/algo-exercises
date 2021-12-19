package cci;

public class StringCompression {

  public static String compress(String s) {
    if (s.length() == 0) {
      return null;
    }

    StringBuilder sb = new StringBuilder();

    int count = 1;
    char prev = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (prev != s.charAt(i)) {
        sb.append(prev).append(count);
        count = 1;
      } else {
        count++;
      }
      prev = s.charAt(i);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(compress("aabcccccaaa")); //a2b1c5
    System.out.println(compress("")); //null
    System.out.println(compress("         ab")); // ` `9a1b1
  }

}
