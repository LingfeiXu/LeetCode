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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] total = new int[1];
        total[0] = Integer.MIN_VALUE;
        getSum(root,total);
        return total[0];
    }
    
    public int getSum(TreeNode root, int[] total) {
        if (root==null)
            return 0;
        int left = getSum(root.left, total);
        int right = getSum(root.right, total);
        int arch =  root.val + left + right;
        int single = Math.max(root.val, Math.max(left,right)+root.val);
        total[0] = Math.max(total[0], Math.max(arch,single));
        return single;
    }
}