package ch08_heap_and_priority_queue.leetcode692;

import java.util.*;

/**
 * This is the solution of No. 692 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/05
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 统计单词的词频
        // 时间复杂度为 O(n)
        Map<String, Integer> wordFreq = new HashMap<>(16);
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // 2. 使用桶排序将单词按照词频进行分组
        // 时间复杂度为 O(n)
        List<String>[] bucket = new List[words.length + 1];
        for (String word : wordFreq.keySet()) {
            int freq = wordFreq.get(word);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(word);
        }

        // 3. 取出 top k 词频的单词（备注：词频相同的单词按照字母顺序排列）
        List<String> result = new ArrayList<>();
        for (int i = words.length; i > 0 && result.size() < k; --i) {
            if (bucket[i] != null) {
                if (bucket[i].size() > 1) {
                    Collections.sort(bucket[i]);
                }
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
}
