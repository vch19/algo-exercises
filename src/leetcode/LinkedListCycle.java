package leetcode;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        int counter = 0;

        while (head != null) {
            if (head.val >= 0 && head.val < counter) {
                return true;
            }
            counter++;
            head = head.next;
        }

        return false;
    }

    public static boolean hasCycleEffective(ListNode head) {
        if (head == null) return false;

        ListNode turtle = head;
        ListNode hare = head;

        while (hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (hare == turtle) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasCycleEffective(new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4, new ListNode(1))))))); //true
        System.out.println(hasCycleEffective(new ListNode(1, new ListNode(0))));//true
        System.out.println(hasCycleEffective(new ListNode(1, new ListNode(-1))));//false

        long time = System.currentTimeMillis();
        System.out.println(hasCycleEffective(new ListNode(-1,
            new ListNode(-7, new ListNode(7, new ListNode(-4, new ListNode(19,
                new ListNode(6, new ListNode(-9,
                    new ListNode(-5, new ListNode(-2,
                        new ListNode(-5, new ListNode(6)))))))))))));//true
        System.out.println(System.currentTimeMillis() - time);
    }
}
