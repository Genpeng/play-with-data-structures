package ch07_set_and_map;

public class TestBSTSet {
    public static void main(String[] args) {
        Set<String> wordSet = new BSTSet<>();
        wordSet.add("book");
        wordSet.add("apple");
        wordSet.add("banana");
        System.out.println(wordSet);
    }
}
