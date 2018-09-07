package ch06_binarySearchTree;

/**
 * Test the self-defined binary search tree class.
 *
 * @author  StrongXGP (xgp1227@gmai.com)
 * @date    2018/07/17
 */
public class TestBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // 测试添加元素 `add(...)` 方法
        for (int i = 0; i < nums.length; ++i) {
            bst.add(nums[i]);
        }

        // 测试 `contains(...)` 方法
        System.out.println(bst.contains(6));

//        bst.preOrder();
//        System.out.println();

//        System.out.println(bst);

//        bst.inOrder();
//        System.out.println();

//        bst.postOrder();
//        System.out.println();

//        bst.preOrderNR();
//        System.out.println();

//        bst.levelOrder();
//        System.out.println();
    }
}
