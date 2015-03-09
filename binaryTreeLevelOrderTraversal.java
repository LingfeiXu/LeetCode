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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(root.val);
        res.add(pre);
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        int i = 0;
        while(level.size()!=0) {
            List<Integer> cur = new ArrayList<Integer>();
            List<TreeNode> nLevel = new ArrayList<TreeNode>();
            i = 0;
            while(i < level.size()) {
                TreeNode cl = level.get(i);
                if(cl.left!=null) {
                    cur.add(cl.left.val);
                    nLevel.add(cl.left);
                }
                if(cl.right!=null) {
                    cur.add(cl.right.val);
                    nLevel.add(cl.right);
                }
                i++;
            }
            if(cur.size()>0)
                res.add(cur);
            level = new ArrayList<TreeNode>(nLevel);
        }
        return res;
    }
}