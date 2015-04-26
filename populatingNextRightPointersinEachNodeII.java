/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        if(root!=null) {
            root.next = null;
            nextRight(root);
        }
    }
    public void nextRight(TreeLinkNode root) {
    	if(root==null)
    		return;
        while(root!=null) {
            if(root.left!=null)
                stack.push(root.left);
            if(root.right!=null)
                stack.push(root.right);
            root = root.next;
        }
        TreeLinkNode pre = null;
        while(!stack.empty()) {
            TreeLinkNode temp = stack.pop();
            temp.next = pre;
            pre = temp;
        }
        nextRight(pre);
    }
}