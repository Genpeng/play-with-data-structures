package ch07_set_and_map;

import java.util.HashSet;

/**
 * The solution of no. 804 LeetCode proplem, the url is given as follow:
 * https://leetcode.com/problems/unique-morse-code-words/description/
 *
 * @author StrongXGP (xgp1227@gmail.com)
 * @date 2018/09/26
 */
public class Problem804Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        HashSet<String> wordRepresentations = new HashSet<>();
        for (String word : words) {
            StringBuilder representation = new StringBuilder();
            for (char letter : word.toCharArray()) {
                representation.append(morseCodes[letter - 'a']);
            }
            wordRepresentations.add(representation.toString());
        }
        return wordRepresentations.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        Problem804Solution solution = new Problem804Solution();
        int num = solution.uniqueMorseRepresentations(words);
        System.out.println(num);
    }
}
