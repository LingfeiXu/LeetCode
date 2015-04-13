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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode cur = head;
        ListNode res = new ListNode(0);
        ListNode pre = res;
        int temp = cur.val + 1;
        while(cur!=null) {
            if(cur.next!=null) {
            	if(cur.val==temp) {
            		
            	} else if(cur.val==cur.next.val) {
                    cur = cur.next;
                } else {
                	pre.next = new ListNode(cur.val);
                	pre = pre.next;
                }
                temp = cur.val;
                cur = cur.next;
            } else {
            	if(cur.val!=temp) {
                	pre.next = new ListNode(cur.val);
                	pre = pre.next;
            	}
            	cur = cur.next;
            }
        }
        return res.next;
    }
}