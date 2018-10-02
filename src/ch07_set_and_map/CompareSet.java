package ch07_set_and_map;

import util.FileUtil;

import java.util.List;

/**
 * Compare different implementations of set.
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/09/20
 */
public class CompareSet {
    private static double testSet(Set<String> set, String pathname) {
        long startTime = System.nanoTime();
        System.out.println("[INFO] The directory of the file is: " + pathname);
        List<String> wordList = FileUtil.getAllWords(pathname);
        System.out.println("[INFO] Total words: " + wordList.size());
        for (String word : wordList) {
            set.add(word);
        }
        System.out.println("[INFO] Total different words: " + set.getSize());
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String pathname = "data/a-tale-of-two-cities.txt";

        // 测试 LinkedListSet
        Set<String> set1 = new LinkedListSet<>();
        double time1 = testSet(set1, pathname);
        System.out.format("[INFO] Done in %f seconds.%n", time1);

        System.out.println();

        // 测试 BSTSet
        Set<String> set2 = new BSTSet<>();
        double time2 = testSet(set2, pathname);
        System.out.format("[INFO] Done in %f seconds.%n", time2);
    }
}
