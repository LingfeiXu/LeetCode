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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0)
            return null;
        TreeNode res = build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        return res;
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd||inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int m = root.val, i = inStart;
        while(inorder[i]!=m) {
            i++;
        }
        m = i;
        TreeNode left = build(preorder, inorder, preStart+1, preStart+m-inStart, inStart, m-1);
        TreeNode right = build(preorder, inorder, preStart+1+m-inStart, preEnd, m+1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}