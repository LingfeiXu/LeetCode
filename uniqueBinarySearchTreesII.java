/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return getTree(1,n);
    }
    
    List<TreeNode> getTree(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(left > right) {
            res.add(null);
            return res;
        }
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftList = getTree(left, i-1);
            List<TreeNode> rightList = getTree(i+1, right);
            for(int j = 0; j < leftList.size(); j++) {
                for(int k = 0; k < rightList.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    res.add(root);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                }
            }
        }
        return res;
    }
}