package cci;

public class OneAway {

  public static boolean oneAway(String original, String modified) {
    if (Math.abs(original.length() - modified.length()) > 1) {
      return false;
    }

    int mutations = 0;

    for (int i = 0; i < Math.min(original.length(), modified.length()); i++) {
      if (mutations > 1) {
        return false;
      }

      if (original.charAt(i) != modified.charAt(i)) {
        mutations++;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(oneAway("pale", "ple")); //true
    System.out.println(oneAway("p", "")); //true
    System.out.println(oneAway("pale", "")); //false
    System.out.println(oneAway("pale", "bake")); //false
    System.out.println(oneAway("pale", "baker")); //false
  }

}
