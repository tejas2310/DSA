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
    static int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        recurBT(root);
        return result;
    }
    public int recurBT(TreeNode root){
        if(root == null) return 0;
        int left = recurBT(root.left);
        int right = recurBT(root.right);
        result = Math.max(result, left + right);
        return 1 + Math.max(left,right);
    }
}