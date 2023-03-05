package grokkingAlgoCourse.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TripletSumToZero {

  public static List<List<Integer>> searchTriplets(int[] nums) {
    Set<List<Integer>> triplets = new HashSet<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      searchPair(nums, nums[i], i + 1, triplets);
    }

    return new ArrayList<>(triplets);
  }

  private static void searchPair(int[] nums, int target, int left, Set<List<Integer>> triplets) {
    int right = nums.length - 1;

    while (left < right) {
      int currentSum = nums[left] + nums[right] + target;
      if (currentSum == 0) {
        triplets.add(List.of(nums[left], nums[right], target));
        left++;
        right--;
      } else if (currentSum > 0) {
        right--;
      } else {
        left++;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
  }
}
