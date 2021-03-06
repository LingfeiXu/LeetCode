/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        if(root!=null) {
            root.next = null;
            nextRight(root);
        }
    }
    public void nextRight(TreeLinkNode root) {
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next!=null) {
                root.right.next = root.next.left;
            } else {
                root.right.next = null;
            }
            nextRight(root.left);
            nextRight(root.right);
        }        
    }
}