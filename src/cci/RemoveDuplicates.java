package cci;

import java.util.HashSet;
import java.util.Set;
import leetcode.ListNode;

public class RemoveDuplicates {

  public static void removeDuplicates(ListNode head) {
    Set<Integer> elements = new HashSet<>();

    ListNode current = head;
    ListNode prev = null;

    while (current != null) {
      int currentValue = current.val;

      if (elements.contains(currentValue)) {
        prev.next = current.next;
      } else {
        elements.add(currentValue);
        prev = current;
      }
      current = current.next;
    }
  }

  public static void main(String[] args) {
    ListNode nodes = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));

    removeDuplicates(nodes);

    System.out.println(nodes);
  }

}
