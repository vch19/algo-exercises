package leetcode;

public class ReverseInteger {

  //TODO: Won't work if reversed int will be greater that Integer.MAX_VALUE;
  public static int reverse(int x) {
    int reversed = 0;
    boolean isNegative = x < 0;
    x = Math.abs(x);
    int length = (int) Math.log10(x);

    for (int i = (int) Math.pow(10, length); i != 0; i /= 10) {
      if (i != (int) Math.pow(10, length) || x % 10 != 0) {
        reversed += (x % 10) * i;
      }
      x /= 10;
    }

    return isNegative ? reversed * -1 : reversed;
  }

  public static void main(String[] args) {
    System.out.println(reverse(120)); //21
    System.out.println(reverse(0)); //0
    System.out.println(reverse(-123)); //-321
    System.out.println(reverse(123)); //321
    System.out.println(reverse(1534236469)); //321
  }

}
