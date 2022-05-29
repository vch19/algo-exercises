package leetcode;

public class MergeNodesInBetweenZeros {

  public static ListNode mergeNodes(ListNode head) {
    ListNode result = new ListNode();
    recursion(head, result);
    return result.next;
  }

  private static void recursion(ListNode head, ListNode result) {
    if (head == null) {
      return;
    }

    while (head.val != 0) {
      result.val += head.val;
      head = head.next;
    }

    if (head.next != null) {
      result.next = new ListNode();
      result = result.next;
    }

    recursion(head.next, result);
  }

  public static void main(String[] args) {
    //0,3,1,0,4,5,2,0
    System.out.println(mergeNodes(new ListNode(0, new ListNode(3, new ListNode(1,
        new ListNode(0,
            new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0)))))))))); //4, 11
  }

}
