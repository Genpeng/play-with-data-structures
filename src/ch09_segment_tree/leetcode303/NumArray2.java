package ch09_segment_tree.leetcode303;

/**
 * This is the solution of No. 303 problem in the LeetCode, which uses
 * customized segment tree class, the website of the problem is as follow:
 * https://leetcode-cn.com/problems/range-sum-query-immutable/description/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/18
 */
public class NumArray2 {
    /**
     * The sum of elements, where `sum[i]` represents the sum of the first i elements,
     * that is `nums[0] + nums[1] + nums[2] + ... + nums[i-1]`.
     */
    private int[] sum;

    public NumArray2(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("[ERROR] The input array can not be null!");
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (isIllegal(i) || isIllegal(j) || i > j) {
            throw new IllegalArgumentException("[ERROR] Illegal index!");
        }
        return sum[j + 1] - sum[i];
    }

    private boolean isLegal(int index) {
        return index >= 0 && index <= sum.length - 2;
    }

    private boolean isIllegal(int index) {
        return !isLegal(index);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 5));
    }
}
