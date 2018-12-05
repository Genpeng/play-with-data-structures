package ch02_array.leetcode283;

public class Solution {
    public int[] moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; ++j) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                --i;
            }
        }
        return nums;
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; ++i) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 2, 0, 3, 0, 4, 0};
        printArray(nums);
        printArray((new Solution()).moveZeroes(nums));
    }
}
