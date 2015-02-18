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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeFast = head;
        ListNode nodeSlow = head;
        if(head.next==null)
            return null;
        for(int i=n; i>0; i--) {
            nodeFast = nodeFast.next;
        }
        if(nodeFast == null)
            return head.next;
        while(nodeFast.next != null) {
            nodeFast = nodeFast.next;
            nodeSlow = nodeSlow.next;
        }
        nodeSlow.next = nodeSlow.next.next;
        return head;
    }
}