package leetcode;

public class MinimumOperationsToMakeTheArrayIncreasing {
    public static int minOperations(int[] nums) {
        int counter = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                int diff = nums[i] - nums[i + 1];
                nums[i + 1] += diff + 1;
                counter += diff + 1;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[] { 1, 5, 2, 4, 1 }));
        System.out.println(minOperations(new int[] { 1, 1, 1 }));
        System.out.println(minOperations(new int[] { 0 }));
    }
}
