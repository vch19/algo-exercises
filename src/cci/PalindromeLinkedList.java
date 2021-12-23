package cci;

import leetcode.ListNode;

public class PalindromeLinkedList {

  public static boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    if (fast != null) {
      slow = slow.next;
    }

    fast = head;

    slow = reverse(slow);

    while (slow != null) {
      if (slow.val != fast.val) {
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }

    return true;
  }

  private static ListNode reverse(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode reversed = new ListNode(head.val);
    head = head.next;

    while (head != null) {
      ListNode temp = reversed;
      reversed = new ListNode(head.val);
      reversed.next = temp;
      head = head.next;
    }

    return reversed;
  }

  public static void main(String[] args) {
    System.out.println(
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))))); //true

    System.out.println(
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3)))) //false
    );
  }
}
