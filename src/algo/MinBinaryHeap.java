package algo;

import java.util.NoSuchElementException;

//todo: finish implementation of binary heap
public final class MinBinaryHeap {
    private final int[] heap;
    private int capacity;
    private int size = 0;

    public MinBinaryHeap(int capacity) {
        this.heap = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap[0];
    }

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int value = heap[0];
        heap[0] = heap[size - 1];
        size--;

        //restore heap

        return value;
    }
}
