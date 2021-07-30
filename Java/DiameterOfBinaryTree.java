public class DiameterOfBinaryTree {
    int result = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        result = Math.max(result, help(root.left, 0) + help(root.right, 0));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return result;
    }
    
    public int help(TreeNode root, int num) {
        if(root == null) return num;
        return Math.max(help(root.left, num + 1), help(root.right, num + 1));
    }
}
