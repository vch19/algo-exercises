package algo;

public class MaxHeap extends Heap {

  public MaxHeap() {
    this.maxSize = 13;
    this.size = 0;
    this.heap = new int[13];
  }

  public MaxHeap(int maxSize) {
    this.maxSize = maxSize;
    this.size = 0;
    this.heap = new int[maxSize];
  }

  @Override
  protected void heapify(int position) {
    if (!isLeaf(position)) {
      if (heap[position] < heap[getLeft(position)] || heap[position] < heap[getRight(position)]) {
        if (heap[getLeft(position)] > heap[getRight(position)]) {
          swap(position, getLeft(position));
          heapify(position);
        } else {
          swap(position, getRight(position));
          heapify(position);
        }
      }
    }
  }
}
