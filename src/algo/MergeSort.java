package algo;

public class MergeSort {

  public void mergeSort(int[] array, int length) {
    if (length < 2) {
      return;
    }

    int mid = array.length / 2;
    int[] left = new int[mid];
    int[] right = new int[length - mid];

    for (int i = 0; i < mid; i++) {
      left[i] = array[i];
    }

    for (int i = mid; i < length; i++) {
      right[i - mid] = array[i];
    }

    mergeSort(left, mid);
    mergeSort(right, length - mid);

    merge(array, left, right, mid, length - mid);
  }

  private void merge(int[] a, int[] l, int[] r, int left, int right) {
    int i = 0, j = 0, k = 0;

    while (i < left && j < right) {
      if (l[i] <= r[j]) {
        a[k++] = l[i++];
      } else {
        a[k++] = r[j++];
      }
    }

    while (i < left) {
      a[k++] = l[i++];
    }

    while (j < right) {
      a[k++] = r[j++];
    }
  }

  public static void main(String[] args) {
    new MergeSort().mergeSort(new int[]{10, 6, 8, 5, 7, 3, 4}, 7);
  }

}
