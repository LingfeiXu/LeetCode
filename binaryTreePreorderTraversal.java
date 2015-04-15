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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null) {
                stack.push(cur.right);
            }
            if(cur.left!=null) {
                stack.push(cur.left);
            }
        }
        return res;
    }
}