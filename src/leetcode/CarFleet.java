package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
        }

        Arrays.sort(cars, Comparator.comparing(value -> value[0], Comparator.reverseOrder()));

        int fleets = 0;

        double maxStepsToTarget = cars[0][1];
        for (int i = 1; i < cars.length; i++) {
            if (maxStepsToTarget < cars[i][1]) {
                maxStepsToTarget = cars[i][1];
                fleets++;
            }
        }

        return maxStepsToTarget >= cars[cars.length - 1][1] ? fleets + 1 : fleets;
    }

    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));//3
        System.out.println(carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1})); //1
        System.out.println(carFleet(10, new int[]{6, 8}, new int[]{3, 2})); //2
    }
}
