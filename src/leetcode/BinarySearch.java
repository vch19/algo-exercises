package leetcode;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private static int helper(int[] nums, int left, int right, int target) {
        int current = (left + right) / 2;

        if (nums[current] == target) {
            return current;
        }

        if (left == right) {
            return -1;
        }

        if (nums[current] > target) {
            return helper(nums, left, current, target);
        } else {
            return helper(nums, current + 1, right, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
