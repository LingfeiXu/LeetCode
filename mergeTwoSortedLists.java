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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode result = res;
        while ( (l1!=null)&&(l2!=null) ) {
            if(l1.val>l2.val) {
                res.next.val = l2.val;
                l2 = l2.next;
            } else {
                res.next.val = l1.val;
                l1 = l1.next;
            }
            res = res.next;
        }
        if(l1!=null)
            res.next = l1;
        if(l2!=null)
            res.next = l2;
        
        return result.next;
    }
}