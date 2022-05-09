package algo;

public abstract class Heap {

  protected int[] heap;
  protected int size;
  protected int maxSize;

  public int getMax() {
    return heap[0];
  }

  public int extractMax() {
    int max = heap[0];
    heap[0] = heap[size--];
    heapify(0);
    return max;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void insert(int element) {
    if (size + 1 >= maxSize) {
      expandHeap();
    }

    heap[size] = element;
    int current = size;
    while (heap[current] > heap[getRoot(current)]) {
      swap(current, getRoot(current));
      current = getRoot(current);
    }
    size++;
  }

  protected abstract void heapify(int position);

  protected boolean isLeaf(int position) {
    return position > (size / 2) && position <= size;
  }

  protected void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  protected int getRoot(int position) {
    return (position - 1) / 2;
  }

  protected int getLeft(int position) {
    return (2 * position) + 1;
  }

  protected int getRight(int position) {
    return (2 * position) + 2;
  }

  private void expandHeap() {
    maxSize = maxSize + (maxSize / 2) + 1;
    int[] newArr = new int[maxSize];
    System.arraycopy(heap, 0, newArr, 0, heap.length);
    heap = newArr;
  }
}
