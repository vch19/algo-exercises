package leetcode;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode def = head;
        ListNode reverse = null;

        while (head != null) {
            ListNode tmp = reverse;
            reverse = new ListNode(head.val);
            reverse.next = tmp;
            head = head.next;
        }

        while (def != null) {
            if (def.val != reverse.val) {
                return false;
            }
            def = def.next;
            reverse = reverse.next;
        }

        return true;
    }

    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
        isPalindrome(new ListNode(1, new ListNode(0, new ListNode(1))));
    }
}
