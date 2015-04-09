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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0)
            return null;
        int len = num.length;
        TreeNode root = arrayListToBST(num, 0, len-1);
        return root;
    }
    
    public TreeNode arrayListToBST(int[] num, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(num[mid]);
        TreeNode left = arrayListToBST(num, start, mid - 1);
        TreeNode right = arrayListToBST(num, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}