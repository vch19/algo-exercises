package cci;

import leetcode.ListNode;

public class PartitionList {

  public static ListNode partition(ListNode head, int x) {
    ListNode greater = null;

    ListNode dummy = head;
    while (dummy != null) {
      if (dummy.val >= x) {
        ListNode temp = greater;
        greater = new ListNode(dummy.val);
        greater.next = temp;
      }
      dummy = dummy.next;
    }

    greater = reverse(greater);

    ListNode less = null;
    while (head != null) {
      if (head.val < x) {
        ListNode temp = less;
        less = new ListNode(head.val);
        less.next = temp;
      }
      head = head.next;
    }

    return union(less, greater);
  }

  private static ListNode reverse(ListNode head) {
    ListNode reversed = null;

    while (head != null) {
      ListNode temp = reversed;
      reversed = new ListNode(head.val);
      reversed.next = temp;
      head = head.next;
    }

    return reversed;
  }

  private static ListNode union(ListNode f, ListNode s) {
    ListNode res = s;

    while (f != null) {
      ListNode temp = res;
      res = new ListNode(f.val);
      res.next = temp;

      f = f.next;
    }

    return res;
  }

  public static void main(String[] args) {
    var expression1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));

    var expression2 = new ListNode(2, new ListNode(1));

    var expression3 = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))));

    System.out.println(partition(expression1, 3));//1 -> 2 -> 2 -> 4 -> 3 -> 5
    System.out.println(partition(expression2, 2));//1 -> 2
    System.out.println(partition(expression3, 3));//2 -> 2 -> 4 -> 3 -> 5
  }
}
