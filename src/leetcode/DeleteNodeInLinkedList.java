package leetcode;

public class DeleteNodeInLinkedList {

  public static void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
    System.out.println(node);
    deleteNode(node);
    System.out.println(node);
  }
}
