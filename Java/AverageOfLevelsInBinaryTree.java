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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        List<Double> result = new ArrayList<Double>();
        
        help(root, arr, 0);
        for(ArrayList<Integer> item : arr) {
            double sum = 0;
            for(double ele : item) {
                sum += ele;
            }
            result.add((double)sum / item.size());
        }
        return result;
    }
    
    public void help(TreeNode tree, ArrayList<ArrayList<Integer>> arr, int dep) {
        if(tree == null) return;
        if(arr.size() < dep + 1) {
            arr.add(new ArrayList<Integer>());
        }
        arr.get(dep).add(tree.val);
        help(tree.left, arr, dep + 1);
        help(tree.right, arr, dep + 1);
    }
}