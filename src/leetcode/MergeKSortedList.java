package leetcode;

import algo.Heap;
import algo.MaxHeap;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

  public static ListNode mergeKLists(ListNode[] nodes) {
    Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

    for (ListNode node : nodes) {
      while (node != null) {
        heap.add(node.val);
        node = node.next;
      }
    }

    ListNode result = null;

    while (!heap.isEmpty()) {
      ListNode temp = result;
      result = new ListNode(heap.poll());
      result.next = temp;
    }

    return result;
  }

  public static ListNode mergeKLists2(ListNode[] nodes) {
    Heap heap = new MaxHeap();

    for (ListNode node : nodes) {
      while (node != null) {
        heap.insert(node.val);
        node = node.next;
      }
    }

    ListNode result = null;

    while (!heap.isEmpty()) {
      ListNode temp = result;
      result = new ListNode(heap.extractMax());
      result.next = temp;
    }

    return result;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    ListNode l3 = new ListNode(2, new ListNode(6));

    ListNode[] nodes = new ListNode[]{l1, l2, l3};

    System.out.println(mergeKLists(nodes)); //1->1->2->3->4->4->5->6
    System.out.println(mergeKLists2(nodes)); //1->1->2->3->4->4->5->6
  }
}
