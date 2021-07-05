/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int preVal = Integer.MIN_VALUE, cur = 0, allMax = 0;
    private List<Integer> result = new ArrayList<>();
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        
        if(preVal == root.val) {
            cur++;
        } else {
            cur = 1;
        }
        
        if(cur > allMax) {
            allMax = cur;
            result.clear();
            result.add(root.val);
        } else if(cur == allMax) {
            result.add(root.val);
        }
        
        preVal = root.val;
        
        inorder(root.right);
    }
    public int[] findMode(TreeNode root) {
        inorder(root);
        return result.stream().mapToInt(i->i).toArray();
    }
}


// URL: https://leetcode.com/problems/find-mode-in-binary-search-tree/

// Q

// Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

// If the tree has more than one mode, return them in any order.

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:


// Input: root = [1,null,2,2]
// Output: [2]
// Example 2:

// Input: root = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105
 

// Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).