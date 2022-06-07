package grokkingAlgoCourse.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

  public static int findLength(char[] arr) {
    int max = 0;
    Map<Character, Integer> frequency = new HashMap<>();

    int a = 0;
    int b = 0;

    while (b < arr.length) {
      if (frequency.size() == 2 && !frequency.containsKey(arr[b])) {
        max = Math.max(max, b - a);
        frequency.put(arr[a], frequency.get(arr[a]) - 1);
        if (frequency.get(arr[a]) == 0) {
          frequency.remove(arr[a]);
        }
        a++;
      } else {
        frequency.put(arr[b], frequency.getOrDefault(arr[b], 0) + 1);
        b++;
      }
    }
    return Math.max(max, b - a);
  }

  public static void main(String[] args) {
    System.out.println(findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
    System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
  }
}
