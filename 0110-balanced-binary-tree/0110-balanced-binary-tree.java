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
    static boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
        recurBT(root);
        return result;
    }
    public int recurBT(TreeNode root) {
        if(root == null) return 0;
        int left = recurBT(root.left);
        int right = recurBT(root.right);

        if(!(Math.abs(left-right) <= 1)) result = false;
        return 1 + Math.max(left,right); 

    }
}