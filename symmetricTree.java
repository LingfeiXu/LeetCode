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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        boolean flag = isSym(root.left, root.right);
        if(flag)
            return true;
        return false;
    }
    boolean isSym(TreeNode left, TreeNode right) {
        if(left!=null&&right!=null&&left.val!=right.val) {
            return false;
        }
        if(left==null&&right==null) {
            return true;
        } else if(left==null||right==null) {
            return false;
        }
        boolean flagLeft = isSym(left.left, right.right);
        boolean flagRight = isSym(left.right, right.left);
        if(flagLeft&&flagRight&&left.val==right.val)
            return true;
        return false;
    }
}