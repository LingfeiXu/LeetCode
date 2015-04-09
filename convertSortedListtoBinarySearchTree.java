/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    private ListNode h; 
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        h = head;
        int length = 0;
        ListNode temp = head;
        while(temp!=null) {
            length++;
            temp = temp.next;
        }
        return sortedListBST(0, length-1);
    }
    
    public TreeNode sortedListBST(int start, int end) {
        if(start>end)
            return null;
        int mid = (start + end) /2;
        
        TreeNode left = sortedListBST(start, mid-1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListBST(mid+1, end);
        
        root.left = left;
        root.right = right;
        return root;
    }
    
}