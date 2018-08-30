package ch6_binarySearchTree;

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
        for (int i = 0; i < nums.length; ++i) {
            bst.add(nums[i]);
        }
        bst.preOrder();
        System.out.println();

//        System.out.println(bst);

//        bst.inOrder();
//        System.out.println();

//        bst.postOrder();
//        System.out.println();

        bst.preOrderNR();
        System.out.println();

        bst.levelOrder();
        System.out.println();
    }
}
