package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

  public static String reorganizeString(String s) {
    Map<Character, Integer> freq = new HashMap<>();
    for (Character ch : s.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }

    StringBuilder sb = new StringBuilder();

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

    maxHeap.addAll(freq.keySet());

    while (!maxHeap.isEmpty()) {
      Character mostFrequent = maxHeap.poll();
      Character frequent = null;

      if (!maxHeap.isEmpty()) {
        frequent = maxHeap.poll();
      }

      sb.append(mostFrequent).append(frequent == null ? "" : frequent);

      if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
        return "";
      }

      freq.put(mostFrequent, freq.get(mostFrequent) - 1);

      if (frequent != null) {
        freq.put(frequent, freq.get(frequent) - 1);
      }

      if (freq.get(mostFrequent) <= 0) {
        freq.remove(mostFrequent);
      }
      if (frequent != null && freq.get(frequent) <= 0) {
        freq.remove(frequent);
      }

      if (freq.containsKey(mostFrequent)) {
        maxHeap.add(mostFrequent);
      }
      if (freq.containsKey(frequent)) {
        maxHeap.add(frequent);
      }
    }

    return sb.toString();
  }

}
