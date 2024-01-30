package leetcode;

import java.util.Arrays;

public class BoatsToSavePeople {

  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);

    int boats = 0;

    int left = 0;
    int right = people.length - 1;

    while (left <= right) {
      if (left == right && people[left] <= limit) {
        right--;
        boats++;
      } else if (people[left] + people[right] <= limit) {
        left++;
        right--;

        boats++;
      } else {
        if (people[left] + people[right] > limit) {
          right--;
        } else {
          left++;
        }
        boats++;
      }
    }

    return boats;
  }

  //   2  1  1
  //1, 2, 2, 3, k = 3
  //3 + 1 => 4

  //
  // 1, 2, 2, 3

  public static void main(String[] args) {
    System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));//3
    System.out.println(numRescueBoats(new int[]{1, 2}, 3));//1
    System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));//4
    System.out.println(numRescueBoats(new int[]{7, 3, 2}, 8));//2
  }

}
