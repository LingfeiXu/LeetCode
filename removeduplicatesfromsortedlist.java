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
        if(head == null||head.next == null)
            return head;
        ListNode current = head;
        ListNode previous = head;
        int duplicate = head.val;
        do {
            current = current.next;
            if(current.val == duplicate) {
                previous.next = current.next;
            }
            else {
                duplicate = current.val;
                previous = current;
            }
        } 
        while(current.next!=null);
        return head;
    }
}