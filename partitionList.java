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
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return null;
        ListNode res = new ListNode(1);
        res.next = head;
        ListNode cur = head;
        ListNode pre = res;
        while(cur!=null) {
            if(cur.val>=x)
                break;
            pre = pre.next;
            cur = cur.next;
        }
        ListNode left = null, pre2 = null;
        if(cur!=null)
        	left = cur.next;
        if(cur!=null)
        	pre2 = cur;
        
        while(left!=null) {
            if(left.val<x) {
                pre2.next = left.next;
                pre.next = left;
                left.next = cur;
                pre = pre.next;
                left = pre2.next;
            } else {
                pre2 = pre2.next;
                left = left.next;
            }
        }
        return res.next;
    }
}