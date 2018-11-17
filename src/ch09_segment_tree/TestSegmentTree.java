package ch09_segment_tree;

/**
 * Test the self-defined segment tree.
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/17
 */
public class TestSegmentTree {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);
    }
}
