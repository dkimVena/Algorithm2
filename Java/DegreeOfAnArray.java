public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
        
        int maxCount = 0;
        int result = Integer.MAX_VALUE;
        
        for(Map.Entry<Integer, List<Integer>> key : map.entrySet()) {
            int subLen = key.getValue().get(key.getValue().size() - 1) - key.getValue().get(0) + 1;
            
            if(maxCount < key.getValue().size()) {
                maxCount = key.getValue().size();
                result = subLen;
            } else if (maxCount == key.getValue().size()) {
                result = Math.min(result, subLen);
            }
        }
        return result;
    }
}


// URL: https://leetcode.com/problems/degree-of-an-array/

// Q

// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 

// Example 1:

// Input: nums = [1,2,2,3,1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.
// Example 2:

// Input: nums = [1,2,2,3,1,4,2]
// Output: 6
// Explanation: 
// The degree is 3 because the element 2 is repeated 3 times.
// So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 

// Constraints:

// nums.length will be between 1 and 50,000.
// nums[i] will be an integer between 0 and 49,999.

