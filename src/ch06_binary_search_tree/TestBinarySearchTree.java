package ch06_binary_search_tree;

import java.util.Random;

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
        Random random = new Random();


        // 测试添加元素 `add(...)` 方法
        for (int i = 0; i < nums.length; ++i) {
            bst.add(nums[i]);
        }

        // 测试 `contains(...)` 方法
//        System.out.println(bst.contains(6));

        // 测试二分搜索树的前序遍历
//        bst.preOrder();
//        System.out.println();

        // 测试 `toString()` 方法
//        System.out.println(bst);

        // 测试二分搜索树的中序遍历
//        bst.inOrder();
//        System.out.println();

        // 测试二分搜索树的后序遍历
//        bst.postOrder();
//        System.out.println();

        // 测试二分搜索树的前序遍历（非递归版本）
//        bst.preOrderNR();
//        System.out.println();

        // 测试二分搜索树的层序遍历
//        bst.levelOrder();
//        System.out.println();

        // 测试 `minimum()` 方法
//        System.out.println(bst.minimum());
//        System.out.println();

        // 测试 `minimumNR()` 方法
//        System.out.println(bst.minimumNR());
//        System.out.println();

        // 测试 `maximum()` 方法
//        System.out.println(bst.maximum());
//        System.out.println();

        // 测试 `maximumNR()` 方法
//        System.out.println(bst.maximumNR());
//        System.out.println();

        // 测试 `removeMin()` 方法
//        int n = 1000;
//        for (int i = 0; i < n; ++i) {
//            bst.add(random.nextInt(10000));
//        }
//
//        List<Integer> numList = new LinkedList<>();
//        while (!bst.isEmpty()) {
//            numList.add(bst.removeMin());
//        }
//
//        System.out.println("The number of elements is: " + numList.size());
//        System.out.println(numList);
//        for (int i = 1; i < numList.size(); ++i) {
//            if (numList.get(i-1) > numList.get(i)) {
//                throw new IllegalArgumentException("Error!!!");
//            }
//        }
//        System.out.println("Success ( ^ _ ^ ) V");

        // 测试 `removeMax()` 方法
//        int n = 10000;
//        for (int i = 0; i < n; ++i) {
//            bst.add(random.nextInt(100000));
//        }
//
//        List<Integer> numList = new LinkedList<>();
//        while (!bst.isEmpty()) {
//            numList.add(bst.removeMax());
//        }
//
//        System.out.println("The number of elements is: " + numList.size());
//        System.out.println(numList);
//        for (int i = 1; i < numList.size(); ++i) {
//            if (numList.get(i - 1) < numList.get(i)) {
//                throw new IllegalArgumentException("Error!!!");
//            }
//        }
//        System.out.println("Success ( ^ _ ^ ) V");

        // 测试 `remove(...)` 方法
        bst.preOrder();
        System.out.println();
        bst.remove(3);
        bst.preOrder();
        System.out.println();
    }
}
