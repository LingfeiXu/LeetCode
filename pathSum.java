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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum = sum - root.val;
        if(sum == 0&&root.left==null&&root.right==null)
            return true;
        if(root.left!=null) {
            if(hasPathSum(root.left,sum))
                return true;
        }
        if(root.right!=null) {
            if(hasPathSum(root.right,sum))
                return true;            
        }

        return false;
    }
}