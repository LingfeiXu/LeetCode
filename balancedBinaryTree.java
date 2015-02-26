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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if (Math.abs(depth(root.left) - depth(root.right))>1)
            return false;
        if (isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }
    public int depth (TreeNode root) {
        if(root == null)
            return 0;
        int leftdep = depth(root.left), rightdep = depth(root.right);
        boolean flag = (Math.abs(leftdep - rightdep)<=1);
        if(!flag)
            return -1;
        else
            return Math.max(leftdep,rightdep)+1;
    }
}