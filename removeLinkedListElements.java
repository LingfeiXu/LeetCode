/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        while(cur!=null) {
            if(cur.val!=val) {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
            if(cur==null)
                pre.next = null;
        }
        return res.next;
    }
}