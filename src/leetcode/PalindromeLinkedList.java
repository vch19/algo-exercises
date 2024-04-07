package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();

        recursion(deque, head);

        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                return true;
            }

            int left = deque.pollFirst();
            int right = deque.pollLast();

            if (left != right) {
                return false;
            }
        }

        return true;
    }

    private static void recursion(Deque<Integer> deque, ListNode head) {
        if (head == null) {
            return;
        }

        deque.add(head.val);
        recursion(deque, head.next);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1)));
    }


}

//class ListNode {
//
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
