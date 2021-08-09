/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumOfLeftLeaves = function(root) {
  if(root === null) return 0;
  
  return check(root.left) + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
};

const check = (root) => {
  if(root === null) return 0;
  else if(root.left === null && root.right === null) {
      return root.val;
  }
  return 0;
}

// URL:https://leetcode.com/problems/sum-of-left-leaves/
// Q
// Given the root of a binary tree, return the sum of all left leaves.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: 24
// Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
// Example 2:

// Input: root = [1]
// Output: 0
 

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// -1000 <= Node.val <= 1000

