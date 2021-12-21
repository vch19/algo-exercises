package cci;

import leetcode.ListNode;

public class DeleteMiddleNode {

  public static ListNode deleteMiddle(ListNode head) {
    if (head.next == null) {
      return null;
    }

    ListNode temp = new ListNode(0, head);
    ListNode fast = temp;
    ListNode slow = temp;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;

    return head;
  }

  public static void main(String[] args) {
    ListNode nodes = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
    ListNode nodes1 = new ListNode(1, new ListNode(3,
        new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));

    System.out.println(deleteMiddle(nodes));
    System.out.println(deleteMiddle(nodes1));
    System.out.println(deleteMiddle(new ListNode(2, new ListNode(1))));
  }

}
