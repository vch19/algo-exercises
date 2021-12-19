package algo;

import java.util.Arrays;

public class QuickSort {

  public static void quickSort(int[] array) {
    qsHelper(array, 0, array.length - 1);
  }

  //Method to find the largest value in unsorted array for O(n)
  private static int findKLargestValue(int[] array, int pos) {
    int left = 0;
    int right = array.length - 1;

    while (true) {
      int middle = partition(array, left, right);
      if (middle == array[pos]) {
        return array[pos];
      } else if (middle < array[pos]) {
        left++;
      } else {
        right--;
      }
    }
  }

  private static void qsHelper(int[] arr, int left, int right) {
    if (left < right) {
      int middle = partition(arr, left, right);
      qsHelper(arr, left, middle - 1);
      qsHelper(arr, middle + 1, right);
    }
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[right]; //for simplicity, we'll use the last value of array as a pivot
    int j = left - 1;

    //For the left side we should have an elements which are less than pivot and vise versa.
    for (int i = left; i <= right; i++) {
      if (arr[i] < pivot) {
        j++;

        swap(arr, j, i);
      }
    }

    //At the end we swap pivot to the end
    swap(arr, j + 1, right);
    return j + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{10, 6, 8, 5, 7, 3, 4};
    System.out.println(findKLargestValue(arr, 0));
    quickSort(arr);

    System.out.println(Arrays.toString(arr));
  }
}
