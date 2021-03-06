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
    public void recoverTree(TreeNode root) {
    	TreeNode current = root;
        TreeNode prev = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while (current != null) {
            if (current.left == null) {
                if (prev != null) {
                    if (prev.val >= current.val) {
                        if (node1 == null)
                            node1 = prev;
                        node2 = current;
                    }
                }
                prev = current;
                current = current.right;
            } else {
                TreeNode t = current.left;
                while (t.right != null && t.right != current)
                    t = t.right;
                if (t.right == null) {
                    t.right = current;
                    current = current.left;
                } else {
                    t.right = null;
                    if (prev != null) {
                        if (prev.val >= current.val) {
                            if (node1 == null)
                                node1 = prev;
                            node2 = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}