package ch08_heap_and_priority_queue;

import java.util.Random;

/**
 * Test the self-defined max heap class.
 *
 * @author  StrongXGP
 * @date    2018/11/10
 */
public class TestMaxHeap {
    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        MaxHeap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < n; ++i) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < n; ++i) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("[ERROR] The implementation of max heap isn't correct!");
            }
        }
        System.out.println("[INFO] The implementation of max heap is correct! ( ^ _ ^ ) V");
    }
}
