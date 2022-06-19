package grokkingAlgoCourse.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumCpuLoad {

  public static int findMaxCPULoad(int[][] jobs) {
    Arrays.sort(jobs, Comparator.comparing(job -> job[0]));

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    minHeap.add(jobs[0]);

    for (int i = 1; i < jobs.length; i++) {
      int[] prevJob = minHeap.remove();
      int[] currJob = jobs[i];

      if (prevJob[1] >= currJob[0]) {
        prevJob[2] += currJob[2];
        prevJob[1] = currJob[1];
      } else {
        minHeap.add(currJob);
      }

      minHeap.add(prevJob);
    }

    int max = 0;

    while (!minHeap.isEmpty()) {
      max = Math.max(max, minHeap.poll()[2]);
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(findMaxCPULoad(new int[][]{{1, 4, 3}, {2, 5, 4}, {7, 9, 6}}));//7
    System.out.println(findMaxCPULoad(new int[][]{{6, 7, 10}, {2, 4, 11}, {8, 12, 15}}));//15
  }
}
