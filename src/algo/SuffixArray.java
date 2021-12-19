package algo;

import java.util.Arrays;

public class SuffixArray {

  private static class Suffix implements Comparable<Suffix> {

    private final int index;
    private int rank;
    private int next;

    private Suffix(int index, int rank1, int rank2) {
      this.index = index;
      this.rank = rank1;
      this.next = rank2;
    }

    public static Suffix of(int index, int rank1, int rank2) {
      return new Suffix(index, rank1, rank2);
    }

    @Override
    public int compareTo(Suffix o) {
      if (rank != o.rank) {
        return Integer.compare(rank, o.rank);
      }
      return Integer.compare(next, o.next);
    }

    @Override
    public String toString() {
      return "Suffix{" +
          "index=" + index +
          ", rank1=" + rank +
          ", rank2=" + next +
          '}';
    }
  }

  public static int[] suffixArray(String s) {
    int n = s.length();

    Suffix[] suffixes = new Suffix[n];

    //Build suffixes and calculate rank for them
    for (int i = 0; i < n; i++) {
      suffixes[i] = Suffix.of(i, s.charAt(i) - '$', i + 1 < n ? s.charAt(i + 1) - '$' : -1);
    }


    //Sort them by comparator above
    Arrays.sort(suffixes);

    //Store suffix indexes
    int[] indexes = new int[n];

    //Iterate until length in diapason 4 -> to 2 ^ s.length()
    for (int length = 4; length < 2 * n; length <<= 1) {
      int rank = 0;
      suffixes[0].rank = 0;
      int prev = suffixes[0].rank;
      indexes[suffixes[0].index] = 0;

      //Update rank of first part of suffix
      for (int j = 1; j < n; j++) {
        if (suffixes[j].rank == prev && suffixes[j].next == suffixes[j - 1].next) {
          prev = suffixes[j].rank;
          suffixes[j].rank = rank;
        } else {
          prev = suffixes[j].rank;
          suffixes[j].rank = ++rank;
        }

        indexes[suffixes[j].index] = j;
      }

      //Update rank of second part of suffix
      for (int j = 0; j < n; j++) {
        int nextSufPartPosition = suffixes[j].index + length / 2;
        suffixes[j].next =
            nextSufPartPosition < n ? suffixes[indexes[nextSufPartPosition]].rank : -1;
      }

      Arrays.sort(suffixes);
    }

    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      result[i] = suffixes[i].index;
    }

    return result;
  }


  public static void main(String[] args) {
    System.out.println(Arrays.toString(suffixArray("banana")));
  }
}
