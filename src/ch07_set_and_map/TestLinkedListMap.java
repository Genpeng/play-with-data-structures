package ch07_set_and_map;

import util.FileUtil;

import java.util.List;

/**
 * Test the self-defined map class -- {@code LinkedListMap}.
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/10/03
 */
public class TestLinkedListMap {
    public static void main(String[] args) {
        String pathname = "data/pride-and-prejudice.txt";
        System.out.println(pathname);
        List<String> words = FileUtil.getAllWords(pathname);
        System.out.println("The number of total words is: " + words.size());
        Map<String, Integer> word2FreqMap = new LinkedListMap<>();
        for (String word : words) {
            if (word2FreqMap.contains(word)) {
                word2FreqMap.set(word, word2FreqMap.get(word) + 1);
            } else {
                word2FreqMap.add(word, 1);
            }
        }
        System.out.println("The number of unique words is: " + word2FreqMap.getSize());
        System.out.println("The frequency of the word 'prejudice' is: " + word2FreqMap.get("prejudice"));
    }
}
