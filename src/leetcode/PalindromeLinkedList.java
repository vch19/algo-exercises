package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

  //Time complexity O(n). Space complexity O(n)
  public static boolean isPalindrome(ListNode head) {
    List<Integer> list = new ArrayList<>();

    while (head != null) {
      list.add(head.val);
      head = head.next;
    }

    int mid = list.size() / 2;
    int start = 0;
    int end = list.size() - 1;

    while (start <= mid && end >= mid) {
      if (list.get(start++).compareTo(list.get(end--)) != 0) {
        return false;
      }
    }

    return true;
  }

  //More efficient solution.
  //Time complexity O(n). Space complexity O(1).
  public static boolean isPalindrome2(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

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
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }

  public static void main(String[] args) {
    System.out.println(
        isPalindrome2(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
    System.out.println(isPalindrome2(new ListNode(1, new ListNode(0, new ListNode(1)))));
  }
}
