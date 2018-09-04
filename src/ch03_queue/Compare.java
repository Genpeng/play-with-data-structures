package ch03_queue;

import java.util.Random;

/**
 * Compare two self-defined queue class.
 *
 * @author  StrongXGP
 * @date    2018/06/18
 */
public class Compare {
    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> queue1 = new ArrayQueue<>();
        double time1 = testQueue(queue1, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> queue2 = new LoopQueue<>();
        double time2 = testQueue(queue2, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
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
