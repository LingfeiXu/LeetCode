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
    private boolean flag = false;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> tempStack = new Stack<TreeNode>();
        stack.push(root);
        tempStack.push(root);
        while(!tempStack.empty()) {
            List<Integer> cur = new ArrayList<Integer>();
            tempStack = new Stack<TreeNode>();
            flag = !flag;
            while(!stack.empty()) {
                TreeNode temp = stack.pop();
                cur.add(temp.val);
                if(flag) {
	                if(temp.left!=null)
	                    tempStack.push(temp.left);
	                if(temp.right!=null)
	                    tempStack.push(temp.right);
                } else {
	                if(temp.right!=null)
	                    tempStack.push(temp.right);
	                if(temp.left!=null)
	                    tempStack.push(temp.left);
                }
            }
            res.add(cur);
            stack = tempStack;
        }
        return res;
    }
}