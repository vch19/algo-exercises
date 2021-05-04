package leetcode;

public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode fastPointer = head;
        ListNode slow = head;
        int length = 0;

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            length++;
        }

        for (int i = 0; i < length / 2; i++) {
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        middleNode(new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5))))));
    }
}
