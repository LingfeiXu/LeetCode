/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left!=null) {
            left = minDepth(root.left);
        }
        if(root.right!=null) {
            right = minDepth(root.right);
        }
        if(root.left!=null||root.right!=null)
            return (left>right?right:left)+1;
        return 1;
    }
}