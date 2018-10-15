package ch07_set_and_map;

import util.FileUtil;

import java.util.List;

/**
 * Compares different implementations of map.
 *
 * @author  StrongXGP
 * @date    2018/10/15
 */
public class CompareMap {
    public static double testMap(Map<String, Integer> map, String pathname) {
        double startTime = System.nanoTime();
        System.out.println("[INFO] The directory of the file is: " + pathname);
        List<String> wordList = FileUtil.getAllWords(pathname);
        System.out.println("[INFO] Total words: " + wordList.size());
        for (String word : wordList) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("[INFO] Total different words: " + map.getSize());
        System.out.println("[INFO] The frequency of 'pride' is: " + map.get("pride"));
        System.out.println("[INFO] The frequency of 'prejudice' is: " + map.get("prejudice"));
        double endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String pathname = "data/pride-and-prejudice.txt";

        Map<String, Integer> map1 = new LinkedListMap<>();
        double t1 = testMap(map1, pathname);
        System.out.format("[INFO] Done in %f seconds.%n", t1);

        System.out.println();

        Map<String, Integer> map2 = new BSTMap<>();
        double t2 = testMap(map2, pathname);
        System.out.format("[INFO] Done in %f seconds.%n", t2);
    }
}
