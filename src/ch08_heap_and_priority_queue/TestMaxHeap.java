package ch08_heap_and_priority_queue;

import java.util.Random;

/**
 * Test the self-defined max heap class.
 *
 * @author  StrongXGP
 * @date    2018/11/10
 */
public class TestMaxHeap {
    public static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> heap;
        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        } else {
            heap = new MaxHeap<>();
            for (int i = 0; i < testData.length; ++i) {
                heap.add(testData[i]);
            }
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; ++i) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < testData.length; ++i) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("[ERROR] The implementation of max heap isn't correct!");
            }
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        // 测试一：最大堆的实现是否正确
//        int n = 1000000;
//        Random random = new Random();
//        MaxHeap<Integer> heap = new MaxHeap<>();
//        for (int i = 0; i < n; ++i) {
//            heap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        int[] arr = new int[n];
//        for (int i = 0; i < n; ++i) {
//            arr[i] = heap.extractMax();
//        }
//
//        for (int i = 1; i < n; ++i) {
//            if (arr[i - 1] < arr[i]) {
//                throw new IllegalArgumentException("[ERROR] The implementation of max heap isn't correct!");
//            }
//        }
//        System.out.println("[INFO] The implementation of max heap is correct! ( ^ _ ^ ) V");

        // 测试二：Heapify和非Heapify的比较
        int n = 1000000;
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(arr, false);
        System.out.println("Without Heapify: " + time1 + " seconds.");

        double time2 = testHeap(arr, true);
        System.out.println("With Heapify: " + time2 + " seconds.");
    }
}
