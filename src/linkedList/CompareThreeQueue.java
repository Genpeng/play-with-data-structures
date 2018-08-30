package linkedList;

import queue.ArrayQueue;
import queue.LoopQueue;
import queue.Queue;

import java.util.Random;

/**
 * Compare three self-defined queue class {@code ArrayQueue}, {@code LoopQueue}, and {@code LinkedListQueue}.
 *
 * @author  StrongXGP
 * @date    2018/06/22
 */
public class CompareThreeQueue {
    public static void main(String[] args) {
        int opCount = 100000;

//        Queue<Integer> queue1 = new ArrayQueue<>();
//        double time1 = testQueue(queue1, opCount);
//        System.out.println("ArrayQueue, time: " + time1 + " s.");

        Queue<Integer> queue2 = new LoopQueue<>();
        double time2 = testQueue(queue2, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s.");

        Queue<Integer> queue3 = new LinkedListQueue<>();
        double time3 = testQueue(queue3, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s.");
    }

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime-startTime) / 1000000000.0;
    }
}
