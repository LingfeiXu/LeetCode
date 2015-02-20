/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null||lists.size()==0)
            return null;
        return helper(lists,0,lists.size()-1);
    }
    
    public ListNode helper(List<ListNode> lists, int start, int end) {
        if(start<end) {
            int mid = (start+end)/2;
            return merge(helper(lists,start,mid),helper(lists,mid+1,end));
        }
        return lists.get(start);
    }
    
    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode result = new ListNode(0);
        result.next = h1;
        ListNode temp = result;
        ListNode cur = h1;
        while(h1!=null&&h2!=null) {
            if (h1.val<=h2.val) {
                h1 = h1.next;
            } else {
                cur = h2.next;
                temp.next = h2;
                h2.next = h1;
                h2 = cur;
            }
            temp = temp.next;
        }
        if(h2!=null)
            temp.next =h2;
        return result.next;
        
    }
}