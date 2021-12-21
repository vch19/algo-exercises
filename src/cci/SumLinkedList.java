package cci;

import leetcode.ListNode;

public class SumLinkedList {

  public static ListNode sum(ListNode first, ListNode second) {
    ListNode result = new ListNode(0);

    recursion(first, second, result, 0);

    return result.next;
  }

  private static void recursion(ListNode first, ListNode second, ListNode result, int residue) {
    if (first == null && second == null) {
      if (residue > 0) {
        result.next = new ListNode(residue);
      }
      return;
    } else if (first == null) {
      int val = second.val + residue;
      recursion(null, second.next, result.next = new ListNode(val % 10),
          val / 10 != 0 ? val / 10 : 0);
      return;
    } else if (second == null) {
      int val = first.val + residue;
      recursion(first.next, null, result.next = new ListNode(val % 10),
          val / 10 != 0 ? val / 10 : 0);
      return;
    }
    int val = first.val + second.val + residue;
    recursion(first.next, second.next, result.next = new ListNode(val % 10),
        val / 10 != 0 ? val / 10 : 0);
  }

  public static void main(String[] args) {
    System.out.println(sum(
        new ListNode(7, new ListNode(1, new ListNode(6))),
        new ListNode(5, new ListNode(9, new ListNode(2)))) //2 -> 1 -> 9
    );

    System.out.println(sum(
        new ListNode(9, new ListNode(8, new ListNode(7))),
        new ListNode(3, new ListNode(4, new ListNode(4))) //2 -> 3 -> 2 -> 1
    ));

    System.out.println(sum(
        new ListNode(9, new ListNode(9, new ListNode(9))),
        new ListNode(1) //0 -> 0 -> 0 -> 1
    ));
  }
}
