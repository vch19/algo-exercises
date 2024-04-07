package leetcode;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    private static final Comparator<Integer> POSITION_COMPARATOR = Comparator.comparingInt(a -> a);

    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> topCandidates = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        PriorityQueue<Integer> lastCandidates = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        int topIdx = 0;

        while (topIdx < candidates) {
            topCandidates.add(costs[topIdx++]);
        }

        int lastIdx = Math.max(costs.length - candidates, topIdx);

        while (lastIdx < costs.length) {
            lastCandidates.add(costs[lastIdx++]);
        }

        int totalHireCost = 0;

        while (k != 0) {
            if (!lastCandidates.isEmpty()) {
                if (topCandidates.peek().equals(lastCandidates.peek())
                    || topCandidates.peek() > lastCandidates.peek()) {
                    totalHireCost += topCandidates.poll();
                } else {
                    totalHireCost += lastCandidates.poll();
                }
//                topCandidates.add()
            } else {
                totalHireCost += topCandidates.poll();
            }

            k--;
        }

        return totalHireCost;
    }

    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
//        System.out.println(totalCost(new int[]{17, 12, 10, 2}, 3, 4));
    }
}
