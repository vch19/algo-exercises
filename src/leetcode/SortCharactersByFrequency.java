package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {

  public static String frequencySort(String s) {
    Map<Character, Integer> frequency = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
    }

    Queue<Character> heap = new PriorityQueue<>((a, b) -> frequency.get(b) - frequency.get(a));
    heap.addAll(frequency.keySet());

    StringBuilder sb = new StringBuilder();

    while (!heap.isEmpty()) {
      char ch = heap.poll();
      sb.append(String.valueOf(ch).repeat(Math.max(0, frequency.get(ch))));
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(frequencySort("cccaaa"));
  }
}
