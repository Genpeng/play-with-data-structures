package ch04_linked_list;

import ch03_queue.Queue;

/**
 * Test the self-defined queue class {@code LinkedListQueue}.
 *
 * @author  StrongXGP
 * @date    2018/06/22
 */
public class TestLinkedListQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i=0; i<10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
