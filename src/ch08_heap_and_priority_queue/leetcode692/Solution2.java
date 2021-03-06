package ch08_heap_and_priority_queue.leetcode692;

import java.util.*;

/**
 * This is the solution of No. 692 problem in the LeetCode by using a priority queue,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/05
 */
public class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 统计单词的词频
        //    时间复杂度为 O(n)
        Map<String, Integer> wordFreq = new HashMap<>(16);
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // 2. 维护一个大小为k的最小堆，遍历上面得到的map，
        //    将单词添加到堆中，当堆中元素的数目大于k时，弹出堆顶元素
        //    时间复杂度为 O(N * log(k))
        PriorityQueue<String> pq = new PriorityQueue<>(
                (w1, w2) -> wordFreq.get(w1).equals(wordFreq.get(w2)) ?
                        w2.compareTo(w1) : wordFreq.get(w1) - wordFreq.get(w2));
        for (String word : wordFreq.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 3. 弹出堆中所有（k个）元素，并将它们的顺序进行反转
        //    时间复杂度为 O(k * log(k))
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 1;
        System.out.println((new Solution2()).topKFrequent(words, k));
    }
}
