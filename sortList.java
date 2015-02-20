/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode fast = head, slow = head;
        while(fast.next!=null&&fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = head;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1,head2);
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode temp = new ListNode(0);
        temp.next = head1;
        ListNode current = temp;
        while (head1!=null&&head2!=null) {
            if (head1.val<head2.val) {
                head1 = head1.next;
            } else {
                ListNode pre = head2.next;
                head2.next = current.next;
                current.next = head2;
                head2 = pre;
            }
            current = current.next;
        }
        if(head2!=null)
            current.next = head2;
        
        return temp.next;
    }
}