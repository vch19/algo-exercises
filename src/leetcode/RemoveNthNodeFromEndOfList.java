package leetcode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = depth(head, 0) - n;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode proxy = temp;

        while (index > 0) {
            index--;
            proxy = proxy.next;
        }
        proxy.next = proxy.next.next;
        return temp.next;
    }

    public int depth(ListNode head, int depth) {
        if (head == null) {
            return depth;
        }
        return depth(head.next, depth + 1);
    }

    public static void main(String[] args) {
        new RemoveNthNodeFromEndOfList()
            .removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }
}