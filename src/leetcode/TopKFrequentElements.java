package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();

    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    Queue<Integer> heap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

    for (Integer num : freq.keySet()) {
      heap.add(num);
    }

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = heap.poll();
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr = new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 2}, 2);
    System.out.println(Arrays.toString(arr));
  }
}
