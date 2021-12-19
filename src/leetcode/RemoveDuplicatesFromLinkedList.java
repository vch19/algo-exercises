package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicatesFromLinkedList {

  //Time complexity O(2n) = O(n)
  //Space complexity O(n)
  public static ListNode removeDuplicates(ListNode nodes) {
    if (nodes == null) {
      return null;
    }

    Map<Integer, ListNode> frequency = new HashMap<>();

    while (nodes != null) {
      if (!frequency.containsKey(nodes.val)) {
        frequency.put(nodes.val, new ListNode(nodes.val));
      }
      nodes = nodes.next;
    }

    List<ListNode> nodeList = new ArrayList<>(frequency.values());

    for (int i = 1; i < nodeList.size(); i++) {
      nodeList.get(i - 1).next = nodeList.get(i);
    }

    return nodeList.get(0);
  }

  public static void main(String[] args) {
    ListNode nodes = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2))));
    ListNode nodes1 = new ListNode(1, new ListNode(2, new ListNode(3)));
    ListNode nodes2 = new ListNode();
    ListNode nodes3 = null;
    System.out.println(removeDuplicates(nodes));
    System.out.println(removeDuplicates(nodes1));
    System.out.println(removeDuplicates(nodes2));
    System.out.println(removeDuplicates(nodes3));
  }
}
