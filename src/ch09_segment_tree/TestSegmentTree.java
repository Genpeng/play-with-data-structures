package ch09_segment_tree;

/**
 * Test the self-defined segment tree.
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/17
 */
public class TestSegmentTree {
    public static void main(String[] args) {
        // 测试线段树的构建
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);

        // 测试线段树的查询
        System.out.println(segmentTree.query(0, 7));
        System.out.println(segmentTree.query(0, 3));
        System.out.println(segmentTree.query(0, 4));
    }
}
