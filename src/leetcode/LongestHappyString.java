package leetcode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestHappyString {

  public static String longestDiverseString(int a, int b, int c) {
    Queue<Pair> pairs =
        new PriorityQueue<>((first, second) -> second.count - first.count);

    pairs.addAll(List.of(Pair.of('a', a), Pair.of('b', b), Pair.of('c', c)));

    StringBuilder sb = new StringBuilder();

    while (!pairs.isEmpty()) {
      Pair top = pairs.poll();
      Pair second = pairs.isEmpty() ? null : pairs.poll();

      if (sb.length() != 0 && sb.charAt(sb.length() - 1) == top.ch) {
        break;
      }

      appendString(sb, top, top.count);

      if (second == null) {
        break;
      }

      int counter = top.count < second.count
          ? Math.min(2, second.count)
          : Math.min(1, second.count);

      appendString(sb, second, counter);

      if (top.count > 0) {
        pairs.offer(top);
      }

      if (second.count > 0) {
        pairs.offer(second);
      }
    }

    return sb.toString();
  }

  private static void appendString(StringBuilder sb, Pair pair, Integer charCount) {
    int counter = Math.min(2, charCount);

    sb.append(String.valueOf(pair.ch).repeat(counter));

    pair.count -= counter;
  }

  private static class Pair {

    public char ch;
    public int count;

    private Pair(char ch, int count) {
      this.ch = ch;
      this.count = count;
    }

    public static Pair of(char ch, int count) {
      return new Pair(ch, count);
    }
  }

  public static void main(String[] args) {
    System.out.println(longestDiverseString(1, 1, 7)); //ccaccbcc
  }
}
