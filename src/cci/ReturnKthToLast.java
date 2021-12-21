package cci;

import leetcode.ListNode;

public class ReturnKthToLast {

  public static ListNode returnKthElementToLast(ListNode head, int k) {
    ListNode p1 = head;
    ListNode p2 = head;

    for (int i = 0; i < k; i++) {
      if (p1 == null) {
        return null;
      }
      p1 = p1.next;
    }

    while (p1 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return new ListNode(p2.val);
  }

  public static void main(String[] args) {
    ListNode nodes = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))));
    ListNode nodes1 = new ListNode(1);

    System.out.println(returnKthElementToLast(nodes, 2));
    System.out.println(returnKthElementToLast(null, 2));
    System.out.println(returnKthElementToLast(nodes1, 5));
  }

}
