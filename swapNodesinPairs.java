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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null)
            return head;
        ListNode result = head.next;
        ListNode nextStart = head;
        ListNode current = head;
        ListNode swap = head;
        while (current!=null && current.next!=null) {
            nextStart = current.next.next;
            current.next.next = current;
            swap.next = current.next;
            current.next = nextStart;
            swap = current;
            current = current.next;
        }
        return result;
    }
}