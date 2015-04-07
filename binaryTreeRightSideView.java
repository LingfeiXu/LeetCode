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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        if(root==null)
            return res;
        list.add(root);
        while(!list.isEmpty()) {
            Queue<TreeNode> newList = new LinkedList<TreeNode>();
            boolean first = true;
            while(!list.isEmpty()) {
                TreeNode current = list.poll();
                if(first) {
                    res.add(current.val);
                    first = false;
                }
                if(current.right!=null) {
                    newList.add(current.right);
                } 
                if(current.left!=null) {
                    newList.add(current.left);
                }
            }
            list = newList;
        }
        return res;
    }
    
}