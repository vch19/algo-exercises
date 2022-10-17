package codeforces;

import java.util.Scanner;

public class Main {

  public static boolean divide(int k) {
    return k % 2 == 0;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    if (divide(i)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
//    for (int j = 0; j < i; j++) {
//      int val = scanner.nextInt();
//      if (divide(val)) {
//        System.out.println("YES");
//      } else {
//        System.out.println("NO");
//      }
//    }
  }
}
