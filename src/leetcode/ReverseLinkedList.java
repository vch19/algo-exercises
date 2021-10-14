package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

  public static ListNode reverseList(ListNode head) {
    List<ListNode> nodes = new ArrayList<>();

    while (head != null) {
      nodes.add(new ListNode(head.val));
      head = head.next;
    }

    for (int i = 1; i < nodes.size(); i++) {
      nodes.get(i).next = nodes.get(i - 1);
    }

    return nodes.isEmpty() ? null : nodes.get(nodes.size() - 1);
  }

  public static void main(String[] args) {
    ListNode nodes =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    System.out.println(reverseList(nodes));
  }

}
