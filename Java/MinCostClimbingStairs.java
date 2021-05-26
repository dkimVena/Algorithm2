public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] arr = new int[cost.length];
        arr[0] = cost[0];
        arr[1] = cost[1];
        
        for(int i=2; i<cost.length; i++) {
            arr[i] = Math.min(arr[i-2] + cost[i], arr[i-1] + cost[i]);
        }
        
        return Math.min(arr[cost.length-1], arr[cost.length-2]);
    }
}


// URL: https://leetcode.com/problems/min-cost-climbing-stairs/

// Q
// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

 

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
// Example 2:

// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 

// Constraints:

// 2 <= cost.length <= 1000
// 0 <= cost[i] <= 999