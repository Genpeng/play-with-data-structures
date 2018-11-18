package ch08_heap_and_priority_queue.leetcode347;

import ch08_heap_and_priority_queue.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No. 347 problem in the LeetCode,
 * which uses the custom priority queue class, the website of
 * the problem is as follow:
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/11
 */
public class Solution {
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        List<Integer> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.dequeue().e);
        }

        return ret;
    }

    private static void printList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); ++i) {
            if (i < list.size() - 1) {
                sb.append(list.get(i)).append(",").append(" ");
            } else {
                sb.append(list.get(i));
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Solution solution = new Solution();
        printList(solution.topKFrequent(nums, k));
    }
}
