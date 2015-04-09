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
    private TreeNode lastVisit = null;
    public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode savedRight = root.right;
		if (lastVisit != null) {
			lastVisit.left = null;
			lastVisit.right = root;
		}
		lastVisit = root;
		flatten(root.left);
		flatten(savedRight);
	}
}