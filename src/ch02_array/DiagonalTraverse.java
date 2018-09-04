package ch02_array;

/**
 * The 498th problem of LeetCode.
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * @author StrongXGP
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length, n = matrix[0].length;

        int[] res = new int[m * n];
        int row = 0, col = 0, d = 1;
        for (int i = 0; i < m*n; i++) {
            res[i] = matrix[row][col];

            row -= d;
            col += d;

            // lower border
            if (row >= m) {
                row -= 1;
                col += 2;
                d = -d;
            }

            // right border
            if (col >= n) {
                col -= 1;
                row += 2;
                d = -d;
            }

            // upper border
            if (row < 0) {
                row = 0;
                d = -d;
            }

            // left border
            if (col < 0) {
                col = 0;
                d = -d;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[] res = (new DiagonalTraverse()).findDiagonalOrder(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
