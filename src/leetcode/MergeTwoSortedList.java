package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList {

  public static ListNode mergeTwoLists(ListNode left, ListNode right) {
    List<ListNode> nodes = new ArrayList<>();
    nodes.add(new ListNode());

    int i = 0;
    int leftSize = size(left);

    int j = 0;
    int rightSize = size(right);

    int k = 0;

    while (i < leftSize && j < rightSize) {
      if (left.val <= right.val) {
        nodes.add(nodes.get(k).next = new ListNode(left.val));
        left = left.next;
        i++;
        k++;
      } else {
        nodes.add(nodes.get(k).next = new ListNode(right.val));
        right = right.next;
        j++;
        k++;
      }
    }

    while (i < leftSize) {
      nodes.add(nodes.get(k).next = new ListNode(left.val));
      left = left.next;
      i++;
      k++;
    }

    while (j < rightSize) {
      nodes.add(nodes.get(k).next = new ListNode(right.val));
      right = right.next;
      j++;
      k++;
    }

    return nodes.get(0).next;
  }

  private static int size(ListNode node) {
    int counter = 0;

    while (node != null) {
      counter++;
      node = node.next;
    }

    return counter;
  }

  public static void main(String[] args) {
    ListNode left = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode right = new ListNode(1, new ListNode(3, new ListNode(4)));
    System.out.println(mergeTwoLists(left, right));
  }
}
