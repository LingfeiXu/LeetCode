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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> secondLevelResult = new ArrayList<Integer>();
        sum(root, sum, secondLevelResult, result);
        return result;
    }
    
    public void sum(TreeNode currentNode, int sum, List<Integer> secLvlRes, List<List<Integer>> res) {
        if(currentNode == null) {
            return;
        }
        if(currentNode.val==sum && currentNode.left==null && currentNode.right==null) {
            secLvlRes.add(currentNode.val);
            res.add(new ArrayList<Integer>(secLvlRes));
            secLvlRes.remove(secLvlRes.size()-1);
            return;
        }
        secLvlRes.add(currentNode.val);
        sum(currentNode.left, sum-currentNode.val, secLvlRes, res);
        sum(currentNode.right, sum-currentNode.val, secLvlRes, res);
        secLvlRes.remove(secLvlRes.size()-1);
    }
}