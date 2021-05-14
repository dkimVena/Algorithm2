class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int size = nums.length;
        for(int i=0; i<size; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            
        }
        
        return map;
    }
    
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        
        Map.Entry<Integer, Integer> majority = null;
        
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(majority == null || entry.getValue() > majority.getValue()) {
                majority = entry;
            }    
        }
                
        return majority.getKey();
    }
}


// URL: https://leetcode.com/problems/majority-element/

// Q
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 104
// -231 <= nums[i] <= 231 - 1
 

// Follow-up: Could you solve the problem in linear time and in O(1) space?

// Arrays.sort(nums);
// return nums[nums.length / 2];