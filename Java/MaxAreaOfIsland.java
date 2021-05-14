class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] arr = new int[row][col];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                arr[i][j] = grid[i][j];
            }
        }
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(arr[i][j] == 1) {
                    result = Math.max(result, helpFunc(arr, i, j));
                }
            }
        }
        
        return result;
    }
    
    public int helpFunc(int[][] arr, int row, int col) {
        int result = 0;
        if(row>=0 && row<arr.length && col>=0 && col<arr[0].length && arr[row][col] == 1) {
            result++;
            arr[row][col] = 0;
        }
        else return 0;
        
        return result 
            + helpFunc(arr, row-1, col) 
            + helpFunc(arr, row+1, col) 
            + helpFunc(arr, row, col+1) 
            + helpFunc(arr, row, col-1);
    }
}

// URL: https://leetcode.com/problems/max-area-of-island/
//Q
// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

 

// Example 1:


// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
// Example 2:

// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.